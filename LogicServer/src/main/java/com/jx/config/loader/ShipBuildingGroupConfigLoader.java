package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ShipBuildingGroupConfig;
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
* 工具生成 配置文件 Ship_Building_Group.xml
*/
@ConfigLoader
public class ShipBuildingGroupConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Ship_Building_Group";

    private static Map<Integer/*唯一Id*/, ShipBuildingGroupConfig> data = new HashMap<>();
    private static List<ShipBuildingGroupConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ShipBuildingGroupConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ShipBuildingGroupConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ShipBuildingGroupConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ShipBuildingGroupConfig> tempMap = new HashMap<>();
        List<ShipBuildingGroupConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "role";
                int role = IntParse.parse(entry.get("role"));
                fieldName = "maxLevel";
                int maxLevel = IntParse.parse(entry.get("maxLevel"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "canStore";
                int canStore = IntParse.parse(entry.get("canStore"));
                fieldName = "canMove";
                int canMove = IntParse.parse(entry.get("canMove"));
                fieldName = "isDemolition";
                boolean isDemolition = BooleanParse.parse(entry.get("isDemolition"));
                fieldName = "isDemolitionNeedHero";
                boolean isDemolitionNeedHero = BooleanParse.parse(entry.get("isDemolitionNeedHero"));
                fieldName = "stationNum";
                int stationNum = IntParse.parse(entry.get("stationNum"));
                fieldName = "size";
                int[] size = IntArrayParse.parse(entry.get("size"));
                fieldName = "mostNum";
                int mostNum = IntParse.parse(entry.get("mostNum"));
                fieldName = "order";
                int order = IntParse.parse(entry.get("order"));
                fieldName = "teleport";
                int teleport = IntParse.parse(entry.get("teleport"));
                fieldName = "canDuplicate";
                int canDuplicate = IntParse.parse(entry.get("canDuplicate"));
                fieldName = "defaultCompletion";
                int defaultCompletion = IntParse.parse(entry.get("defaultCompletion"));

                ShipBuildingGroupConfig config = new ShipBuildingGroupConfig(id, role, maxLevel, type, canStore, canMove, isDemolition, isDemolitionNeedHero, stationNum, size, mostNum, order, teleport, canDuplicate, defaultCompletion);
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
