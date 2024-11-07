package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ShipConfig;
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
* 工具生成 配置文件 Ship.xml
*/
@ConfigLoader
public class ShipConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Ship";

    private static Map<Integer/*唯一Id*/, ShipConfig> data = new HashMap<>();
    private static List<ShipConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ShipConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ShipConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ShipConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ShipConfig> tempMap = new HashMap<>();
        List<ShipConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "unlockCondition";
                long[][] unlockCondition = LongArray2Parse.parse(entry.get("unlockCondition"));
                fieldName = "color";
                int color = IntParse.parse(entry.get("color"));
                fieldName = "capacity";
                int capacity = IntParse.parse(entry.get("capacity"));
                fieldName = "capacitySize";
                int[] capacitySize = IntArrayParse.parse(entry.get("capacitySize"));
                fieldName = "capacityCoor";
                float[] capacityCoor = FloatArrayParse.parse(entry.get("capacityCoor"));
                fieldName = "baseDurability";
                int baseDurability = IntParse.parse(entry.get("baseDurability"));
                fieldName = "baseSpeed";
                float baseSpeed = FloatParse.parse(entry.get("baseSpeed"));
                fieldName = "cabinCapacity";
                int cabinCapacity = IntParse.parse(entry.get("cabinCapacity"));
                fieldName = "baseNavy";
                int baseNavy = IntParse.parse(entry.get("baseNavy"));
                fieldName = "baseCabinTrade";
                int baseCabinTrade = IntParse.parse(entry.get("baseCabinTrade"));
                fieldName = "baseCabinFood";
                int baseCabinFood = IntParse.parse(entry.get("baseCabinFood"));
                fieldName = "baseCabinWater";
                int baseCabinWater = IntParse.parse(entry.get("baseCabinWater"));
                fieldName = "basePrice";
                int[][] basePrice = IntArray2Parse.parse(entry.get("basePrice"));
                fieldName = "roomFeature";
                int[] roomFeature = IntArrayParse.parse(entry.get("roomFeature"));
                fieldName = "shipFacilities";
                int[] shipFacilities = IntArrayParse.parse(entry.get("shipFacilities"));
                fieldName = "shipEquip";
                int[] shipEquip = IntArrayParse.parse(entry.get("shipEquip"));
                fieldName = "shipDecorate";
                int[] shipDecorate = IntArrayParse.parse(entry.get("shipDecorate"));
                fieldName = "mainBuildingMaxLv";
                int mainBuildingMaxLv = IntParse.parse(entry.get("mainBuildingMaxLv"));
                fieldName = "cabinFrameworkVersion";
                int cabinFrameworkVersion = IntParse.parse(entry.get("cabinFrameworkVersion"));
                fieldName = "buyCondition";
                long[][] buyCondition = LongArray2Parse.parse(entry.get("buyCondition"));

                ShipConfig config = new ShipConfig(id, unlockCondition, color, capacity, capacitySize, capacityCoor, baseDurability, baseSpeed, cabinCapacity, baseNavy, baseCabinTrade, baseCabinFood, baseCabinWater, basePrice, roomFeature, shipFacilities, shipEquip, shipDecorate, mainBuildingMaxLv, cabinFrameworkVersion, buyCondition);
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
