package com.tool.config;

import com.tool.Tool;
import com.tool.utils.ExcelUtil;
import com.tool.utils.FileUtil;
import com.tool.utils.TemplateUtil;
import com.tool.utils.WarnUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameConfigGen {

    private static String inPath = null;
    private static String xmlOutPath = null;
    private static String xmlOutClientPath = null;
    private static String javaOutPath = null;
    private static String tempPath = null;

    private static final String packageName = "com.im30.esg.config.";

    private static boolean isAll = false;
    private static String[] names = null;

    public static void genCrossSheet(String[] args) {
        String path = System.getProperty("user.dir");

        if (args.length < 2) {
            System.out.println("config生成参数不足");
            return;
        }
        if ("all".equalsIgnoreCase(args[1])) {
            isAll = true;
        }

        if (!isAll) {
            names = args[1].replaceAll("_","").split(",");
        }

        if (args.length == 3) {
            inPath = args[2];
        }

        System.out.println("path:" + path + "-inPath:" + inPath);
        if (path.endsWith(File.separator + "ESGTool")) {
            if (inPath == null) {
                inPath = path + "/../../UW/branches/develop/develop";
            }
            xmlOutPath = path + "/../ESGProject/config/";
            javaOutPath = path + "/../ESGProject/esg-config/src/main/java/";
            tempPath = path + "/src/main/resources/template";

        } else if (path.endsWith(File.separator + "tool")) {
            if (inPath == null) {
                inPath = path + "/../../UW/branches/develop/develop";
            }
            xmlOutPath = path + "/../ESGProject/config/";
            javaOutPath = path + "/../ESGProject/esg-config/src/main/java/";
            tempPath = path + "/lib/template";
        } else if (path.endsWith(File.separator + "release")) {
            if (inPath == null) {
                inPath = path + "/trunk/";
            }
            System.out.println(inPath);
            xmlOutClientPath = path + "/serverOnlineXML/";
            tempPath = path + "/../_lib/template";
            if (Tool.isLinux()) {
                WarnUtil.open = true;
            }
        } else if (path.contains(File.separator + "online") || path.endsWith(File.separator + "develop") || path.contains(File.separator + "local")) {
            if (inPath == null) {
                inPath = path + "/";
            }
            xmlOutClientPath = path + "/serverXml/";
            tempPath = path + "/../../_lib/template";
            if (Tool.isLinux()) {
                WarnUtil.open = true;
            }
        } else {
            if (inPath == null) {
                inPath = path + "/";
            }
            xmlOutClientPath = path + "/serverXml/";
            tempPath = path + "/../_lib/template";
            if (Tool.isLinux()) {
                WarnUtil.open = true;
            }
        }

        List<File> files = new ArrayList<>();
        FileUtil.getFileList(new File(inPath), files);
        System.out.println("excel文件数量：" + files.size());
        for (File file : files) {
            try {
                if (file.getName().contains("~$")) {
                    continue;
                }
                if (file.getName().endsWith(".xlsx") || file.getName().endsWith(".xlsm")) {
                    System.out.println(file.getName());
                    Map<String, SheetData> sheetsMap = ExcelUtil.readeExcelData(file, GameConfigGen::check);
                    genEnum(sheetsMap);
                    genXML(sheetsMap);
                    if (javaOutPath != null) {
                        genConfigClass(sheetsMap);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void genBBCrossSheet(String[] args) {
        String path = System.getProperty("user.dir");

        if (args.length < 2) {
            System.out.println("config生成参数不足");
            return;
        }

        if ("all".equalsIgnoreCase(args[1])) {
            isAll = true;
        }

        if (!isAll) {
            names = args[1].split(",");
        }

        if (args.length >= 3) {
            inPath = args[2];
        }

        if (args.length >= 4) {
            xmlOutPath = args[3];
        }

        System.out.println("path:" + path);
        if (path.endsWith(File.separator + "ESGTool")) {
            if (inPath == null) {
                inPath = path + "/../../smallball001/trunk/";
            }
            xmlOutPath = path + "/../../CasualGameServer/DeedleDoodleProject/config/";
            javaOutPath = path + "/../../CasualGameServer/DeedleDoodleProject/esg-config/src/main/java/";
            tempPath = path + "/src/main/resources/template";

        } else if (path.endsWith(File.separator + "tool")) {
            if (inPath == null) {
                inPath = path + "/../../smallball001/trunk/";
            }
            if (xmlOutPath == null) {
                xmlOutPath = path + "/../../CasualGameServer/DeedleDoodleProject/config/";
            }
            javaOutPath = path + "/../../CasualGameServer/DeedleDoodleProject/esg-config/src/main/java/";
            tempPath = path + "/lib/template";
        } else {
            if (inPath == null) {
                inPath = path + "/../配置表/";
            }
            xmlOutClientPath = path + "/../../uwcommon/plan/xml/";
            tempPath = path + "/lib/template";
            if (Tool.isLinux()) {
                WarnUtil.open = true;
                WarnUtil.index = 1;
            }
        }

        System.out.println(inPath);
        System.out.println(xmlOutPath);
        System.out.println(javaOutPath);
        List<File> files = new ArrayList<>();

        FileUtil.getFileList(new File(inPath), files);
        System.out.println(files.size());
        for (File file : files) {
            try {
                if ((file.getName().endsWith(".xlsx") || file.getName().endsWith(".xlsm")) && !file.getName().startsWith("~$")) {
                    Map<String, SheetData> sheetsMap = ExcelUtil.readeExcelData(file, GameConfigGen::check);
                    genEnum(sheetsMap);
                    genXML(sheetsMap);
                    if (javaOutPath != null) {
                        genConfigClass(sheetsMap);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


    private static void genEnum(Map<String, SheetData> sheetsMap) {
        Map<String, Object> dataMap = new HashMap<>();

        for (Map.Entry<String, SheetData> entry : sheetsMap.entrySet()) {
            if (entry.getValue().getEnumDatas() == null || entry.getValue().getEnumDatas().isEmpty()) {
                continue;
            }
            String fileName = entry.getKey().replace("_", "");
            dataMap.put("rowList", entry.getValue().getEnumDatas());
            dataMap.put("name", fileName);
            dataMap.put("size", entry.getValue().getEnumMax() + 1);
            if (javaOutPath != null) {
                TemplateUtil.make(tempPath, "configEnum.java.ftl",
                        javaOutPath + "com/im30/esg/config/type/" + fileName + ".java", dataMap);
            }
        }
    }

    private static boolean check(String name) {
        if (isAll) {
            return true;
        }

        for (String sheetName : names) {
            if (sheetName.equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    private static void genConfigClass(Map<String, SheetData> sheetsMap) {
        Map<String, Object> dataMap = new HashMap<>();
        for (Map.Entry<String, SheetData> entry : sheetsMap.entrySet()) {
            if (entry.getValue().getType() != 1 && entry.getValue().getColInfo().size() < 2) {
                continue;
            }
            if (entry.getValue().isVertical()) {
                genVerticalSheet(dataMap, entry);
            } else {
                genCrossSheet(dataMap, entry);
            }
        }
    }

    private static void genConfigCustomLoader(Map<String, Object> dataMap, Map.Entry<String, SheetData> entry) {

    }

    private static void genVerticalSheet(Map<String, Object> dataMap, Map.Entry<String, SheetData> entry) {
        String key = entry.getKey();
        SheetData value = entry.getValue();
        ConfigTemplate template = new ConfigTemplate(key, packageName);
        template.setSaveOld(value.isSaveOld());
        if (value.getData().isEmpty()) {
            return;
        }
        List<ColData> colInfo = value.getData().get(0);
        for (ColData colData : colInfo) {

            template.addColumn(colData);
        }

        dataMap.put("template", template);

        TemplateUtil.make(tempPath, "configV.java.ftl", javaOutPath
                + template.getEntityPackageName().replace(".", File.separator)
                + File.separator + template.getClassName() + ".java", dataMap);
        TemplateUtil.make(tempPath, "configLoaderV.java.ftl", javaOutPath
                + template.getLoaderPackageName().replace(".", File.separator)
                + File.separator + template.getLoaderName() + ".java", dataMap);

        genConfigCustomLoader(dataMap, template);

    }

    private static void genConfigCustomLoader(Map<String, Object> dataMap, ConfigTemplate template) {
        String customs = javaOutPath + template.getCustomLoaderPackageName().replace(".", File.separator)
                + File.separator + template.getClassName() + "CustomLoader.java";

        if (!new File(customs).exists()) {
            TemplateUtil.make(tempPath, "configCustomLoader.java.ftl", customs, dataMap);
        }
    }

    private static void genCrossSheet(Map<String, Object> dataMap, Map.Entry<String, SheetData> entry) {
        String key = entry.getKey();
        SheetData value = entry.getValue();
        ConfigTemplate template = new ConfigTemplate(key, packageName);
        template.setSaveOld(value.isSaveOld());
        List<ColData> colInfo = value.getColInfo();
        for (ColData colData : colInfo) {

            template.addColumn(colData);
        }
        if (template.getKeyType() == null) {
            System.out.println(template.getClassName() + "key column is miss");
            return;
        }
        dataMap.put("template", template);

        TemplateUtil.make(tempPath, "config.java.ftl", javaOutPath
                + template.getEntityPackageName().replace(".", File.separator)
                + File.separator + template.getClassName() + ".java", dataMap);
        TemplateUtil.make(tempPath, "configLoader.java.ftl", javaOutPath
                + template.getLoaderPackageName().replace(".", File.separator)
                + File.separator + template.getLoaderName() + ".java", dataMap);

        genConfigCustomLoader(dataMap, template);
    }


    private static void genXML(Map<String, SheetData> sheetsMap) {
        Map<String, Object> dataMap = new HashMap<>();

        for (Map.Entry<String, SheetData> entry : sheetsMap.entrySet()) {
            if (entry.getValue().getType() != 1 && entry.getValue().getColInfo().size() < 2) {
                continue;
            }
            dataMap.put("sheetType", entry.getValue().isVertical());
            dataMap.put("rowList", entry.getValue().getData());
            if (xmlOutPath != null) {
                TemplateUtil.make(tempPath, "xml.ftl", xmlOutPath + entry.getKey() + ".xml", dataMap);
            }
            if (xmlOutClientPath != null) {
                TemplateUtil.make(tempPath, "xml.ftl", xmlOutClientPath + entry.getKey() + ".xml", dataMap);
            }
        }

    }

}
