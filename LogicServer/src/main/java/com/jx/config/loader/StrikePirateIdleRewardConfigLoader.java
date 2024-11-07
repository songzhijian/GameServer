package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.StrikePirateIdleRewardConfig;
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
* 工具生成 配置文件 Strike_Pirate_Idle_Reward.xml
*/
@ConfigLoader
public class StrikePirateIdleRewardConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Strike_Pirate_Idle_Reward";

    private static Map<Integer/*唯一Id*/, StrikePirateIdleRewardConfig> data = new HashMap<>();
    private static List<StrikePirateIdleRewardConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<StrikePirateIdleRewardConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, StrikePirateIdleRewardConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static StrikePirateIdleRewardConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, StrikePirateIdleRewardConfig> tempMap = new HashMap<>();
        List<StrikePirateIdleRewardConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "disposableOutput";
                int[] disposableOutput = IntArrayParse.parse(entry.get("disposableOutput"));
                fieldName = "exp";
                int[] exp = IntArrayParse.parse(entry.get("exp"));
                fieldName = "dust";
                int[] dust = IntArrayParse.parse(entry.get("dust"));
                fieldName = "tech";
                int[] tech = IntArrayParse.parse(entry.get("tech"));
                fieldName = "output1";
                int[] output1 = IntArrayParse.parse(entry.get("output1"));
                fieldName = "output2";
                int[] output2 = IntArrayParse.parse(entry.get("output2"));
                fieldName = "output3";
                int[] output3 = IntArrayParse.parse(entry.get("output3"));
                fieldName = "output4";
                int[] output4 = IntArrayParse.parse(entry.get("output4"));
                fieldName = "output5";
                int[] output5 = IntArrayParse.parse(entry.get("output5"));
                fieldName = "output6";
                int[] output6 = IntArrayParse.parse(entry.get("output6"));
                fieldName = "output7";
                int[] output7 = IntArrayParse.parse(entry.get("output7"));
                fieldName = "output8";
                int[] output8 = IntArrayParse.parse(entry.get("output8"));
                fieldName = "output9";
                int[] output9 = IntArrayParse.parse(entry.get("output9"));

                StrikePirateIdleRewardConfig config = new StrikePirateIdleRewardConfig(id, disposableOutput, exp, dust, tech, output1, output2, output3, output4, output5, output6, output7, output8, output9);
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
