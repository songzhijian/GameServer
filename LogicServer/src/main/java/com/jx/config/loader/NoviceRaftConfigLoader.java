package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.NoviceRaftConfig;
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
* 工具生成 配置文件 NoviceRaft.xml
*/
@ConfigLoader
public class NoviceRaftConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "NoviceRaft";

    private static Map<Integer/*唯一Id*/, NoviceRaftConfig> data = new HashMap<>();
    private static List<NoviceRaftConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<NoviceRaftConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, NoviceRaftConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static NoviceRaftConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, NoviceRaftConfig> tempMap = new HashMap<>();
        List<NoviceRaftConfig> tempList = new ArrayList<>();
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
                fieldName = "param";
                int[][] param = IntArray2Parse.parse(entry.get("param"));
                fieldName = "param2";
                int[][] param2 = IntArray2Parse.parse(entry.get("param2"));
                fieldName = "condition";
                int[][] condition = IntArray2Parse.parse(entry.get("condition"));
                fieldName = "next";
                int next = IntParse.parse(entry.get("next"));

                NoviceRaftConfig config = new NoviceRaftConfig(id, type, param, param2, condition, next);
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
