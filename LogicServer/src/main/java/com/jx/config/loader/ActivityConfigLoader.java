package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ActivityConfig;
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
* 工具生成 配置文件 Activity.xml
*/
@ConfigLoader
public class ActivityConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Activity";

    private static Map<Integer/*唯一Id*/, ActivityConfig> data = new HashMap<>();
    private static List<ActivityConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ActivityConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ActivityConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ActivityConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ActivityConfig> tempMap = new HashMap<>();
        List<ActivityConfig> tempList = new ArrayList<>();
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
                fieldName = "param2";
                int[] param2 = IntArrayParse.parse(entry.get("param2"));
                fieldName = "previewTime";
                int previewTime = IntParse.parse(entry.get("previewTime"));
                fieldName = "time";
                String[] time = StringArrayParse.parse(entry.get("time"));
                fieldName = "serverCondition";
                long[][] serverCondition = LongArray2Parse.parse(entry.get("serverCondition"));
                fieldName = "personCondition";
                long[][] personCondition = LongArray2Parse.parse(entry.get("personCondition"));
                fieldName = "rank";
                int rank = IntParse.parse(entry.get("rank"));
                fieldName = "associativeType";
                int associativeType = IntParse.parse(entry.get("associativeType"));
                fieldName = "serverIds";
                int[][][] serverIds = IntArray3Parse.parse(entry.get("serverIds"));
                fieldName = "activeNotification";
                boolean activeNotification = BooleanParse.parse(entry.get("activeNotification"));
                fieldName = "event";
                int[] event = IntArrayParse.parse(entry.get("event"));
                fieldName = "startMarqueeTime";
                int[] startMarqueeTime = IntArrayParse.parse(entry.get("startMarqueeTime"));
                fieldName = "marqueeId";
                int marqueeId = IntParse.parse(entry.get("marqueeId"));
                fieldName = "reward";
                int[][] reward = IntArray2Parse.parse(entry.get("reward"));
                fieldName = "mail";
                int mail = IntParse.parse(entry.get("mail"));
                fieldName = "functionOn";
                int functionOn = IntParse.parse(entry.get("functionOn"));
                fieldName = "ifPersonal";
                int ifPersonal = IntParse.parse(entry.get("ifPersonal"));
                fieldName = "isDailyReset";
                boolean isDailyReset = BooleanParse.parse(entry.get("isDailyReset"));

                ActivityConfig config = new ActivityConfig(id, type, param, param2, previewTime, time, serverCondition, personCondition, rank, associativeType, serverIds, activeNotification, event, startMarqueeTime, marqueeId, reward, mail, functionOn, ifPersonal, isDailyReset);
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
