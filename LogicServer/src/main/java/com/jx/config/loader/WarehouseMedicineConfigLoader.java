package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.WarehouseMedicineConfig;
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
* 工具生成 配置文件 Warehouse_Medicine.xml
*/
@ConfigLoader
public class WarehouseMedicineConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Warehouse_Medicine";

    private static Map<Integer/*唯一Id*/, WarehouseMedicineConfig> data = new HashMap<>();
    private static List<WarehouseMedicineConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<WarehouseMedicineConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, WarehouseMedicineConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static WarehouseMedicineConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, WarehouseMedicineConfig> tempMap = new HashMap<>();
        List<WarehouseMedicineConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "lv";
                int lv = IntParse.parse(entry.get("lv"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "time";
                int time = IntParse.parse(entry.get("time"));
                fieldName = "timeUp";
                int timeUp = IntParse.parse(entry.get("timeUp"));
                fieldName = "itemLink";
                int itemLink = IntParse.parse(entry.get("itemLink"));

                WarehouseMedicineConfig config = new WarehouseMedicineConfig(id, lv, cost, time, timeUp, itemLink);
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
