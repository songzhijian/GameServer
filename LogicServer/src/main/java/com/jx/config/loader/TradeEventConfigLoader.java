package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TradeEventConfig;
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
* 工具生成 配置文件 Trade_Event.xml
*/
@ConfigLoader
public class TradeEventConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Trade_Event";

    private static Map<Integer/*唯一Id*/, TradeEventConfig> data = new HashMap<>();
    private static List<TradeEventConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TradeEventConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TradeEventConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TradeEventConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TradeEventConfig> tempMap = new HashMap<>();
        List<TradeEventConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "order";
                int order = IntParse.parse(entry.get("order"));
                fieldName = "name";
                String name = StringParse.parse(entry.get("name"));
                fieldName = "img";
                String img = StringParse.parse(entry.get("img"));
                fieldName = "des";
                String des = StringParse.parse(entry.get("des"));
                fieldName = "checkTime";
                int checkTime = IntParse.parse(entry.get("checkTime"));
                fieldName = "checkType";
                int checkType = IntParse.parse(entry.get("checkType"));
                fieldName = "Param";
                int[] Param = IntArrayParse.parse(entry.get("Param"));
                fieldName = "isForce";
                int isForce = IntParse.parse(entry.get("isForce"));
                fieldName = "time";
                int time = IntParse.parse(entry.get("time"));
                fieldName = "affectClass";
                int affectClass = IntParse.parse(entry.get("affectClass"));
                fieldName = "trend";
                int[] trend = IntArrayParse.parse(entry.get("trend"));
                fieldName = "trendTurn";
                int trendTurn = IntParse.parse(entry.get("trendTurn"));

                TradeEventConfig config = new TradeEventConfig(id, order, name, img, des, checkTime, checkType, Param, isForce, time, affectClass, trend, trendTurn);
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
