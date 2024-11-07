package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.BattlePassConfig;
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
* 工具生成 配置文件 Battle_Pass.xml
*/
@ConfigLoader
public class BattlePassConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Battle_Pass";

    private static Map<Integer/*唯一Id*/, BattlePassConfig> data = new HashMap<>();
    private static List<BattlePassConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<BattlePassConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, BattlePassConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static BattlePassConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, BattlePassConfig> tempMap = new HashMap<>();
        List<BattlePassConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "createTimeType";
                int createTimeType = IntParse.parse(entry.get("createTimeType"));
                fieldName = "scoreToLevelType";
                int[] scoreToLevelType = IntArrayParse.parse(entry.get("scoreToLevelType"));
                fieldName = "stageTasks";
                int[][] stageTasks = IntArray2Parse.parse(entry.get("stageTasks"));
                fieldName = "giftIdAndFunc";
                int[][] giftIdAndFunc = IntArray2Parse.parse(entry.get("giftIdAndFunc"));
                fieldName = "stageType";
                int stageType = IntParse.parse(entry.get("stageType"));
                fieldName = "stageTypeParam";
                int[] stageTypeParam = IntArrayParse.parse(entry.get("stageTypeParam"));
                fieldName = "tasks";
                int[] tasks = IntArrayParse.parse(entry.get("tasks"));
                fieldName = "mailId";
                int mailId = IntParse.parse(entry.get("mailId"));
                fieldName = "loopLevel";
                int loopLevel = IntParse.parse(entry.get("loopLevel"));
                fieldName = "oneBuyLevelMax";
                int oneBuyLevelMax = IntParse.parse(entry.get("oneBuyLevelMax"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "buyLevelTotle";
                int buyLevelTotle = IntParse.parse(entry.get("buyLevelTotle"));
                fieldName = "businessType";
                int businessType = IntParse.parse(entry.get("businessType"));

                BattlePassConfig config = new BattlePassConfig(id, createTimeType, scoreToLevelType, stageTasks, giftIdAndFunc, stageType, stageTypeParam, tasks, mailId, loopLevel, oneBuyLevelMax, cost, buyLevelTotle, businessType);
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
