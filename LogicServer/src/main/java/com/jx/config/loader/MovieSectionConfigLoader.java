package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.MovieSectionConfig;
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
* 工具生成 配置文件 Movie_Section.xml
*/
@ConfigLoader
public class MovieSectionConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Movie_Section";

    private static Map<Integer/*唯一Id*/, MovieSectionConfig> data = new HashMap<>();
    private static List<MovieSectionConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<MovieSectionConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, MovieSectionConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static MovieSectionConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, MovieSectionConfig> tempMap = new HashMap<>();
        List<MovieSectionConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "startSectionId";
                int startSectionId = IntParse.parse(entry.get("startSectionId"));
                errorId = startSectionId;
                fieldName = "nextStartSectionId";
                int nextStartSectionId = IntParse.parse(entry.get("nextStartSectionId"));
                fieldName = "lastSectionId";
                int lastSectionId = IntParse.parse(entry.get("lastSectionId"));
                fieldName = "param_5";
                int[] param_5 = IntArrayParse.parse(entry.get("param_5"));
                fieldName = "param_6";
                String param_6 = StringParse.parse(entry.get("param_6"));

                MovieSectionConfig config = new MovieSectionConfig(startSectionId, nextStartSectionId, lastSectionId, param_5, param_6);
                tempMap.put(startSectionId, config);
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
