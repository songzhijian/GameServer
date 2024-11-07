package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HeroQualityConfig;
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
* 工具生成 配置文件 Hero_Quality.xml
*/
@ConfigLoader
public class HeroQualityConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Hero_Quality";

    private static Map<Integer/*唯一Id*/, HeroQualityConfig> data = new HashMap<>();
    private static List<HeroQualityConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HeroQualityConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HeroQualityConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HeroQualityConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HeroQualityConfig> tempMap = new HashMap<>();
        List<HeroQualityConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "credits";
                int credits = IntParse.parse(entry.get("credits"));
                fieldName = "wordlessBookPower";
                int[][] wordlessBookPower = IntArray2Parse.parse(entry.get("wordlessBookPower"));
                fieldName = "coef";
                float coef = FloatParse.parse(entry.get("coef"));
                fieldName = "hpAdd";
                float hpAdd = FloatParse.parse(entry.get("hpAdd"));
                fieldName = "atkAdd";
                float atkAdd = FloatParse.parse(entry.get("atkAdd"));
                fieldName = "defAdd";
                float defAdd = FloatParse.parse(entry.get("defAdd"));
                fieldName = "mdefAdd";
                float mdefAdd = FloatParse.parse(entry.get("mdefAdd"));
                fieldName = "level";
                int level = IntParse.parse(entry.get("level"));
                fieldName = "canExceedLv";
                int canExceedLv = IntParse.parse(entry.get("canExceedLv"));
                fieldName = "need1";
                int[] need1 = IntArrayParse.parse(entry.get("need1"));
                fieldName = "same";
                int same = IntParse.parse(entry.get("same"));
                fieldName = "science";
                int science = IntParse.parse(entry.get("science"));
                fieldName = "need2";
                int[] need2 = IntArrayParse.parse(entry.get("need2"));
                fieldName = "same2";
                int same2 = IntParse.parse(entry.get("same2"));

                HeroQualityConfig config = new HeroQualityConfig(id, credits, wordlessBookPower, coef, hpAdd, atkAdd, defAdd, mdefAdd, level, canExceedLv, need1, same, science, need2, same2);
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
