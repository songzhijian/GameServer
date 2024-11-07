package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TechInfoConfig;
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
* 工具生成 配置文件 Tech_Info.xml
*/
@ConfigLoader
public class TechInfoConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Tech_Info";

    private static Map<Integer/*唯一Id*/, TechInfoConfig> data = new HashMap<>();
    private static List<TechInfoConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TechInfoConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TechInfoConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TechInfoConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TechInfoConfig> tempMap = new HashMap<>();
        List<TechInfoConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "lvl";
                int lvl = IntParse.parse(entry.get("lvl"));
                fieldName = "node";
                int node = IntParse.parse(entry.get("node"));
                fieldName = "baseCost";
                int[][] baseCost = IntArray2Parse.parse(entry.get("baseCost"));
                fieldName = "baseTime";
                int baseTime = IntParse.parse(entry.get("baseTime"));
                fieldName = "hammerPrice";
                int[] hammerPrice = IntArrayParse.parse(entry.get("hammerPrice"));
                fieldName = "reservePrice";
                int[] reservePrice = IntArrayParse.parse(entry.get("reservePrice"));
                fieldName = "labLvl";
                int labLvl = IntParse.parse(entry.get("labLvl"));
                fieldName = "techLvl";
                int[] techLvl = IntArrayParse.parse(entry.get("techLvl"));
                fieldName = "effect";
                int[][] effect = IntArray2Parse.parse(entry.get("effect"));
                fieldName = "power";
                int power = IntParse.parse(entry.get("power"));

                TechInfoConfig config = new TechInfoConfig(id, lvl, node, baseCost, baseTime, hammerPrice, reservePrice, labLvl, techLvl, effect, power);
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
