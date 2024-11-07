package com.gameengine.system.utils;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmlUtils {
    public static final String XML_ELEMENT_NAME = "ItemSpec";
    public static List<Map<String,String>> getXMLFile(String path) {
        String userPath = System.getProperty("user.dir");
        File xmlPath = new File(userPath+"/config/"+path+".xml");
        SAXReader reader = new SAXReader();
        int autoId =0;
        List< Map<String, String>> allItemList = new ArrayList<>();
        if(xmlPath.isFile()) {
            try {
                Document document = reader.read(xmlPath);
                Element rootElement = document.getRootElement();
                List<Element> elements = rootElement.elements();
                Iterator<?> iter = elements.iterator();

                while(iter.hasNext()) {
                    autoId++;
                    Element tmpElement = (Element)iter.next();
                    if (!XML_ELEMENT_NAME.equals(tmpElement.getQName().getName())) {
                        continue;
                    }
                    ConcurrentHashMap<String, String> itemValueMap = new ConcurrentHashMap<>();
                    for(Iterator<?> it = tmpElement.attributeIterator(); it.hasNext();) {
                        Attribute tmpAttr = (Attribute)it.next();
                        itemValueMap.put(tmpAttr.getName(), tmpAttr.getValue());
                    }
                    String id = itemValueMap.get("id");
                    if(id == null){
                        id = String.valueOf(autoId);
                        itemValueMap.put("id",id);
                    }
                    allItemList.add( itemValueMap);
                }
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            }
        }

        return allItemList;
    }
}
