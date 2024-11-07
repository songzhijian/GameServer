package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HighArenaArenaRankConfig;
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
* 工具生成 配置文件 HighArenaArena_Rank.xml
*/
@ConfigLoader
public class HighArenaArenaRankConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "HighArenaArena_Rank";

    private static Map<Integer/*唯一Id*/, HighArenaArenaRankConfig> data = new HashMap<>();
    private static List<HighArenaArenaRankConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HighArenaArenaRankConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HighArenaArenaRankConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HighArenaArenaRankConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HighArenaArenaRankConfig> tempMap = new HashMap<>();
        List<HighArenaArenaRankConfig> tempList = new ArrayList<>();
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
                fieldName = "name";
                String name = StringParse.parse(entry.get("name"));
                fieldName = "icon";
                String icon = StringParse.parse(entry.get("icon"));
                fieldName = "enemyZone1";
                int[] enemyZone1 = IntArrayParse.parse(entry.get("enemyZone1"));
                fieldName = "enemyZone2";
                int[] enemyZone2 = IntArrayParse.parse(entry.get("enemyZone2"));
                fieldName = "enemyZone3";
                int[] enemyZone3 = IntArrayParse.parse(entry.get("enemyZone3"));
                fieldName = "enemyZone4";
                int[] enemyZone4 = IntArrayParse.parse(entry.get("enemyZone4"));
                fieldName = "enemyZone5";
                int[] enemyZone5 = IntArrayParse.parse(entry.get("enemyZone5"));
                fieldName = "zoneStep1";
                int[] zoneStep1 = IntArrayParse.parse(entry.get("zoneStep1"));
                fieldName = "zoneStep2";
                int[] zoneStep2 = IntArrayParse.parse(entry.get("zoneStep2"));
                fieldName = "zoneStep3";
                int[] zoneStep3 = IntArrayParse.parse(entry.get("zoneStep3"));
                fieldName = "zoneStep4";
                int[] zoneStep4 = IntArrayParse.parse(entry.get("zoneStep4"));
                fieldName = "zoneStep5";
                int[] zoneStep5 = IntArrayParse.parse(entry.get("zoneStep5"));
                fieldName = "resetIntegral";
                int resetIntegral = IntParse.parse(entry.get("resetIntegral"));
                fieldName = "efficiency";
                int efficiency = IntParse.parse(entry.get("efficiency"));

                HighArenaArenaRankConfig config = new HighArenaArenaRankConfig(id, rank, name, icon, enemyZone1, enemyZone2, enemyZone3, enemyZone4, enemyZone5, zoneStep1, zoneStep2, zoneStep3, zoneStep4, zoneStep5, resetIntegral, efficiency);
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
