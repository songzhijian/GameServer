package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.RankConfig;
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
* 工具生成 配置文件 Rank.xml
*/
@ConfigLoader
public class RankConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Rank";

    private static Map<Integer/*唯一Id*/, RankConfig> data = new HashMap<>();
    private static List<RankConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<RankConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, RankConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static RankConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, RankConfig> tempMap = new HashMap<>();
        List<RankConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "saveDataType";
                int saveDataType = IntParse.parse(entry.get("saveDataType"));
                fieldName = "rankClearType";
                int rankClearType = IntParse.parse(entry.get("rankClearType"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "settlementMethod";
                int settlementMethod = IntParse.parse(entry.get("settlementMethod"));
                fieldName = "settleDuration";
                int settleDuration = IntParse.parse(entry.get("settleDuration"));
                fieldName = "minimumValue";
                int minimumValue = IntParse.parse(entry.get("minimumValue"));
                fieldName = "range";
                int range = IntParse.parse(entry.get("range"));
                fieldName = "showRange";
                int showRange = IntParse.parse(entry.get("showRange"));
                fieldName = "reward";
                int[] reward = IntArrayParse.parse(entry.get("reward"));
                fieldName = "sendType";
                int[] sendType = IntArrayParse.parse(entry.get("sendType"));
                fieldName = "online";
                int online = IntParse.parse(entry.get("online"));

                RankConfig config = new RankConfig(id, saveDataType, rankClearType, type, settlementMethod, settleDuration, minimumValue, range, showRange, reward, sendType, online);
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
