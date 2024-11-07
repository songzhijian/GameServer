package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.AdventureExpAccelConfig;
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
* 工具生成 配置文件 Adventure_Exp_Accel.xml
*/
@ConfigLoader
public class AdventureExpAccelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Adventure_Exp_Accel";

    private static Map<Integer/*唯一Id*/, AdventureExpAccelConfig> data = new HashMap<>();
    private static List<AdventureExpAccelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<AdventureExpAccelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, AdventureExpAccelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static AdventureExpAccelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, AdventureExpAccelConfig> tempMap = new HashMap<>();
        List<AdventureExpAccelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "day";
                int[][] day = IntArray2Parse.parse(entry.get("day"));
                fieldName = "level";
                int[] level = IntArrayParse.parse(entry.get("level"));
                fieldName = "buff";
                int[] buff = IntArrayParse.parse(entry.get("buff"));
                fieldName = "seasonLimit";
                int seasonLimit = IntParse.parse(entry.get("seasonLimit"));

                AdventureExpAccelConfig config = new AdventureExpAccelConfig(id, day, level, buff, seasonLimit);
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
