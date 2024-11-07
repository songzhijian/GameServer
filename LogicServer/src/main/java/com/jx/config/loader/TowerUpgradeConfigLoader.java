package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TowerUpgradeConfig;
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
* 工具生成 配置文件 Tower_Upgrade.xml
*/
@ConfigLoader
public class TowerUpgradeConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Tower_Upgrade";

    private static Map<Integer/*唯一Id*/, TowerUpgradeConfig> data = new HashMap<>();
    private static List<TowerUpgradeConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TowerUpgradeConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TowerUpgradeConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TowerUpgradeConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TowerUpgradeConfig> tempMap = new HashMap<>();
        List<TowerUpgradeConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "lvl";
                int lvl = IntParse.parse(entry.get("lvl"));
                errorId = lvl;
                fieldName = "rewardIncr";
                int rewardIncr = IntParse.parse(entry.get("rewardIncr"));
                fieldName = "type0Count";
                int type0Count = IntParse.parse(entry.get("type0Count"));
                fieldName = "type0Rand";
                int[][] type0Rand = IntArray2Parse.parse(entry.get("type0Rand"));
                fieldName = "type1Count";
                int type1Count = IntParse.parse(entry.get("type1Count"));
                fieldName = "type1Rand";
                int[][] type1Rand = IntArray2Parse.parse(entry.get("type1Rand"));
                fieldName = "type2Count";
                int type2Count = IntParse.parse(entry.get("type2Count"));
                fieldName = "type2Rand";
                int[][] type2Rand = IntArray2Parse.parse(entry.get("type2Rand"));
                fieldName = "type3Count";
                int type3Count = IntParse.parse(entry.get("type3Count"));
                fieldName = "type3Rand";
                int[][] type3Rand = IntArray2Parse.parse(entry.get("type3Rand"));
                fieldName = "type4Count";
                int type4Count = IntParse.parse(entry.get("type4Count"));
                fieldName = "type4Rand";
                int[][] type4Rand = IntArray2Parse.parse(entry.get("type4Rand"));
                fieldName = "noteCount";
                int noteCount = IntParse.parse(entry.get("noteCount"));

                TowerUpgradeConfig config = new TowerUpgradeConfig(lvl, rewardIncr, type0Count, type0Rand, type1Count, type1Rand, type2Count, type2Rand, type3Count, type3Rand, type4Count, type4Rand, noteCount);
                tempMap.put(lvl, config);
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
