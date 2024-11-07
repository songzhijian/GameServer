package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.RaftRubbishConfig;
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
* 工具生成 配置文件 Raft_Rubbish.xml
*/
@ConfigLoader
public class RaftRubbishConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Raft_Rubbish";

    private static Map<Integer/*唯一Id*/, RaftRubbishConfig> data = new HashMap<>();
    private static List<RaftRubbishConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<RaftRubbishConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, RaftRubbishConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static RaftRubbishConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, RaftRubbishConfig> tempMap = new HashMap<>();
        List<RaftRubbishConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "RefreshCenter";
                int[] RefreshCenter = IntArrayParse.parse(entry.get("RefreshCenter"));
                fieldName = "RefreshArea";
                int[] RefreshArea = IntArrayParse.parse(entry.get("RefreshArea"));
                fieldName = "rotation";
                int[] rotation = IntArrayParse.parse(entry.get("rotation"));
                fieldName = "refreshRange";
                int[] refreshRange = IntArrayParse.parse(entry.get("refreshRange"));
                fieldName = "item";
                int[][] item = IntArray2Parse.parse(entry.get("item"));
                fieldName = "Num";
                int Num = IntParse.parse(entry.get("Num"));

                RaftRubbishConfig config = new RaftRubbishConfig(id, RefreshCenter, RefreshArea, rotation, refreshRange, item, Num);
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
