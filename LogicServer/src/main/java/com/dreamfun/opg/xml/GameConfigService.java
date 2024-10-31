package com.dreamfun.opg.xml;

import com.dreamfun.opg.utils.GameLoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.util.*;


public class GameConfigService {
    private static final Logger logger = GameLoggerFactory.getLogger(GameConfigService.class);
    private String fileName;
    private File file;

    private static final List<Map<String,String>> emptyList = new ArrayList<>(0);

    public static void init() {
//        GameConfigLoader.loadXml();
    }

    public GameConfigService(String fileName) {
        this.fileName = fileName;
    }

    public static String getGroupCacheKey(String fileName, String groupName) {
        return fileName + "-" + groupName;
    }

    public static String getItemCacheKey(String fileName, String itemId) {
        return fileName + "-" + itemId;
    }

    public Map<String, String> getItem(String itemId) {
        Map<String, String> configMap;
        configMap = LocalGameConfigCache.getInstance().getItem(getItemCacheKey(fileName, itemId));
        if (configMap == null) {
            configMap = new HashMap<>();
        }
        return configMap;
    }

    public List<Map<String, String>> getGroup(String groupName) {
        List<Map<String, String>> configGroupList;
            Collection<Map<String, String>> data = LocalGameConfigCache.getInstance().getGroup(getGroupCacheKey(fileName, groupName));
            if(data==null){
                configGroupList = emptyList;
            } else {
                configGroupList = newList(data);
            }
        return configGroupList;
    }

    public Map<String, Map<String, String>> getGroupWithId(String groupName) {
        List<Map<String, String>> configGroupList = getGroup(groupName);
        Map<String, Map<String, String>> configGroupHashMap = new HashMap<>();
        for (Map<String, String> config: configGroupList) {
            if (config.containsKey("id")) {
                configGroupHashMap.put(config.get("id"), config);
            }
        }
        return configGroupHashMap;
    }

    public List<Map<String, String>> getAll() {
        List<Map<String, String>> allConfigList;
        Collection<Map<String, String>> data = LocalGameConfigCache.getInstance().getGroup(getGroupCacheKey(fileName, LocalGameConfigCache.ALL_ITEM_KEY));
        if (data == null) {
            allConfigList = emptyList;
        } else {
            allConfigList = newList(data);
        }
        return allConfigList;
    }

    private List<Map<String, String>> newList(Collection<Map<String, String>> configGroupList) {
        List<Map<String, String>> cloneList = new LinkedList<>();
        if (configGroupList != null) {
            for (Map<String, String> configMap : configGroupList) {
                cloneList.add(Collections.unmodifiableMap(configMap));
            }
        }
        return Collections.unmodifiableList(cloneList);
    }
}
