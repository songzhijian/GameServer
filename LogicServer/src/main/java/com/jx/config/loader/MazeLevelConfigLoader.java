package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.MazeLevelConfig;
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
* 工具生成 配置文件 Maze_Level.xml
*/
@ConfigLoader
public class MazeLevelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Maze_Level";

    private static Map<Integer/*唯一Id*/, MazeLevelConfig> data = new HashMap<>();
    private static List<MazeLevelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<MazeLevelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, MazeLevelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static MazeLevelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, MazeLevelConfig> tempMap = new HashMap<>();
        List<MazeLevelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "rank";
                int rank = IntParse.parse(entry.get("rank"));
                fieldName = "mapLib";
                int[] mapLib = IntArrayParse.parse(entry.get("mapLib"));
                fieldName = "heroLib";
                int[] heroLib = IntArrayParse.parse(entry.get("heroLib"));
                fieldName = "relicLib";
                int[] relicLib = IntArrayParse.parse(entry.get("relicLib"));
                fieldName = "tradeLib";
                int[] tradeLib = IntArrayParse.parse(entry.get("tradeLib"));
                fieldName = "passReward1";
                int[][] passReward1 = IntArray2Parse.parse(entry.get("passReward1"));
                fieldName = "passReward2";
                int[][] passReward2 = IntArray2Parse.parse(entry.get("passReward2"));
                fieldName = "passReward3";
                int[][] passReward3 = IntArray2Parse.parse(entry.get("passReward3"));

                MazeLevelConfig config = new MazeLevelConfig(id, rank, mapLib, heroLib, relicLib, tradeLib, passReward1, passReward2, passReward3);
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
