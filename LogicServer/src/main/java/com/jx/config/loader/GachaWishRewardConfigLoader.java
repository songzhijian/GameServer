package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.GachaWishRewardConfig;
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
* 工具生成 配置文件 Gacha_Wish_Reward.xml
*/
@ConfigLoader
public class GachaWishRewardConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Gacha_Wish_Reward";

    private static Map<Integer/*唯一Id*/, GachaWishRewardConfig> data = new HashMap<>();
    private static List<GachaWishRewardConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<GachaWishRewardConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, GachaWishRewardConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static GachaWishRewardConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, GachaWishRewardConfig> tempMap = new HashMap<>();
        List<GachaWishRewardConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "cost1";
                int cost1 = IntParse.parse(entry.get("cost1"));
                fieldName = "reward1";
                int[][] reward1 = IntArray2Parse.parse(entry.get("reward1"));
                fieldName = "cost2";
                int cost2 = IntParse.parse(entry.get("cost2"));
                fieldName = "reward2";
                int[][] reward2 = IntArray2Parse.parse(entry.get("reward2"));
                fieldName = "cost3";
                int cost3 = IntParse.parse(entry.get("cost3"));
                fieldName = "reward3";
                int[][] reward3 = IntArray2Parse.parse(entry.get("reward3"));
                fieldName = "cost4";
                int cost4 = IntParse.parse(entry.get("cost4"));
                fieldName = "reward4";
                int[][] reward4 = IntArray2Parse.parse(entry.get("reward4"));

                GachaWishRewardConfig config = new GachaWishRewardConfig(id, cost1, reward1, cost2, reward2, cost3, reward3, cost4, reward4);
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
