package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.RaftConstructConfig;
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
* 工具生成 配置文件 Raft_Construct.xml
*/
@ConfigLoader
public class RaftConstructConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Raft_Construct";

    private static Map<Integer/*唯一Id*/, RaftConstructConfig> data = new HashMap<>();
    private static List<RaftConstructConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<RaftConstructConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, RaftConstructConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static RaftConstructConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, RaftConstructConfig> tempMap = new HashMap<>();
        List<RaftConstructConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "constructType";
                int constructType = IntParse.parse(entry.get("constructType"));
                fieldName = "buildSize";
                int[] buildSize = IntArrayParse.parse(entry.get("buildSize"));
                fieldName = "collisionSize";
                int[] collisionSize = IntArrayParse.parse(entry.get("collisionSize"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "costTime";
                int costTime = IntParse.parse(entry.get("costTime"));
                fieldName = "maxNum";
                int maxNum = IntParse.parse(entry.get("maxNum"));
                fieldName = "funcType";
                int funcType = IntParse.parse(entry.get("funcType"));
                fieldName = "funcParam";
                String funcParam = StringParse.parse(entry.get("funcParam"));
                fieldName = "hero";
                String hero = StringParse.parse(entry.get("hero"));
                fieldName = "interactionTime";
                int interactionTime = IntParse.parse(entry.get("interactionTime"));
                fieldName = "damageTime";
                int[] damageTime = IntArrayParse.parse(entry.get("damageTime"));
                fieldName = "repairTime";
                int repairTime = IntParse.parse(entry.get("repairTime"));
                fieldName = "repairCost";
                int[][] repairCost = IntArray2Parse.parse(entry.get("repairCost"));
                fieldName = "HP";
                int HP = IntParse.parse(entry.get("HP"));
                fieldName = "damageHp";
                int[] damageHp = IntArrayParse.parse(entry.get("damageHp"));
                fieldName = "taskId";
                int taskId = IntParse.parse(entry.get("taskId"));

                RaftConstructConfig config = new RaftConstructConfig(id, constructType, buildSize, collisionSize, cost, costTime, maxNum, funcType, funcParam, hero, interactionTime, damageTime, repairTime, repairCost, HP, damageHp, taskId);
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
