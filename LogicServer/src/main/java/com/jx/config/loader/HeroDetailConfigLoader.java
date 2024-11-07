package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HeroDetailConfig;
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
* 工具生成 配置文件 Hero_Detail.xml
*/
@ConfigLoader
public class HeroDetailConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Hero_Detail";

    private static Map<Integer/*唯一Id*/, HeroDetailConfig> data = new HashMap<>();
    private static List<HeroDetailConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HeroDetailConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HeroDetailConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HeroDetailConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HeroDetailConfig> tempMap = new HashMap<>();
        List<HeroDetailConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "canUse";
                int canUse = IntParse.parse(entry.get("canUse"));
                fieldName = "canMercenary";
                int canMercenary = IntParse.parse(entry.get("canMercenary"));
                fieldName = "handbookReward";
                int[][] handbookReward = IntArray2Parse.parse(entry.get("handbookReward"));
                fieldName = "inheritAtt";
                int[][] inheritAtt = IntArray2Parse.parse(entry.get("inheritAtt"));
                fieldName = "initQuality";
                int initQuality = IntParse.parse(entry.get("initQuality"));
                fieldName = "qualityLimit";
                int qualityLimit = IntParse.parse(entry.get("qualityLimit"));
                fieldName = "levelLimit";
                int levelLimit = IntParse.parse(entry.get("levelLimit"));
                fieldName = "triggerCheat";
                boolean triggerCheat = BooleanParse.parse(entry.get("triggerCheat"));
                fieldName = "race";
                int race = IntParse.parse(entry.get("race"));
                fieldName = "male";
                int male = IntParse.parse(entry.get("male"));
                fieldName = "range";
                int range = IntParse.parse(entry.get("range"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "role";
                int role = IntParse.parse(entry.get("role"));
                fieldName = "normalAtk";
                int[][] normalAtk = IntArray2Parse.parse(entry.get("normalAtk"));
                fieldName = "skill1";
                int[][] skill1 = IntArray2Parse.parse(entry.get("skill1"));
                fieldName = "skill2";
                int[][] skill2 = IntArray2Parse.parse(entry.get("skill2"));
                fieldName = "skill3";
                int[][] skill3 = IntArray2Parse.parse(entry.get("skill3"));
                fieldName = "skill4";
                int[][] skill4 = IntArray2Parse.parse(entry.get("skill4"));
                fieldName = "hpBase";
                float hpBase = FloatParse.parse(entry.get("hpBase"));
                fieldName = "atkBase";
                float atkBase = FloatParse.parse(entry.get("atkBase"));
                fieldName = "defBase";
                float defBase = FloatParse.parse(entry.get("defBase"));
                fieldName = "mdefBase";
                float mdefBase = FloatParse.parse(entry.get("mdefBase"));
                fieldName = "hpCoef";
                float hpCoef = FloatParse.parse(entry.get("hpCoef"));
                fieldName = "atkCoef";
                float atkCoef = FloatParse.parse(entry.get("atkCoef"));
                fieldName = "defCoef";
                float defCoef = FloatParse.parse(entry.get("defCoef"));
                fieldName = "mdefCoef";
                float mdefCoef = FloatParse.parse(entry.get("mdefCoef"));
                fieldName = "TalentCount";
                int TalentCount = IntParse.parse(entry.get("TalentCount"));
                fieldName = "Speciality";
                int Speciality = IntParse.parse(entry.get("Speciality"));
                fieldName = "talent1unlock";
                int talent1unlock = IntParse.parse(entry.get("talent1unlock"));
                fieldName = "talent2unlock";
                int talent2unlock = IntParse.parse(entry.get("talent2unlock"));
                fieldName = "talent3unlock";
                int talent3unlock = IntParse.parse(entry.get("talent3unlock"));
                fieldName = "talent4unlock";
                int talent4unlock = IntParse.parse(entry.get("talent4unlock"));
                fieldName = "talentRandomGroup";
                int talentRandomGroup = IntParse.parse(entry.get("talentRandomGroup"));
                fieldName = "reprint";
                int[] reprint = IntArrayParse.parse(entry.get("reprint"));
                fieldName = "reprintUltra";
                int[] reprintUltra = IntArrayParse.parse(entry.get("reprintUltra"));
                fieldName = "exclusive";
                int exclusive = IntParse.parse(entry.get("exclusive"));

                HeroDetailConfig config = new HeroDetailConfig(id, canUse, canMercenary, handbookReward, inheritAtt, initQuality, qualityLimit, levelLimit, triggerCheat, race, male, range, type, role, normalAtk, skill1, skill2, skill3, skill4, hpBase, atkBase, defBase, mdefBase, hpCoef, atkCoef, defCoef, mdefCoef, TalentCount, Speciality, talent1unlock, talent2unlock, talent3unlock, talent4unlock, talentRandomGroup, reprint, reprintUltra, exclusive);
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
