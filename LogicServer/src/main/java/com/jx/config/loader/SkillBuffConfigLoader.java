package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.SkillBuffConfig;
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
* 工具生成 配置文件 Skill_Buff.xml
*/
@ConfigLoader
public class SkillBuffConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Skill_Buff";

    private static Map<String/*唯一Id*/, SkillBuffConfig> data = new HashMap<>();
    private static List<SkillBuffConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SkillBuffConfig> findAll(){
        return configs;
    }

    public static Map<String/*唯一Id*/, SkillBuffConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SkillBuffConfig getByKey(String key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<String, SkillBuffConfig> tempMap = new HashMap<>();
        List<SkillBuffConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "buffId";
                String buffId = StringParse.parse(entry.get("buffId"));
                errorId = buffId;
                fieldName = "timeType";
                int timeType = IntParse.parse(entry.get("timeType"));
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "label";
                int label = IntParse.parse(entry.get("label"));
                fieldName = "unstoppable";
                int unstoppable = IntParse.parse(entry.get("unstoppable"));
                fieldName = "p";
                float p = FloatParse.parse(entry.get("p"));
                fieldName = "addPower";
                int addPower = IntParse.parse(entry.get("addPower"));
                fieldName = "time";
                int[] time = IntArrayParse.parse(entry.get("time"));
                fieldName = "overlayType";
                int overlayType = IntParse.parse(entry.get("overlayType"));
                fieldName = "maxLayer";
                int maxLayer = IntParse.parse(entry.get("maxLayer"));
                fieldName = "transform";
                int transform = IntParse.parse(entry.get("transform"));
                fieldName = "eff";
                float[][] eff = FloatArray2Parse.parse(entry.get("eff"));
                fieldName = "cited";
                int[] cited = IntArrayParse.parse(entry.get("cited"));
                fieldName = "icon";
                String icon = StringParse.parse(entry.get("icon"));
                fieldName = "description";
                int description = IntParse.parse(entry.get("description"));

                SkillBuffConfig config = new SkillBuffConfig(buffId, timeType, type, label, unstoppable, p, addPower, time, overlayType, maxLayer, transform, eff, cited, icon, description);
                tempMap.put(buffId, config);
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
