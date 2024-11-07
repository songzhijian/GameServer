package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.custom.TaskConfigCustomLoader;
import com.jx.config.model.TaskConfig;
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
* 工具生成 配置文件 Task.xml
*/
@ConfigLoader
public class TaskConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Task";

    private static Map<Integer/*唯一Id*/, TaskConfig> data = new HashMap<>();
    private static List<TaskConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TaskConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TaskConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TaskConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TaskConfig> tempMap = new HashMap<>();
        List<TaskConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "param";
                int[] param = IntArrayParse.parse(entry.get("param"));
                fieldName = "situation";
                int situation = IntParse.parse(entry.get("situation"));
                fieldName = "showCondition";
                long[][] showCondition = LongArray2Parse.parse(entry.get("showCondition"));
                fieldName = "unlockCondition";
                long[][] unlockCondition = LongArray2Parse.parse(entry.get("unlockCondition"));
                fieldName = "check";
                boolean check = BooleanParse.parse(entry.get("check"));
                fieldName = "completeCondition";
                long[][] completeCondition = LongArray2Parse.parse(entry.get("completeCondition"));
                fieldName = "rewards";
                int[][] rewards = IntArray2Parse.parse(entry.get("rewards"));
                fieldName = "isShowInResult";
                int isShowInResult = IntParse.parse(entry.get("isShowInResult"));
                fieldName = "nextTaskIds";
                int[] nextTaskIds = IntArrayParse.parse(entry.get("nextTaskIds"));

                TaskConfig config = new TaskConfig(id, type, param, situation, showCondition, unlockCondition, check, completeCondition, rewards, isShowInResult, nextTaskIds);
                tempMap.put(id, config);
                tempList.add(config);
            } catch (Exception e) {
                ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, id = %s, fieldName = %s message = %s", CONFIG_NAME, errorId, fieldName, e.getMessage());
                LogUtils.logger.warn(ConfigGlobalManager.error,e);
                throw e;
            }
        }
        LogUtils.logger.info("[ConfigLoader] load config {} finish, data size = {}", CONFIG_NAME, tempList.size());
        TaskConfigCustomLoader.oldConfig = configs;
        data = Collections.unmodifiableMap(tempMap);
        configs = Collections.unmodifiableList(tempList);
    }
}
