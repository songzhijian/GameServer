package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.StrikePirateLayerConfig;
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
* 工具生成 配置文件 Strike_Pirate_Layer.xml
*/
@ConfigLoader
public class StrikePirateLayerConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Strike_Pirate_Layer";

    private static Map<Integer/*唯一Id*/, StrikePirateLayerConfig> data = new HashMap<>();
    private static List<StrikePirateLayerConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<StrikePirateLayerConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, StrikePirateLayerConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static StrikePirateLayerConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, StrikePirateLayerConfig> tempMap = new HashMap<>();
        List<StrikePirateLayerConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "chapter";
                int chapter = IntParse.parse(entry.get("chapter"));
                fieldName = "specialCondition";
                int[] specialCondition = IntArrayParse.parse(entry.get("specialCondition"));
                fieldName = "specialConditionDes";
                int specialConditionDes = IntParse.parse(entry.get("specialConditionDes"));
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
                fieldName = "unlockCondition";
                int unlockCondition = IntParse.parse(entry.get("unlockCondition"));
                fieldName = "unlockParam";
                int[][] unlockParam = IntArray2Parse.parse(entry.get("unlockParam"));
                fieldName = "extraEnemy";
                int extraEnemy = IntParse.parse(entry.get("extraEnemy"));
                fieldName = "bonus";
                int[][] bonus = IntArray2Parse.parse(entry.get("bonus"));
                fieldName = "mainBonus";
                int[][] mainBonus = IntArray2Parse.parse(entry.get("mainBonus"));

                StrikePirateLayerConfig config = new StrikePirateLayerConfig(id, chapter, specialCondition, specialConditionDes, enemy1, enemy2, enemy3, enemy4, enemy5, unlockCondition, unlockParam, extraEnemy, bonus, mainBonus);
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
