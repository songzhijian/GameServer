package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HolyrelicLevelConfig;
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
* 工具生成 配置文件 Holyrelic_Level.xml
*/
@ConfigLoader
public class HolyrelicLevelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Holyrelic_Level";

    private static Map<Integer/*唯一Id*/, HolyrelicLevelConfig> data = new HashMap<>();
    private static List<HolyrelicLevelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HolyrelicLevelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HolyrelicLevelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HolyrelicLevelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HolyrelicLevelConfig> tempMap = new HashMap<>();
        List<HolyrelicLevelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "holyrelic";
                int holyrelic = IntParse.parse(entry.get("holyrelic"));
                fieldName = "level";
                int level = IntParse.parse(entry.get("level"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "power";
                int power = IntParse.parse(entry.get("power"));
                fieldName = "attr1";
                int[][] attr1 = IntArray2Parse.parse(entry.get("attr1"));
                fieldName = "attr2";
                int[][] attr2 = IntArray2Parse.parse(entry.get("attr2"));
                fieldName = "attr3";
                int[][] attr3 = IntArray2Parse.parse(entry.get("attr3"));
                fieldName = "attr4";
                int[][] attr4 = IntArray2Parse.parse(entry.get("attr4"));

                HolyrelicLevelConfig config = new HolyrelicLevelConfig(id, holyrelic, level, cost, power, attr1, attr2, attr3, attr4);
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
