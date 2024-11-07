package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SearchRoomListConfig;
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
* 工具生成 配置文件 Search_Room_List.xml
*/
@ConfigLoader
public class SearchRoomListConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Search_Room_List";

    private static Map<Integer/*唯一Id*/, SearchRoomListConfig> data = new HashMap<>();
    private static List<SearchRoomListConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SearchRoomListConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, SearchRoomListConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SearchRoomListConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, SearchRoomListConfig> tempMap = new HashMap<>();
        List<SearchRoomListConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "shipIcon";
                String shipIcon = StringParse.parse(entry.get("shipIcon"));
                fieldName = "outputResouceId";
                int outputResouceId = IntParse.parse(entry.get("outputResouceId"));
                fieldName = "preTechnology";
                int preTechnology = IntParse.parse(entry.get("preTechnology"));
                fieldName = "preColor";
                int preColor = IntParse.parse(entry.get("preColor"));
                fieldName = "maxLevel";
                int maxLevel = IntParse.parse(entry.get("maxLevel"));

                SearchRoomListConfig config = new SearchRoomListConfig(id, type, shipIcon, outputResouceId, preTechnology, preColor, maxLevel);
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
