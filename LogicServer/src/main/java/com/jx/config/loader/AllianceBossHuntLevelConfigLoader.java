package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.AllianceBossHuntLevelConfig;
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
* 工具生成 配置文件 Alliance_Boss_Hunt_Level.xml
*/
@ConfigLoader
public class AllianceBossHuntLevelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Alliance_Boss_Hunt_Level";

    private static Map<Integer/*唯一Id*/, AllianceBossHuntLevelConfig> data = new HashMap<>();
    private static List<AllianceBossHuntLevelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<AllianceBossHuntLevelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, AllianceBossHuntLevelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static AllianceBossHuntLevelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, AllianceBossHuntLevelConfig> tempMap = new HashMap<>();
        List<AllianceBossHuntLevelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "level";
                int level = IntParse.parse(entry.get("level"));
                fieldName = "bossId";
                int bossId = IntParse.parse(entry.get("bossId"));
                fieldName = "bossAtkNum";
                int bossAtkNum = IntParse.parse(entry.get("bossAtkNum"));
                fieldName = "damToScore";
                int damToScore = IntParse.parse(entry.get("damToScore"));
                fieldName = "monsterId";
                int monsterId = IntParse.parse(entry.get("monsterId"));
                fieldName = "monsterAtkNum";
                int monsterAtkNum = IntParse.parse(entry.get("monsterAtkNum"));
                fieldName = "allianceReward";
                int[] allianceReward = IntArrayParse.parse(entry.get("allianceReward"));
                fieldName = "perReward";
                int[] perReward = IntArrayParse.parse(entry.get("perReward"));
                fieldName = "rank";
                int rank = IntParse.parse(entry.get("rank"));
                fieldName = "rankCondition";
                int rankCondition = IntParse.parse(entry.get("rankCondition"));
                fieldName = "initialStage";
                int[] initialStage = IntArrayParse.parse(entry.get("initialStage"));

                AllianceBossHuntLevelConfig config = new AllianceBossHuntLevelConfig(id, level, bossId, bossAtkNum, damToScore, monsterId, monsterAtkNum, allianceReward, perReward, rank, rankCondition, initialStage);
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
