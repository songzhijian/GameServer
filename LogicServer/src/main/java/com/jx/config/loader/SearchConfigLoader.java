package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SearchConfig;
import com.jx.config.util.gen.support.IConfigLoader;
import com.tool.config.type.primitive.*;
import com.tool.config.type.struct.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 工具生成 配置文件 Search.xml
*/
@ConfigLoader
public class SearchConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Search";

    private static Map<Integer/*唯一Id*/, SearchConfig> data = new HashMap<>();
    private static List<SearchConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SearchConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, SearchConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SearchConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, SearchConfig> tempMap = new HashMap<>();
        List<SearchConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "sceneUnitType";
                int sceneUnitType = IntParse.parse(entry.get("sceneUnitType"));
                fieldName = "typeId";
                int typeId = IntParse.parse(entry.get("typeId"));
                fieldName = "minLv";
                int minLv = IntParse.parse(entry.get("minLv"));
                fieldName = "maxLv";
                int maxLv = IntParse.parse(entry.get("maxLv"));
                fieldName = "searchRange";
                int[][] searchRange = IntArray2Parse.parse(entry.get("searchRange"));
                fieldName = "maxRefreshLv";
                int maxRefreshLv = IntParse.parse(entry.get("maxRefreshLv"));
                fieldName = "searchRadius";
                int searchRadius = IntParse.parse(entry.get("searchRadius"));

                SearchConfig config = new SearchConfig(id, sceneUnitType, typeId, minLv, maxLv, searchRange, maxRefreshLv, searchRadius);
                tempMap.put(id, config);
                tempList.add(config);
            } catch (Exception e) {
                ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, id = %s, fieldName = %s message = %s", CONFIG_NAME, errorId, fieldName, e.getMessage());
                LogUtils.logger.warn(ConfigGlobalManager.error,e);
                throw e;
            }
        }
        LogUtils.logger.info("[ConfigLoader] load config {} finish, data size = {}", CONFIG_NAME, tempList.size());

        data = Collections.unmodifiableMap(tempMap);
        configs = Collections.unmodifiableList(tempList);
    }
}
