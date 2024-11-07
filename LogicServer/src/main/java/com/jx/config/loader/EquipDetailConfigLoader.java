package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.EquipDetailConfig;
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
* 工具生成 配置文件 Equip_Detail.xml
*/
@ConfigLoader
public class EquipDetailConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Equip_Detail";

    private static Map<Integer/*唯一Id*/, EquipDetailConfig> data = new HashMap<>();
    private static List<EquipDetailConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<EquipDetailConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, EquipDetailConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static EquipDetailConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, EquipDetailConfig> tempMap = new HashMap<>();
        List<EquipDetailConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "quality";
                int quality = IntParse.parse(entry.get("quality"));
                fieldName = "tier";
                int tier = IntParse.parse(entry.get("tier"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "position";
                int position = IntParse.parse(entry.get("position"));
                fieldName = "icon";
                String icon = StringParse.parse(entry.get("icon"));
                fieldName = "att";
                double[][] att = DoubleArray2Parse.parse(entry.get("att"));
                fieldName = "upExp";
                int upExp = IntParse.parse(entry.get("upExp"));
                fieldName = "upLimit";
                int upLimit = IntParse.parse(entry.get("upLimit"));
                fieldName = "raceRate";
                int raceRate = IntParse.parse(entry.get("raceRate"));
                fieldName = "need";
                int[][] need = IntArray2Parse.parse(entry.get("need"));
                fieldName = "target";
                int target = IntParse.parse(entry.get("target"));
                fieldName = "canCost";
                int canCost = IntParse.parse(entry.get("canCost"));

                EquipDetailConfig config = new EquipDetailConfig(id, quality, tier, type, position, icon, att, upExp, upLimit, raceRate, need, target, canCost);
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
