package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.ArenaBotConfig;
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
* 工具生成 配置文件 Arena_Bot.xml
*/
@ConfigLoader
public class ArenaBotConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Arena_Bot";

    private static Map<Integer/*唯一Id*/, ArenaBotConfig> data = new HashMap<>();
    private static List<ArenaBotConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<ArenaBotConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, ArenaBotConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static ArenaBotConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, ArenaBotConfig> tempMap = new HashMap<>();
        List<ArenaBotConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "name";
                String name = StringParse.parse(entry.get("name"));
                fieldName = "icon";
                int icon = IntParse.parse(entry.get("icon"));
                fieldName = "battle";
                int battle = IntParse.parse(entry.get("battle"));
                fieldName = "integral";
                int integral = IntParse.parse(entry.get("integral"));
                fieldName = "elimination";
                int elimination = IntParse.parse(entry.get("elimination"));

                ArenaBotConfig config = new ArenaBotConfig(id, name, icon, battle, integral, elimination);
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