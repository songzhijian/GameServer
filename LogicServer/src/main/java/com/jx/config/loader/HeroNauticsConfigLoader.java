package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HeroNauticsConfig;
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
* 工具生成 配置文件 Hero_Nautics.xml
*/
@ConfigLoader
public class HeroNauticsConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Hero_Nautics";

    private static Map<Integer/*唯一Id*/, HeroNauticsConfig> data = new HashMap<>();
    private static List<HeroNauticsConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HeroNauticsConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HeroNauticsConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HeroNauticsConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HeroNauticsConfig> tempMap = new HashMap<>();
        List<HeroNauticsConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "nautics";
                int nautics = IntParse.parse(entry.get("nautics"));
                fieldName = "role1";
                int role1 = IntParse.parse(entry.get("role1"));
                fieldName = "eff1";
                int[][] eff1 = IntArray2Parse.parse(entry.get("eff1"));
                fieldName = "role2";
                int role2 = IntParse.parse(entry.get("role2"));
                fieldName = "eff2";
                int[][] eff2 = IntArray2Parse.parse(entry.get("eff2"));
                fieldName = "role3";
                int role3 = IntParse.parse(entry.get("role3"));
                fieldName = "eff3";
                int[][] eff3 = IntArray2Parse.parse(entry.get("eff3"));
                fieldName = "nauticsSkill1";
                int[][] nauticsSkill1 = IntArray2Parse.parse(entry.get("nauticsSkill1"));
                fieldName = "nauticsSkill2";
                int[][] nauticsSkill2 = IntArray2Parse.parse(entry.get("nauticsSkill2"));
                fieldName = "equipCount";
                int equipCount = IntParse.parse(entry.get("equipCount"));

                HeroNauticsConfig config = new HeroNauticsConfig(id, nautics, role1, eff1, role2, eff2, role3, eff3, nauticsSkill1, nauticsSkill2, equipCount);
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
