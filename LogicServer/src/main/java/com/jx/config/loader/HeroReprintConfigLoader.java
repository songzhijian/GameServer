package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HeroReprintConfig;
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
* 工具生成 配置文件 Hero_Reprint.xml
*/
@ConfigLoader
public class HeroReprintConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Hero_Reprint";

    private static Map<Integer/*唯一Id*/, HeroReprintConfig> data = new HashMap<>();
    private static List<HeroReprintConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HeroReprintConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HeroReprintConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HeroReprintConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HeroReprintConfig> tempMap = new HashMap<>();
        List<HeroReprintConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "hero";
                int hero = IntParse.parse(entry.get("hero"));
                fieldName = "unlockSeason";
                int unlockSeason = IntParse.parse(entry.get("unlockSeason"));
                fieldName = "unlockCon";
                int unlockCon = IntParse.parse(entry.get("unlockCon"));
                fieldName = "cost";
                int[] cost = IntArrayParse.parse(entry.get("cost"));

                HeroReprintConfig config = new HeroReprintConfig(id, hero, unlockSeason, unlockCon, cost);
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
