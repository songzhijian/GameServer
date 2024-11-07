package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ArenaRankConfig;
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
* 工具生成 配置文件 Arena_Rank.xml
*/
@ConfigLoader
public class ArenaRankConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Arena_Rank";

    private static Map<Integer/*唯一Id*/, ArenaRankConfig> data = new HashMap<>();
    private static List<ArenaRankConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ArenaRankConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ArenaRankConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ArenaRankConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ArenaRankConfig> tempMap = new HashMap<>();
        List<ArenaRankConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "rank";
                int[] rank = IntArrayParse.parse(entry.get("rank"));
                fieldName = "enemyZone1";
                int[] enemyZone1 = IntArrayParse.parse(entry.get("enemyZone1"));
                fieldName = "enemyZone2";
                int[] enemyZone2 = IntArrayParse.parse(entry.get("enemyZone2"));
                fieldName = "enemyZone3";
                int[] enemyZone3 = IntArrayParse.parse(entry.get("enemyZone3"));
                fieldName = "zoneStep1";
                int[] zoneStep1 = IntArrayParse.parse(entry.get("zoneStep1"));
                fieldName = "zoneStep2";
                int[] zoneStep2 = IntArrayParse.parse(entry.get("zoneStep2"));
                fieldName = "zoneStep3";
                int[] zoneStep3 = IntArrayParse.parse(entry.get("zoneStep3"));
                fieldName = "reward";
                int[][] reward = IntArray2Parse.parse(entry.get("reward"));
                fieldName = "resetIntegral";
                int resetIntegral = IntParse.parse(entry.get("resetIntegral"));

                ArenaRankConfig config = new ArenaRankConfig(id, rank, enemyZone1, enemyZone2, enemyZone3, zoneStep1, zoneStep2, zoneStep3, reward, resetIntegral);
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
