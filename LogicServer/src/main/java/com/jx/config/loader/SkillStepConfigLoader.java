package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SkillStepConfig;
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
* 工具生成 配置文件 Skill_Step.xml
*/
@ConfigLoader
public class SkillStepConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Skill_Step";

    private static Map<String/*唯一Id*/, SkillStepConfig> data = new HashMap<>();
    private static List<SkillStepConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SkillStepConfig> findAll(){
        return configs;
    }

    public static Map<String/*唯一Id*/, SkillStepConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SkillStepConfig getByKey(String key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<String, SkillStepConfig> tempMap = new HashMap<>();
        List<SkillStepConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "skillId";
                String skillId = StringParse.parse(entry.get("skillId"));
                errorId = skillId;
                fieldName = "skill";
                int skill = IntParse.parse(entry.get("skill"));
                fieldName = "hero";
                int hero = IntParse.parse(entry.get("hero"));
                fieldName = "front";
                String front = StringParse.parse(entry.get("front"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "isResetList";
                int isResetList = IntParse.parse(entry.get("isResetList"));
                fieldName = "rangeType";
                int rangeType = IntParse.parse(entry.get("rangeType"));
                fieldName = "rangeParam";
                int[] rangeParam = IntArrayParse.parse(entry.get("rangeParam"));
                fieldName = "targetType";
                int targetType = IntParse.parse(entry.get("targetType"));
                fieldName = "targetParam";
                int[] targetParam = IntArrayParse.parse(entry.get("targetParam"));
                fieldName = "priorityType";
                int priorityType = IntParse.parse(entry.get("priorityType"));
                fieldName = "priorityParam";
                int[] priorityParam = IntArrayParse.parse(entry.get("priorityParam"));
                fieldName = "next";
                String next = StringParse.parse(entry.get("next"));
                fieldName = "moveLogic";
                int moveLogic = IntParse.parse(entry.get("moveLogic"));
                fieldName = "createPos";
                int createPos = IntParse.parse(entry.get("createPos"));
                fieldName = "createParam";
                String createParam = StringParse.parse(entry.get("createParam"));
                fieldName = "createCoor";
                float[] createCoor = FloatArrayParse.parse(entry.get("createCoor"));
                fieldName = "missleSpd";
                float missleSpd = FloatParse.parse(entry.get("missleSpd"));
                fieldName = "missleTime";
                int missleTime = IntParse.parse(entry.get("missleTime"));
                fieldName = "missleType";
                int missleType = IntParse.parse(entry.get("missleType"));
                fieldName = "missleSrc";
                String[] missleSrc = StringArrayParse.parse(entry.get("missleSrc"));
                fieldName = "triggerType";
                int triggerType = IntParse.parse(entry.get("triggerType"));
                fieldName = "missleEndFrame";
                int missleEndFrame = IntParse.parse(entry.get("missleEndFrame"));
                fieldName = "boundHit";
                int boundHit = IntParse.parse(entry.get("boundHit"));
                fieldName = "actOnSelf";
                int actOnSelf = IntParse.parse(entry.get("actOnSelf"));
                fieldName = "atkCondition";
                String[] atkCondition = StringArrayParse.parse(entry.get("atkCondition"));
                fieldName = "atkEff2";
                String[] atkEff2 = StringArrayParse.parse(entry.get("atkEff2"));
                fieldName = "isKickList";
                int isKickList = IntParse.parse(entry.get("isKickList"));

                SkillStepConfig config = new SkillStepConfig(skillId, skill, hero, front, type, isResetList, rangeType, rangeParam, targetType, targetParam, priorityType, priorityParam, next, moveLogic, createPos, createParam, createCoor, missleSpd, missleTime, missleType, missleSrc, triggerType, missleEndFrame, boundHit, actOnSelf, atkCondition, atkEff2, isKickList);
                tempMap.put(skillId, config);
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
