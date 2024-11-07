package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.EquipNauticsDetailConfig;
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
* 工具生成 配置文件 Equip_Nautics_Detail.xml
*/
@ConfigLoader
public class EquipNauticsDetailConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Equip_Nautics_Detail";

    private static Map<Integer/*唯一Id*/, EquipNauticsDetailConfig> data = new HashMap<>();
    private static List<EquipNauticsDetailConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<EquipNauticsDetailConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, EquipNauticsDetailConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static EquipNauticsDetailConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, EquipNauticsDetailConfig> tempMap = new HashMap<>();
        List<EquipNauticsDetailConfig> tempList = new ArrayList<>();
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
                fieldName = "icon";
                String icon = StringParse.parse(entry.get("icon"));
                fieldName = "effStar0";
                int[][] effStar0 = IntArray2Parse.parse(entry.get("effStar0"));
                fieldName = "effStar1";
                int[][] effStar1 = IntArray2Parse.parse(entry.get("effStar1"));
                fieldName = "effStar2";
                int[][] effStar2 = IntArray2Parse.parse(entry.get("effStar2"));
                fieldName = "effStar3";
                int[][] effStar3 = IntArray2Parse.parse(entry.get("effStar3"));
                fieldName = "effStar4";
                int[][] effStar4 = IntArray2Parse.parse(entry.get("effStar4"));
                fieldName = "effStar5";
                int[][] effStar5 = IntArray2Parse.parse(entry.get("effStar5"));
                fieldName = "passiveEffStar0";
                int[][] passiveEffStar0 = IntArray2Parse.parse(entry.get("passiveEffStar0"));
                fieldName = "passiveEffStar1";
                int[][] passiveEffStar1 = IntArray2Parse.parse(entry.get("passiveEffStar1"));
                fieldName = "passiveEffStar2";
                int[][] passiveEffStar2 = IntArray2Parse.parse(entry.get("passiveEffStar2"));
                fieldName = "passiveEffStar3";
                int[][] passiveEffStar3 = IntArray2Parse.parse(entry.get("passiveEffStar3"));
                fieldName = "passiveEffStar4";
                int[][] passiveEffStar4 = IntArray2Parse.parse(entry.get("passiveEffStar4"));
                fieldName = "passiveEffStar5";
                int[][] passiveEffStar5 = IntArray2Parse.parse(entry.get("passiveEffStar5"));
                fieldName = "upLimit";
                int upLimit = IntParse.parse(entry.get("upLimit"));
                fieldName = "debris";
                int debris = IntParse.parse(entry.get("debris"));

                EquipNauticsDetailConfig config = new EquipNauticsDetailConfig(id, quality, icon, effStar0, effStar1, effStar2, effStar3, effStar4, effStar5, passiveEffStar0, passiveEffStar1, passiveEffStar2, passiveEffStar3, passiveEffStar4, passiveEffStar5, upLimit, debris);
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
