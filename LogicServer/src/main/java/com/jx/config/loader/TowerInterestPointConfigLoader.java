package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.TowerInterestPointConfig;
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
* 工具生成 配置文件 Tower_Interest_Point.xml
*/
@ConfigLoader
public class TowerInterestPointConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Tower_Interest_Point";

    private static Map<Integer/*唯一Id*/, TowerInterestPointConfig> data = new HashMap<>();
    private static List<TowerInterestPointConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<TowerInterestPointConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, TowerInterestPointConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static TowerInterestPointConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, TowerInterestPointConfig> tempMap = new HashMap<>();
        List<TowerInterestPointConfig> tempList = new ArrayList<>();
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
                fieldName = "quality";
                int quality = IntParse.parse(entry.get("quality"));
                fieldName = "level";
                int level = IntParse.parse(entry.get("level"));
                fieldName = "isBattle";
                int isBattle = IntParse.parse(entry.get("isBattle"));
                fieldName = "worldMonster";
                int worldMonster = IntParse.parse(entry.get("worldMonster"));
                fieldName = "reward_1";
                int[][] reward_1 = IntArray2Parse.parse(entry.get("reward_1"));
                fieldName = "reward_2";
                int[][] reward_2 = IntArray2Parse.parse(entry.get("reward_2"));
                fieldName = "limitTime";
                int limitTime = IntParse.parse(entry.get("limitTime"));
                fieldName = "cond_1";
                int[] cond_1 = IntArrayParse.parse(entry.get("cond_1"));
                fieldName = "cond_2";
                int[] cond_2 = IntArrayParse.parse(entry.get("cond_2"));
                fieldName = "notePointExp";
                int notePointExp = IntParse.parse(entry.get("notePointExp"));

                TowerInterestPointConfig config = new TowerInterestPointConfig(id, type, quality, level, isBattle, worldMonster, reward_1, reward_2, limitTime, cond_1, cond_2, notePointExp);
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
