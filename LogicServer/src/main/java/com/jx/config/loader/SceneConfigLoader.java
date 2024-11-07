package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.custom.SceneConfigCustomLoader;
import com.jx.config.model.SceneConfig;
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
* 工具生成 配置文件 Scene.xml
*/
@ConfigLoader
public class SceneConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Scene";

    private static Map<Integer/*唯一Id*/, SceneConfig> data = new HashMap<>();
    private static List<SceneConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<SceneConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, SceneConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static SceneConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, SceneConfig> tempMap = new HashMap<>();
        List<SceneConfig> tempList = new ArrayList<>();
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
                fieldName = "size";
                int[] size = IntArrayParse.parse(entry.get("size"));
                fieldName = "relevanceMap";
                String relevanceMap = StringParse.parse(entry.get("relevanceMap"));
                fieldName = "mapRecurrence";
                int mapRecurrence = IntParse.parse(entry.get("mapRecurrence"));
                fieldName = "cameraLock";
                int cameraLock = IntParse.parse(entry.get("cameraLock"));
                fieldName = "cameraLockBoat";
                int cameraLockBoat = IntParse.parse(entry.get("cameraLockBoat"));
                fieldName = "mapDataId";
                String mapDataId = StringParse.parse(entry.get("mapDataId"));
                fieldName = "block";
                int[] block = IntArrayParse.parse(entry.get("block"));
                fieldName = "position";
                int[] position = IntArrayParse.parse(entry.get("position"));
                fieldName = "sailLineDataId";
                String sailLineDataId = StringParse.parse(entry.get("sailLineDataId"));
                fieldName = "logicType";
                int[][] logicType = IntArray2Parse.parse(entry.get("logicType"));
                fieldName = "ring";
                boolean ring = BooleanParse.parse(entry.get("ring"));
                fieldName = "destroy";
                int[] destroy = IntArrayParse.parse(entry.get("destroy"));
                fieldName = "numOfBirth";
                int[] numOfBirth = IntArrayParse.parse(entry.get("numOfBirth"));
                fieldName = "birthArea";
                int[] birthArea = IntArrayParse.parse(entry.get("birthArea"));
                fieldName = "numOfArea";
                int[][] numOfArea = IntArray2Parse.parse(entry.get("numOfArea"));
                fieldName = "speed";
                float speed = FloatParse.parse(entry.get("speed"));
                fieldName = "zoom";
                int zoom = IntParse.parse(entry.get("zoom"));

                SceneConfig config = new SceneConfig(id, name, size, relevanceMap, mapRecurrence, cameraLock, cameraLockBoat, mapDataId, block, position, sailLineDataId, logicType, ring, destroy, numOfBirth, birthArea, numOfArea, speed, zoom);
                tempMap.put(id, config);
                tempList.add(config);
            } catch (Exception e) {
                ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, id = %s, fieldName = %s message = %s", CONFIG_NAME, errorId, fieldName, e.getMessage());
                LogUtils.logger.warn(ConfigGlobalManager.error,e);
                throw e;
            }
        }
        LogUtils.logger.info("[ConfigLoader] load config {} finish, data size = {}", CONFIG_NAME, tempList.size());
        SceneConfigCustomLoader.oldConfig = configs;
        data = Collections.unmodifiableMap(tempMap);
        configs = Collections.unmodifiableList(tempList);
    }
}
