package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TradePortsConfig;
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
* 工具生成 配置文件 Trade_Ports.xml
*/
@ConfigLoader
public class TradePortsConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Trade_Ports";

    private static Map<Integer/*唯一Id*/, TradePortsConfig> data = new HashMap<>();
    private static List<TradePortsConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TradePortsConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TradePortsConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TradePortsConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TradePortsConfig> tempMap = new HashMap<>();
        List<TradePortsConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "portName";
                int portName = IntParse.parse(entry.get("portName"));
                fieldName = "portLevel";
                int portLevel = IntParse.parse(entry.get("portLevel"));
                fieldName = "portCulturaCircle";
                int portCulturaCircle = IntParse.parse(entry.get("portCulturaCircle"));
                fieldName = "buyTax";
                int buyTax = IntParse.parse(entry.get("buyTax"));
                fieldName = "SellTax";
                int SellTax = IntParse.parse(entry.get("SellTax"));
                fieldName = "portCoordinate";
                int[][] portCoordinate = IntArray2Parse.parse(entry.get("portCoordinate"));
                fieldName = "target";
                int target = IntParse.parse(entry.get("target"));
                fieldName = "portModle";
                int[][] portModle = IntArray2Parse.parse(entry.get("portModle"));
                fieldName = "Price";
                Map<Integer,Integer> Price = MapIntIntParse.parse(entry.get("Price"));

                TradePortsConfig config = new TradePortsConfig(id, portName, portLevel, portCulturaCircle, buyTax, SellTax, portCoordinate, target, portModle, Price);
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
