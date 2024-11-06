package com.tool.utils;

import com.google.common.collect.Lists;
import com.tool.config.ColData;
import com.tool.config.ConfigDataType;
import com.tool.config.SheetData;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;

public class ExcelUtil {

    private final static int startCol = 2;

    public static Map<String, SheetData> readeExcelData(File file, Function<String, Boolean> filter) throws IOException {
        InputStream inputStream = Files.newInputStream(file.toPath());
        Map<String, SheetData> sheets = new HashMap<>();
        Workbook workbook = WorkbookFactory.create(inputStream);
        int numberOfSheets = workbook.getNumberOfSheets();


        for (int n = 0; n < numberOfSheets; n++) {
            List<Integer> indexs = Lists.newArrayList();
            Sheet sheet = workbook.getSheetAt(n);
            String sheetName = sheet.getSheetName();
            if (sheetName.startsWith("$") || sheetName.toLowerCase().startsWith("sheet")) {
                break;
            }

            if (filter != null && !filter.apply(sheetName.replace("_", ""))) {
                continue;
            }

            Row sheetType = sheet.getRow(0);
            if (sheetType == null) {
                continue;
            }
            String cellFormatValue = getCellFormatValue(sheetType.getCell(0));
            String saveOld = getCellFormatValue(sheetType.getCell(1));
            SheetData data = new SheetData();
            List<ColData> colInfo = data.getColInfo();
            sheets.put(sheetName, data);
            List<List<ColData>> datas = Lists.newArrayList();
            List<List<ColData>> enumDatas = Lists.newArrayList();
            data.setData(datas);
            data.setEnumDatas(enumDatas);

            if("1".equals(saveOld)) {
                data.setSaveOld(true);
            }
            int headerNumber = 6;
            if ("3".equals(cellFormatValue)) {
                data.setType(3);
                Row content;
                List<ColData> list = Lists.newArrayList();
                Row cs = sheet.getRow(headerNumber - 3);
                if (!getCellFormatValue(cs.getCell(2)).toLowerCase().contains("s")) {
                    continue;
                }
                for (int i = 7; i <= sheet.getLastRowNum(); i++) {

                    content = sheet.getRow(i);
                    if (content == null) {
                        continue;
                    }
                    String name = getCellFormatValue(content.getCell(4));
                    if (name.isEmpty()) {
                        continue;
                    }
                    String desc = getCellFormatValue(content.getCell(3));
                    String value = getCellFormatValue(content.getCell(2));

                    if (!(StringUtils.isEmpty(value) || StringUtils.isBlank(value))) {
                        int enumMax = Integer.parseInt(value);
                        if (enumMax > data.getEnumMax()) {
                            data.setEnumMax(enumMax);
                        }
                        list.add(new ColData(name.toUpperCase(), "", desc, value));
                    }
                }

                enumDatas.add(list);
            }
            Object2IntOpenHashMap<String> kv = new Object2IntOpenHashMap<>();
            if ("0".equals(cellFormatValue) || "3".equals(cellFormatValue)) {
                data.setType(Integer.parseInt(cellFormatValue));
                Row header = sheet.getRow(headerNumber);
                if (header == null) {
                    continue;
                }
                Row comment = sheet.getRow(headerNumber - 1);
                Row type = sheet.getRow(headerNumber - 2);
                Row cs = sheet.getRow(headerNumber - 3);
                Row keyRow = sheet.getRow(headerNumber - 4);

                int rowStart = headerNumber + 1;

                boolean hasKey = false;
                //获取标题信息
                List<Integer> keys = new ArrayList<>();
                for (int i = startCol; i <= header.getLastCellNum(); i++) {
                    Cell cell = header.getCell(i);
                    String titleValue = getCellFormatValue(cell);
                    Cell cellCs = cs.getCell(i);

                    if (!getCellFormatValue(cellCs).toLowerCase().contains("s")) {
                        continue;
                    }

                    boolean key = "key".equalsIgnoreCase(getCellFormatValue(keyRow.getCell(i)));
                    if (key) {
                        keys.add(i);
                    }
                    if (!StringUtils.isEmpty(titleValue)) {
                        Cell typeCell = type.getCell(i);
                        String typeValue = getCellFormatValue(typeCell);
                        Cell commentCell = comment.getCell(i);
                        colInfo.add(new ColData(titleValue, typeValue, getCellFormatValue(commentCell), key));
                        indexs.add(i);
                    }
                }

                if (indexs.size() <= 0) {
                    continue;
                }

                if (keys.isEmpty()) {
                    System.out.printf("sheet:%s没有key%n", sheetName);
                    continue;
                } else if (indexs.size() - keys.size() == 0) {
                    System.out.printf("sheet:%s,只有主键列%n", sheetName);
                    continue;
                }

//				System.out.println("head size="+colInfo.size());
                //获取内容信息
                StringBuilder sb = new StringBuilder();
                for (int i = rowStart; i <= sheet.getLastRowNum(); i++) {
                    Row currentRow = sheet.getRow(i);
                    if (Objects.isNull(currentRow)) {
                        continue;
                    }
                    List<ColData> dataList = Lists.newArrayList();
                    boolean blankRow = false;
                    for (Integer key : keys) {
                        String cellFormatValue1 = getCellFormatValue(currentRow.getCell(key, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
                        if (StringUtils.isBlank(cellFormatValue1)) {
                            blankRow = true;
                            break;
                        }
                        sb.append(cellFormatValue1).append("-");
                    }
                    if (blankRow) {
                        continue;
                    }else {
                        String key = sb.toString();
                        if(kv.containsKey(key)) {
                            System.out.printf("sheet:%s row:%s row:%s key repeated \n", sheetName,kv.getInt(key),i+1);
                            throw new RuntimeException();
                        }else{
                            kv.put(sb.toString(),i+1);
                        }
                        sb.delete(0,sb.length());
                    }

                    int num = 0;
                    for (Integer index : indexs) {
                        Cell valueCell = currentRow.getCell(index, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        ColData colData = colInfo.get(num).clone();
                        num++;

                        colData.setValue(getCellFormatValue(valueCell));

                        if (checkDataError(sheetName, i, dataList, index, colData)) {
                            break;
                        }
                    }
                    if (dataList.isEmpty()) {
                        datas.clear();
                        break;
                    }
                    datas.add(dataList);
                }
            } else if ("1".equals(cellFormatValue)) {
                data.setType(1);
                Row content = null;
                data.setVertical(true);
                List<ColData> list = Lists.newArrayList();
                Set<String> names = new HashSet<String>();
                for (int i = 2; i <= sheet.getLastRowNum(); i++) {

                    content = sheet.getRow(i);
                    if (content == null) {
                        continue;
                    }
                    String cs = getCellFormatValue(content.getCell(6));
                    if (!cs.toLowerCase().contains("s")) {
                        continue;
                    }
                    String name = getCellFormatValue(content.getCell(2));
                    if ("".equals(name)) {
                        continue;
                    }
                    if(names.contains(name)) {
                        WarnUtil.warn("重复的key，sheet: %s,row: %d,col: %d,key: %s%n", sheetName, i + 1, 2, name);
                        System.out.printf("重复的key，sheet: %s,row: %d,col: %d,key: %s%n", sheetName, i + 1, 2, name);
                        break;
                    }
                    names.add(name);
                    String desc = getCellFormatValue(content.getCell(3));
                    String type = getCellFormatValue(content.getCell(4));
                    String value = getCellFormatValue(content.getCell(5));
                    if (checkDataError(sheetName, i, list, 5, new ColData(name, type, desc, value))) {
                        break;
                    }

                }
                if (list.size() > 0) {
                    datas.add(list);
                }
            }
        }
        //关闭会造成，excel被修改，先不关闭
//		workbook.close();
        inputStream.close();
        return sheets;
    }

    private static boolean checkDataError(String sheetName, int i, List<ColData> dataList, Integer index, ColData colData) {
        try {
            ConfigDataType dataType = ConfigDataType.getType(colData.getType());
            if (dataType == null) {
                return false;
            }
            dataType.getFunction().apply(colData.getValue());
            dataList.add(colData);
        } catch (Exception e) {
            dataList.clear();
            e.printStackTrace();
            WarnUtil.warn("数据格式非法，sheet: %s,row: %d,col: %d,type: %s,value: %s%n", sheetName, i + 1, index + 1, colData.getType(), colData.getValue());
            System.out.printf("数据格式非法，sheet: %s,row: %d,col: %d,type: %s,value: %s%n", sheetName, i + 1, index + 1, colData.getType(), colData.getValue());
            return true;
        }
        return false;
    }

    public static String getCellFormatValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                case NUMERIC : {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    BigDecimal bigDecimal = new BigDecimal(cellValue);
                    cellValue = bigDecimal.stripTrailingZeros().toPlainString();
                    break;
                }
                case FORMULA : {
                    try {
                        BigDecimal decimal = BigDecimal.valueOf(cell.getNumericCellValue());
                        cellValue = decimal.stripTrailingZeros().toPlainString();
                    } catch (IllegalStateException e) {
                        try {
                            cellValue = String.valueOf(cell.getRichStringCellValue());
                        } catch (IllegalStateException e1) {
                            cellValue = "";
                        }
                    }
                    break;
                }
                case STRING : {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default : cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue.trim();
    }
}
