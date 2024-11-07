package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.VipLevelConfig;
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
* 工具生成 配置文件 Vip_Level.xml
*/
@ConfigLoader
public class VipLevelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Vip_Level";

    private static Map<Integer/*唯一Id*/, VipLevelConfig> data = new HashMap<>();
    private static List<VipLevelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<VipLevelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, VipLevelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static VipLevelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, VipLevelConfig> tempMap = new HashMap<>();
        List<VipLevelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "lvl";
                int lvl = IntParse.parse(entry.get("lvl"));
                errorId = lvl;
                fieldName = "season";
                int season = IntParse.parse(entry.get("season"));
                fieldName = "exp";
                int exp = IntParse.parse(entry.get("exp"));
                fieldName = "dailyReward";
                int[][] dailyReward = IntArray2Parse.parse(entry.get("dailyReward"));
                fieldName = "vipBonus";
                int vipBonus = IntParse.parse(entry.get("vipBonus"));
                fieldName = "worldBuff";
                int[] worldBuff = IntArrayParse.parse(entry.get("worldBuff"));
                fieldName = "shopLvl";
                int shopLvl = IntParse.parse(entry.get("shopLvl"));

                VipLevelConfig config = new VipLevelConfig(lvl, season, exp, dailyReward, vipBonus, worldBuff, shopLvl);
                tempMap.put(lvl, config);
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
