package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.GachaPoolConfig;
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
* 工具生成 配置文件 Gacha_Pool.xml
*/
@ConfigLoader
public class GachaPoolConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Gacha_Pool";

    private static Map<Integer/*唯一Id*/, GachaPoolConfig> data = new HashMap<>();
    private static List<GachaPoolConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<GachaPoolConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, GachaPoolConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static GachaPoolConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, GachaPoolConfig> tempMap = new HashMap<>();
        List<GachaPoolConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "pool";
                int pool = IntParse.parse(entry.get("pool"));
                fieldName = "isRecycle";
                int isRecycle = IntParse.parse(entry.get("isRecycle"));
                fieldName = "fixCheatByPoolId";
                int[][] fixCheatByPoolId = IntArray2Parse.parse(entry.get("fixCheatByPoolId"));
                fieldName = "cheatRPPool";
                int[][] cheatRPPool = IntArray2Parse.parse(entry.get("cheatRPPool"));
                fieldName = "race";
                int[][] race = IntArray2Parse.parse(entry.get("race"));
                fieldName = "cheatMark";
                int cheatMark = IntParse.parse(entry.get("cheatMark"));
                fieldName = "cheat4Green";
                int cheat4Green = IntParse.parse(entry.get("cheat4Green"));
                fieldName = "cheatGBPool";
                int cheatGBPool = IntParse.parse(entry.get("cheatGBPool"));

                GachaPoolConfig config = new GachaPoolConfig(id, pool, isRecycle, fixCheatByPoolId, cheatRPPool, race, cheatMark, cheat4Green, cheatGBPool);
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
