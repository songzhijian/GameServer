package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ActiveRewardConfig;
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
* 工具生成 配置文件 ActiveReward.xml
*/
@ConfigLoader
public class ActiveRewardConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "ActiveReward";

    private static Map<Integer/*唯一Id*/, ActiveRewardConfig> data = new HashMap<>();
    private static List<ActiveRewardConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ActiveRewardConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ActiveRewardConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ActiveRewardConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ActiveRewardConfig> tempMap = new HashMap<>();
        List<ActiveRewardConfig> tempList = new ArrayList<>();
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
                int param = IntParse.parse(entry.get("param"));
                fieldName = "conditionType";
                long[] conditionType = LongArrayParse.parse(entry.get("conditionType"));
                fieldName = "activityValue";
                int activityValue = IntParse.parse(entry.get("activityValue"));
                fieldName = "reward";
                int[][] reward = IntArray2Parse.parse(entry.get("reward"));

                ActiveRewardConfig config = new ActiveRewardConfig(id, type, param, conditionType, activityValue, reward);
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
