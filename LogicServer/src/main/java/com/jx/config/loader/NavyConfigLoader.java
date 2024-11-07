package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.NavyConfig;
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
* 工具生成 配置文件 Navy.xml
*/
@ConfigLoader
public class NavyConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Navy";

    private static Map<Integer/*唯一Id*/, NavyConfig> data = new HashMap<>();
    private static List<NavyConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<NavyConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, NavyConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static NavyConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, NavyConfig> tempMap = new HashMap<>();
        List<NavyConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "lv";
                int lv = IntParse.parse(entry.get("lv"));
                fieldName = "attRate";
                float attRate = FloatParse.parse(entry.get("attRate"));
                fieldName = "load";
                int load = IntParse.parse(entry.get("load"));
                fieldName = "destroy";
                float destroy = FloatParse.parse(entry.get("destroy"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "time";
                int time = IntParse.parse(entry.get("time"));
                fieldName = "healCost";
                int[][] healCost = IntArray2Parse.parse(entry.get("healCost"));
                fieldName = "healTime";
                int healTime = IntParse.parse(entry.get("healTime"));
                fieldName = "power";
                int power = IntParse.parse(entry.get("power"));
                fieldName = "rankPoint";
                int rankPoint = IntParse.parse(entry.get("rankPoint"));

                NavyConfig config = new NavyConfig(id, lv, attRate, load, destroy, cost, time, healCost, healTime, power, rankPoint);
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