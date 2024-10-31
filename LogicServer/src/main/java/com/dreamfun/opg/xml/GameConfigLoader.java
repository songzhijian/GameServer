package com.dreamfun.opg.xml;

import com.dreamfun.opg.utils.Constants;
import com.dreamfun.opg.utils.GameLoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.util.*;

/**
 * @date 2024-03-14
 */
public class GameConfigLoader {
//    private static final Logger logger = GameLoggerFactory.getLogger(GameConfigLoader.class);
//
//    public static void loadXml() {
//        String xmlResourcePath = "resource/";//TODO
//        File xmlPath = new File(xmlResourcePath);
//        if(xmlPath.isDirectory()) {
//
//            String fileName = null;
//            try {
//
//                Document document;
//                SAXReader reader = new SAXReader();
//
//                File[] xmlFiles = xmlPath.listFiles(file -> {
//                    String fileName1 = file.getName();
//                    if(!fileName1.matches("^.+\\.xml$")) {
//                        return false;
//                    } else {
//                        return true;
//                    }
//                });
//
//                if (xmlFiles == null){
//                    logger.error("xmlFiles is null!!!!!" );
//                    return;
//                }
//
//                LocalGameConfigCache.getInstance().copyInRefresh();
//
//                for(File file : xmlFiles) {
//                    fileName = file.getName();
//                    document = reader.read(file);
//                    fileName = fileName.substring(0, fileName.length() - 4);
//                    logger.info("put xml {} to cache", fileName);
//                    putXMLToCache(fileName, document);
//                }
//
//                LocalGameConfigCache.getInstance().setRefreshCache(false);
//                LocalGameConfigCache.getInstance().clearBakData();
//                logger.info("loading xml is ready");
//
//            } catch (DocumentException e) {
//                logger.info("loading xml is error", e);
//                throw new RuntimeException(String.format("load %s error!", fileName));
//            } catch(RuntimeException re) {
//                logger.info("loading xml is error", re);
//                throw new RuntimeException(re);
//            }
//        }
//    }
//
//    /**
//     * 根据group
//     * @param fileName
//     * @param document
//     */
//    private static void putXMLToCache(String fileName, Document document) {
//        Element rootElement = document.getRootElement();
//        List<?> groupElements = rootElement.elements("Group");
//        if(groupElements.size() > 0) {
//            putGroupToCache(fileName, groupElements);
//        } else {
//            List<?> elements = rootElement.elements();
//            putItemsToCache(fileName, elements);
//        }
//    }
//
//    /**
//     * 无group
//     * @param fileName
//     * @param elements
//     */
//    private static void putItemsToCache(String fileName, List<?> elements) {
//        boolean hasError = false;
//        LocalGameConfigCache gameConfigCache = LocalGameConfigCache.getInstance();
//        Iterator<?> iterator = elements.iterator();
//        LinkedHashMap<String, Map<String, String>> allItemList = new LinkedHashMap<>();
//        while(iterator.hasNext()) {
//            Element tmpElement = (Element)iterator.next();
//            if (!Constants.XML_ELEMENT_NAME.equals(tmpElement.getQName().getName())) {
//                continue;
//            }
//            HashMap<String, String> itemValueMap = new HashMap<>();
//            for(Iterator<?> it = tmpElement.attributeIterator(); it.hasNext();) {
//                Attribute tmpAttr = (Attribute)it.next();
//                itemValueMap.put(tmpAttr.getName(), tmpAttr.getValue());
//            }
//            gameConfigCache.putItemValue(GameConfigService.getItemCacheKey(fileName,
//                    tmpElement.attributeValue("id")), itemValueMap);
//            String id = itemValueMap.get("id");
//            if(id == null){
//                hasError = true;
//            }
//            allItemList.put(id, itemValueMap);
//        }
//        gameConfigCache.putGroupValue(GameConfigService.getItemCacheKey(fileName,
//                LocalGameConfigCache.ALL_ITEM_KEY), allItemList);
//        if(hasError){
//            logger.error("error! not exist id xml name: "+fileName);
//        }
//
//    }
//
//    /**
//     * 有group
//     * @param fileName
//     * @param groupElements
//     */
//    private static void putGroupToCache(String fileName, List<?> groupElements) {
//        boolean hasError = false;
//        LocalGameConfigCache gameConfigCache = LocalGameConfigCache.getInstance();
//        LinkedHashMap<String,Map<String, String>> allItemList = new LinkedHashMap<>();
//        for(Object obj : groupElements) {
//            Element groupElement = (Element)obj;
//            String groupName = groupElement.attribute("id").getValue();
//            LinkedHashMap<String,Map<String, String>> groupItemList = new LinkedHashMap<>();
//            for(Iterator<?> iterator = groupElement.elementIterator(); iterator.hasNext();) {
//                Element tmpElement = (Element)iterator.next();
//                if (!Constants.XML_ELEMENT_NAME.equals(tmpElement.getQName().getName())) {
//                    continue;
//                }
//                HashMap<String, String> itemValueMap = new HashMap<>();
//                for(Iterator<?> it = tmpElement.attributeIterator(); it.hasNext();) {
//                    Attribute tmpAttr = (Attribute)it.next();
//                    itemValueMap.put(tmpAttr.getName(), tmpAttr.getValue());
//                }
//                String id = itemValueMap.get("id");
//                if(id==null){
//                    hasError = true;
//                }
//                groupItemList.put(id,itemValueMap);
//                allItemList.put(id,itemValueMap);
//                gameConfigCache.putItemValue(GameConfigService.getItemCacheKey(fileName,
//                        tmpElement.attributeValue("id")), itemValueMap);
//            }
//            gameConfigCache.putGroupValue(GameConfigService.getGroupCacheKey(fileName, groupName), groupItemList);
//        }
//
//        if(hasError){
//            logger.error("error! not exist id xml name: "+fileName);
//        }
//        gameConfigCache.putGroupValue(GameConfigService.getItemCacheKey(fileName,
//                LocalGameConfigCache.ALL_ITEM_KEY), allItemList);
//    }
}
