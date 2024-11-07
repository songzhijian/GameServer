package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SkillBaseConfig;
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
* 工具生成 配置文件 Skill_Base.xml
*/
@ConfigLoader
public class SkillBaseConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Skill_Base";

    private static Map<Integer/*唯一Id*/, SkillBaseConfig> data = new HashMap<>();
    private static List<SkillBaseConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SkillBaseConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, SkillBaseConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SkillBaseConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, SkillBaseConfig> tempMap = new HashMap<>();
        List<SkillBaseConfig> tempList = new ArrayList<>();
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
                fieldName = "position";
                int position = IntParse.parse(entry.get("position"));
                fieldName = "stage";
                int stage = IntParse.parse(entry.get("stage"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "isSpecial";
                int isSpecial = IntParse.parse(entry.get("isSpecial"));
                fieldName = "cost";
                int[] cost = IntArrayParse.parse(entry.get("cost"));
                fieldName = "condition";
                int[] condition = IntArrayParse.parse(entry.get("condition"));
                fieldName = "rangeType";
                int rangeType = IntParse.parse(entry.get("rangeType"));
                fieldName = "range";
                float[] range = FloatArrayParse.parse(entry.get("range"));
                fieldName = "targetType";
                int targetType = IntParse.parse(entry.get("targetType"));
                fieldName = "targetParam";
                int[] targetParam = IntArrayParse.parse(entry.get("targetParam"));
                fieldName = "cd1";
                float cd1 = FloatParse.parse(entry.get("cd1"));
                fieldName = "cd2";
                float cd2 = FloatParse.parse(entry.get("cd2"));
                fieldName = "gcd";
                float gcd = FloatParse.parse(entry.get("gcd"));
                fieldName = "addPower";
                int addPower = IntParse.parse(entry.get("addPower"));
                fieldName = "unstoppable";
                int unstoppable = IntParse.parse(entry.get("unstoppable"));
                fieldName = "frontHalf";
                int frontHalf = IntParse.parse(entry.get("frontHalf"));
                fieldName = "behindHalf";
                int behindHalf = IntParse.parse(entry.get("behindHalf"));
                fieldName = "canBreak1";
                int canBreak1 = IntParse.parse(entry.get("canBreak1"));
                fieldName = "canBreak2";
                int canBreak2 = IntParse.parse(entry.get("canBreak2"));
                fieldName = "isResetCD";
                int isResetCD = IntParse.parse(entry.get("isResetCD"));
                fieldName = "endFrame";
                int endFrame = IntParse.parse(entry.get("endFrame"));
                fieldName = "movParam";
                int[][] movParam = IntArray2Parse.parse(entry.get("movParam"));
                fieldName = "param";
                String param = StringParse.parse(entry.get("param"));
                fieldName = "isSing";
                int isSing = IntParse.parse(entry.get("isSing"));
                fieldName = "isSpell";
                int[] isSpell = IntArrayParse.parse(entry.get("isSpell"));
                fieldName = "spellUltra";
                int spellUltra = IntParse.parse(entry.get("spellUltra"));

                SkillBaseConfig config = new SkillBaseConfig(id, hero, position, stage, type, isSpecial, cost, condition, rangeType, range, targetType, targetParam, cd1, cd2, gcd, addPower, unstoppable, frontHalf, behindHalf, canBreak1, canBreak2, isResetCD, endFrame, movParam, param, isSing, isSpell, spellUltra);
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
