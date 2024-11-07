package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.WorldMonsterConfig;
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
* 工具生成 配置文件 World_Monster.xml
*/
@ConfigLoader
public class WorldMonsterConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "World_Monster";

    private static Map<Integer/*唯一Id*/, WorldMonsterConfig> data = new HashMap<>();
    private static List<WorldMonsterConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<WorldMonsterConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, WorldMonsterConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static WorldMonsterConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, WorldMonsterConfig> tempMap = new HashMap<>();
        List<WorldMonsterConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "name";
                int name = IntParse.parse(entry.get("name"));
                fieldName = "level";
                int level = IntParse.parse(entry.get("level"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "preMonsterId";
                int preMonsterId = IntParse.parse(entry.get("preMonsterId"));
                fieldName = "army";
                int[] army = IntArrayParse.parse(entry.get("army"));
                fieldName = "hurtRate";
                int hurtRate = IntParse.parse(entry.get("hurtRate"));
                fieldName = "rewardFirstKill";
                int[][] rewardFirstKill = IntArray2Parse.parse(entry.get("rewardFirstKill"));
                fieldName = "reward";
                int[][] reward = IntArray2Parse.parse(entry.get("reward"));
                fieldName = "allianceGift";
                int[][] allianceGift = IntArray2Parse.parse(entry.get("allianceGift"));
                fieldName = "allianceGiftFirstKill";
                int[][] allianceGiftFirstKill = IntArray2Parse.parse(entry.get("allianceGiftFirstKill"));
                fieldName = "powerLimit";
                int powerLimit = IntParse.parse(entry.get("powerLimit"));
                fieldName = "iconHead";
                String iconHead = StringParse.parse(entry.get("iconHead"));
                fieldName = "patrollRadius";
                int patrollRadius = IntParse.parse(entry.get("patrollRadius"));
                fieldName = "patrollCd";
                int patrollCd = IntParse.parse(entry.get("patrollCd"));
                fieldName = "baseSpeed";
                int baseSpeed = IntParse.parse(entry.get("baseSpeed"));
                fieldName = "lifeTime";
                int lifeTime = IntParse.parse(entry.get("lifeTime"));
                fieldName = "rankPoint";
                int rankPoint = IntParse.parse(entry.get("rankPoint"));
                fieldName = "radius";
                int radius = IntParse.parse(entry.get("radius"));

                WorldMonsterConfig config = new WorldMonsterConfig(id, name, level, type, preMonsterId, army, hurtRate, rewardFirstKill, reward, allianceGift, allianceGiftFirstKill, powerLimit, iconHead, patrollRadius, patrollCd, baseSpeed, lifeTime, rankPoint, radius);
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
