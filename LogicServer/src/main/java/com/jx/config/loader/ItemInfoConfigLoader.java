package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ItemInfoConfig;
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
* 工具生成 配置文件 Item_Info.xml
*/
@ConfigLoader
public class ItemInfoConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Item_Info";

    private static Map<Integer/*唯一Id*/, ItemInfoConfig> data = new HashMap<>();
    private static List<ItemInfoConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ItemInfoConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ItemInfoConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ItemInfoConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ItemInfoConfig> tempMap = new HashMap<>();
        List<ItemInfoConfig> tempList = new ArrayList<>();
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
                fieldName = "color";
                int color = IntParse.parse(entry.get("color"));
                fieldName = "groupNum";
                int groupNum = IntParse.parse(entry.get("groupNum"));
                fieldName = "canUse";
                int canUse = IntParse.parse(entry.get("canUse"));
                fieldName = "useCD";
                int useCD = IntParse.parse(entry.get("useCD"));
                fieldName = "useNeed";
                int useNeed = IntParse.parse(entry.get("useNeed"));
                fieldName = "useCount";
                int useCount = IntParse.parse(entry.get("useCount"));
                fieldName = "useType";
                int useType = IntParse.parse(entry.get("useType"));
                fieldName = "useParam";
                int[][] useParam = IntArray2Parse.parse(entry.get("useParam"));
                fieldName = "useConclusion";
                int useConclusion = IntParse.parse(entry.get("useConclusion"));
                fieldName = "promptNew";
                int promptNew = IntParse.parse(entry.get("promptNew"));
                fieldName = "weight";
                int weight = IntParse.parse(entry.get("weight"));
                fieldName = "timeLogic";
                int timeLogic = IntParse.parse(entry.get("timeLogic"));

                ItemInfoConfig config = new ItemInfoConfig(id, type, color, groupNum, canUse, useCD, useNeed, useCount, useType, useParam, useConclusion, promptNew, weight, timeLogic);
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
