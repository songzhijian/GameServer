package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SkillPassiveConfig;
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
* 工具生成 配置文件 Skill_Passive.xml
*/
@ConfigLoader
public class SkillPassiveConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Skill_Passive";

    private static Map<Integer/*唯一Id*/, SkillPassiveConfig> data = new HashMap<>();
    private static List<SkillPassiveConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SkillPassiveConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, SkillPassiveConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SkillPassiveConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, SkillPassiveConfig> tempMap = new HashMap<>();
        List<SkillPassiveConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "triggerTime";
                int[] triggerTime = IntArrayParse.parse(entry.get("triggerTime"));
                fieldName = "triggerCon";
                int[] triggerCon = IntArrayParse.parse(entry.get("triggerCon"));
                fieldName = "triggerLogicFalse";
                int triggerLogicFalse = IntParse.parse(entry.get("triggerLogicFalse"));
                fieldName = "triggerLimit";
                int triggerLimit = IntParse.parse(entry.get("triggerLimit"));
                fieldName = "src";
                String src = StringParse.parse(entry.get("src"));
                fieldName = "sound";
                String sound = StringParse.parse(entry.get("sound"));
                fieldName = "cast";
                String cast = StringParse.parse(entry.get("cast"));
                fieldName = "ani";
                String ani = StringParse.parse(entry.get("ani"));
                fieldName = "triggerSkill";
                int triggerSkill = IntParse.parse(entry.get("triggerSkill"));
                fieldName = "triggerBuff";
                String[] triggerBuff = StringArrayParse.parse(entry.get("triggerBuff"));
                fieldName = "triggerSkillFalse";
                int triggerSkillFalse = IntParse.parse(entry.get("triggerSkillFalse"));
                fieldName = "triggerBuffFalse";
                String[] triggerBuffFalse = StringArrayParse.parse(entry.get("triggerBuffFalse"));

                SkillPassiveConfig config = new SkillPassiveConfig(id, triggerTime, triggerCon, triggerLogicFalse, triggerLimit, src, sound, cast, ani, triggerSkill, triggerBuff, triggerSkillFalse, triggerBuffFalse);
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
