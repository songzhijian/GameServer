package com.dreamfun.opg.xml;

import com.dreamfun.opg.utils.GameLoggerFactory;
import org.slf4j.Logger;

import java.util.*;

public class LocalGameConfigCache {
    private static Logger logger = GameLoggerFactory.getLogger(LocalGameConfigCache.class);
    private static LocalGameConfigCache instance;

    //是否在更新配置
    private volatile boolean isRefreshCache = false;
    private Map<String, Map<String, String>> gameConfigItemMap;
    private Map<String, LinkedHashMap<String,Map<String, String>>> gameConfigGroupMap;

    //配置缓存临时指针，在更新配置时使用
    private Map<String, Map<String, String>> gameConfigItemMapBak = null;
    private Map<String, LinkedHashMap<String,Map<String, String>>> gameConfigGroupMapBak = null;

    public final static String ALL_ITEM_KEY = "all_items_in_file";

    private static ArrayList<Map<String, String>> emptyData = new ArrayList<>();

    public static LocalGameConfigCache getInstance() {
        if(instance == null) {
            instance = new LocalGameConfigCache();
        }
        return instance;
    }

    public boolean isRefreshCache() {
        return isRefreshCache;
    }

    public void setRefreshCache(boolean isRefreshCache) {
        this.isRefreshCache = isRefreshCache;
    }

    public void clear() {
        gameConfigGroupMap.clear();
        gameConfigItemMap.clear();
    }
    private LocalGameConfigCache() {
        gameConfigItemMap = new HashMap<>();
        gameConfigGroupMap = new HashMap<>();
    }

    public Map<String, String> getItem(String itemCacheKey) {
        return isRefreshCache ? gameConfigItemMapBak.get(itemCacheKey) : gameConfigItemMap.get(itemCacheKey);
    }

    public void putItemValue(String itemKey, Map<String, String> itemValue) {
        gameConfigItemMap.put(itemKey, itemValue);
    }

    public Collection<Map<String, String>> getGroup(String groupCacheKey) {
        return isRefreshCache ? (gameConfigGroupMapBak.containsKey(groupCacheKey)?
                gameConfigGroupMapBak.get(groupCacheKey).values() : emptyData):
                (gameConfigGroupMap.containsKey(groupCacheKey)?gameConfigGroupMap.get(groupCacheKey).values(): emptyData);
    }

    public void putGroupValue(String groupKey, LinkedHashMap<String, Map<String, String>> groupValue) {
        gameConfigGroupMap.put(groupKey,  groupValue);
    }

    public void copyInRefresh() {
        if(isRefreshCache){
            gameConfigItemMap = new HashMap<>();
            gameConfigGroupMap = new HashMap<>();
            logger.error("next refresh config error");
            return;
        }

        clearBakData();

        gameConfigGroupMapBak = gameConfigGroupMap;
        gameConfigItemMapBak = gameConfigItemMap;

        this.isRefreshCache = true;
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("copyInRefresh : clear gameConfigItemMap");
        gameConfigItemMap = new HashMap<>();
        gameConfigGroupMap = new HashMap<>();

        logger.info("copy group size :"+ String.valueOf(gameConfigGroupMapBak.size()));
        logger.info("copy item size :"+ String.valueOf(gameConfigItemMapBak.size()));
    }

    public void clearBakData() {
        if(gameConfigGroupMapBak != null){
            logger.info("clear group size :"+ String.valueOf(gameConfigGroupMapBak.size()));
            gameConfigGroupMapBak.clear();
            gameConfigGroupMapBak = null;
        }
        if(gameConfigItemMapBak != null){
            logger.info("clear item size :"+ String.valueOf(gameConfigItemMapBak.size()));
            gameConfigItemMapBak.clear();
            gameConfigItemMapBak = null;
        }
    }

}
