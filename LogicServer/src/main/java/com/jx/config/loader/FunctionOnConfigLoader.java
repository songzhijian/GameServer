package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.FunctionOnConfig;
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
* 工具生成 配置文件 Function_On.xml
*/
@ConfigLoader
public class FunctionOnConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Function_On";

    private static Map<Integer/*唯一Id*/, FunctionOnConfig> data = new HashMap<>();
    private static List<FunctionOnConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<FunctionOnConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, FunctionOnConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static FunctionOnConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, FunctionOnConfig> tempMap = new HashMap<>();
        List<FunctionOnConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "local";
                String local = StringParse.parse(entry.get("local"));
                fieldName = "online";
                String online = StringParse.parse(entry.get("online"));
                fieldName = "test";
                String test = StringParse.parse(entry.get("test"));
                fieldName = "version";
                String version = StringParse.parse(entry.get("version"));
                fieldName = "platform";
                String platform = StringParse.parse(entry.get("platform"));

                FunctionOnConfig config = new FunctionOnConfig(id, local, online, test, version, platform);
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
