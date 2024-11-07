package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.StageBattleBotConfig;
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
* 工具生成 配置文件 Stage_Battle_Bot.xml
*/
@ConfigLoader
public class StageBattleBotConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Stage_Battle_Bot";

    private static Map<Integer/*唯一Id*/, StageBattleBotConfig> data = new HashMap<>();
    private static List<StageBattleBotConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<StageBattleBotConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, StageBattleBotConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static StageBattleBotConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, StageBattleBotConfig> tempMap = new HashMap<>();
        List<StageBattleBotConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "enemy1";
                int enemy1 = IntParse.parse(entry.get("enemy1"));
                fieldName = "enemy2";
                int enemy2 = IntParse.parse(entry.get("enemy2"));
                fieldName = "enemy3";
                int enemy3 = IntParse.parse(entry.get("enemy3"));
                fieldName = "enemy4";
                int enemy4 = IntParse.parse(entry.get("enemy4"));
                fieldName = "enemy5";
                int enemy5 = IntParse.parse(entry.get("enemy5"));
                fieldName = "level1";
                int level1 = IntParse.parse(entry.get("level1"));
                fieldName = "level2";
                int level2 = IntParse.parse(entry.get("level2"));
                fieldName = "level3";
                int level3 = IntParse.parse(entry.get("level3"));
                fieldName = "level4";
                int level4 = IntParse.parse(entry.get("level4"));
                fieldName = "level5";
                int level5 = IntParse.parse(entry.get("level5"));
                fieldName = "quality1";
                int quality1 = IntParse.parse(entry.get("quality1"));
                fieldName = "quality2";
                int quality2 = IntParse.parse(entry.get("quality2"));
                fieldName = "quality3";
                int quality3 = IntParse.parse(entry.get("quality3"));
                fieldName = "quality4";
                int quality4 = IntParse.parse(entry.get("quality4"));
                fieldName = "quality5";
                int quality5 = IntParse.parse(entry.get("quality5"));
                fieldName = "navy1";
                int[][] navy1 = IntArray2Parse.parse(entry.get("navy1"));
                fieldName = "navy2";
                int[][] navy2 = IntArray2Parse.parse(entry.get("navy2"));
                fieldName = "navy3";
                int[][] navy3 = IntArray2Parse.parse(entry.get("navy3"));
                fieldName = "navy4";
                int[][] navy4 = IntArray2Parse.parse(entry.get("navy4"));
                fieldName = "navy5";
                int[][] navy5 = IntArray2Parse.parse(entry.get("navy5"));
                fieldName = "equip1";
                int[][] equip1 = IntArray2Parse.parse(entry.get("equip1"));
                fieldName = "equip2";
                int[][] equip2 = IntArray2Parse.parse(entry.get("equip2"));
                fieldName = "equip3";
                int[][] equip3 = IntArray2Parse.parse(entry.get("equip3"));
                fieldName = "equip4";
                int[][] equip4 = IntArray2Parse.parse(entry.get("equip4"));
                fieldName = "equip5";
                int[][] equip5 = IntArray2Parse.parse(entry.get("equip5"));
                fieldName = "buff1";
                String[] buff1 = StringArrayParse.parse(entry.get("buff1"));
                fieldName = "buff2";
                String[] buff2 = StringArrayParse.parse(entry.get("buff2"));
                fieldName = "buff3";
                String[] buff3 = StringArrayParse.parse(entry.get("buff3"));
                fieldName = "buff4";
                String[] buff4 = StringArrayParse.parse(entry.get("buff4"));
                fieldName = "buff5";
                String[] buff5 = StringArrayParse.parse(entry.get("buff5"));
                fieldName = "powerEnemy";
                int[] powerEnemy = IntArrayParse.parse(entry.get("powerEnemy"));
                fieldName = "powerPlayer";
                int[] powerPlayer = IntArrayParse.parse(entry.get("powerPlayer"));
                fieldName = "powerSpdPlayer";
                int powerSpdPlayer = IntParse.parse(entry.get("powerSpdPlayer"));
                fieldName = "powerSpdEnemy";
                int powerSpdEnemy = IntParse.parse(entry.get("powerSpdEnemy"));
                fieldName = "HpCoefEnemy";
                int HpCoefEnemy = IntParse.parse(entry.get("HpCoefEnemy"));
                fieldName = "AtkCoefEnemy";
                int AtkCoefEnemy = IntParse.parse(entry.get("AtkCoefEnemy"));
                fieldName = "boss";
                int boss = IntParse.parse(entry.get("boss"));
                fieldName = "HpCoefBoss";
                int HpCoefBoss = IntParse.parse(entry.get("HpCoefBoss"));
                fieldName = "AtkCoefBoss";
                int AtkCoefBoss = IntParse.parse(entry.get("AtkCoefBoss"));
                fieldName = "levelSuppress";
                int levelSuppress = IntParse.parse(entry.get("levelSuppress"));
                fieldName = "levelSuppress2";
                int levelSuppress2 = IntParse.parse(entry.get("levelSuppress2"));
                fieldName = "troopLoss";
                int troopLoss = IntParse.parse(entry.get("troopLoss"));

                StageBattleBotConfig config = new StageBattleBotConfig(id, enemy1, enemy2, enemy3, enemy4, enemy5, level1, level2, level3, level4, level5, quality1, quality2, quality3, quality4, quality5, navy1, navy2, navy3, navy4, navy5, equip1, equip2, equip3, equip4, equip5, buff1, buff2, buff3, buff4, buff5, powerEnemy, powerPlayer, powerSpdPlayer, powerSpdEnemy, HpCoefEnemy, AtkCoefEnemy, boss, HpCoefBoss, AtkCoefBoss, levelSuppress, levelSuppress2, troopLoss);
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
