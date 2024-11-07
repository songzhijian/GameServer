package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TrendsConfig;
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
* 工具生成 配置文件 Trends.xml
*/
@ConfigLoader
public class TrendsConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Trends";

    private static Map<Integer/*唯一Id*/, TrendsConfig> data = new HashMap<>();
    private static List<TrendsConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TrendsConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TrendsConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TrendsConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TrendsConfig> tempMap = new HashMap<>();
        List<TrendsConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "season";
                int season = IntParse.parse(entry.get("season"));
                fieldName = "nextId";
                int nextId = IntParse.parse(entry.get("nextId"));
                fieldName = "taskId";
                int[] taskId = IntArrayParse.parse(entry.get("taskId"));
                fieldName = "openCondition";
                int[] openCondition = IntArrayParse.parse(entry.get("openCondition"));
                fieldName = "durationTime";
                int durationTime = IntParse.parse(entry.get("durationTime"));
                fieldName = "FinishCondition";
                int FinishCondition = IntParse.parse(entry.get("FinishCondition"));
                fieldName = "name";
                int name = IntParse.parse(entry.get("name"));
                fieldName = "reward";
                int[][] reward = IntArray2Parse.parse(entry.get("reward"));
                fieldName = "rewardType";
                int rewardType = IntParse.parse(entry.get("rewardType"));
                fieldName = "rewardGetTime";
                int rewardGetTime = IntParse.parse(entry.get("rewardGetTime"));
                fieldName = "functionUnlock";
                int[] functionUnlock = IntArrayParse.parse(entry.get("functionUnlock"));

                TrendsConfig config = new TrendsConfig(id, season, nextId, taskId, openCondition, durationTime, FinishCondition, name, reward, rewardType, rewardGetTime, functionUnlock);
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
