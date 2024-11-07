package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ShopUpgConfig;
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
* 工具生成 配置文件 Shop_Upg.xml
*/
@ConfigLoader
public class ShopUpgConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Shop_Upg";

    private static Map<Integer/*唯一Id*/, ShopUpgConfig> data = new HashMap<>();
    private static List<ShopUpgConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ShopUpgConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ShopUpgConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ShopUpgConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ShopUpgConfig> tempMap = new HashMap<>();
        List<ShopUpgConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "lvl";
                int lvl = IntParse.parse(entry.get("lvl"));
                fieldName = "cond";
                long[][] cond = LongArray2Parse.parse(entry.get("cond"));
                fieldName = "prodQty";
                int prodQty = IntParse.parse(entry.get("prodQty"));
                fieldName = "refreshCnt";
                int refreshCnt = IntParse.parse(entry.get("refreshCnt"));
                fieldName = "refreshCost";
                int[][] refreshCost = IntArray2Parse.parse(entry.get("refreshCost"));
                fieldName = "prodRefreshRandom";
                int[] prodRefreshRandom = IntArrayParse.parse(entry.get("prodRefreshRandom"));

                ShopUpgConfig config = new ShopUpgConfig(id, lvl, cond, prodQty, refreshCnt, refreshCost, prodRefreshRandom);
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
