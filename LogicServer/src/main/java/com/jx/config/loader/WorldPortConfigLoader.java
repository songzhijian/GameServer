package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.WorldPortConfig;
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
* 工具生成 配置文件 World_Port.xml
*/
@ConfigLoader
public class WorldPortConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "World_Port";

    private static Map<Integer/*唯一Id*/, WorldPortConfig> data = new HashMap<>();
    private static List<WorldPortConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<WorldPortConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, WorldPortConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static WorldPortConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, WorldPortConfig> tempMap = new HashMap<>();
        List<WorldPortConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "scendId";
                int scendId = IntParse.parse(entry.get("scendId"));
                fieldName = "position";
                int[] position = IntArrayParse.parse(entry.get("position"));
                fieldName = "portCulturaCircle";
                int portCulturaCircle = IntParse.parse(entry.get("portCulturaCircle"));
                fieldName = "isBirthCity";
                int isBirthCity = IntParse.parse(entry.get("isBirthCity"));
                fieldName = "lv";
                int lv = IntParse.parse(entry.get("lv"));
                fieldName = "name";
                int name = IntParse.parse(entry.get("name"));
                fieldName = "firstReward";
                int[][] firstReward = IntArray2Parse.parse(entry.get("firstReward"));
                fieldName = "joinReward";
                int[][] joinReward = IntArray2Parse.parse(entry.get("joinReward"));
                fieldName = "force";
                int force = IntParse.parse(entry.get("force"));
                fieldName = "iconHead";
                String iconHead = StringParse.parse(entry.get("iconHead"));
                fieldName = "nearByPort";
                int[] nearByPort = IntArrayParse.parse(entry.get("nearByPort"));
                fieldName = "circles";
                int circles = IntParse.parse(entry.get("circles"));
                fieldName = "maxGarrisonNum";
                int maxGarrisonNum = IntParse.parse(entry.get("maxGarrisonNum"));
                fieldName = "unlockPoint";
                int[] unlockPoint = IntArrayParse.parse(entry.get("unlockPoint"));
                fieldName = "monster";
                int[][] monster = IntArray2Parse.parse(entry.get("monster"));
                fieldName = "monsterNum";
                int monsterNum = IntParse.parse(entry.get("monsterNum"));
                fieldName = "boss";
                int[][] boss = IntArray2Parse.parse(entry.get("boss"));
                fieldName = "bossNum";
                int bossNum = IntParse.parse(entry.get("bossNum"));
                fieldName = "resource";
                int[][] resource = IntArray2Parse.parse(entry.get("resource"));
                fieldName = "resourceNum";
                int resourceNum = IntParse.parse(entry.get("resourceNum"));
                fieldName = "eliteArmy";
                int[] eliteArmy = IntArrayParse.parse(entry.get("eliteArmy"));
                fieldName = "weakArmy";
                int weakArmy = IntParse.parse(entry.get("weakArmy"));
                fieldName = "eliteRecoveryTime";
                int eliteRecoveryTime = IntParse.parse(entry.get("eliteRecoveryTime"));
                fieldName = "attackLimit";
                int attackLimit = IntParse.parse(entry.get("attackLimit"));
                fieldName = "defence";
                int defence = IntParse.parse(entry.get("defence"));
                fieldName = "defenceRecoveryTime";
                int defenceRecoveryTime = IntParse.parse(entry.get("defenceRecoveryTime"));
                fieldName = "shieldTime";
                int shieldTime = IntParse.parse(entry.get("shieldTime"));
                fieldName = "allianceBuff";
                int[] allianceBuff = IntArrayParse.parse(entry.get("allianceBuff"));
                fieldName = "hurtToDeath";
                int hurtToDeath = IntParse.parse(entry.get("hurtToDeath"));
                fieldName = "firstDiscoveryReward";
                int[][] firstDiscoveryReward = IntArray2Parse.parse(entry.get("firstDiscoveryReward"));
                fieldName = "mistReleaseRadius";
                int mistReleaseRadius = IntParse.parse(entry.get("mistReleaseRadius"));
                fieldName = "isTheThrone";
                int isTheThrone = IntParse.parse(entry.get("isTheThrone"));
                fieldName = "hydraLarvaeNum";
                int hydraLarvaeNum = IntParse.parse(entry.get("hydraLarvaeNum"));

                WorldPortConfig config = new WorldPortConfig(id, scendId, position, portCulturaCircle, isBirthCity, lv, name, firstReward, joinReward, force, iconHead, nearByPort, circles, maxGarrisonNum, unlockPoint, monster, monsterNum, boss, bossNum, resource, resourceNum, eliteArmy, weakArmy, eliteRecoveryTime, attackLimit, defence, defenceRecoveryTime, shieldTime, allianceBuff, hurtToDeath, firstDiscoveryReward, mistReleaseRadius, isTheThrone, hydraLarvaeNum);
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
