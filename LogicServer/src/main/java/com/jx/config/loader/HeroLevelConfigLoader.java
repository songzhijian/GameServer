package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.HeroLevelConfig;
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
* 工具生成 配置文件 Hero_Level.xml
*/
@ConfigLoader
public class HeroLevelConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Hero_Level";

    private static Map<Integer/*唯一Id*/, HeroLevelConfig> data = new HashMap<>();
    private static List<HeroLevelConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<HeroLevelConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, HeroLevelConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static HeroLevelConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, HeroLevelConfig> tempMap = new HashMap<>();
        List<HeroLevelConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "displayLevel";
                int displayLevel = IntParse.parse(entry.get("displayLevel"));
                fieldName = "rank";
                int rank = IntParse.parse(entry.get("rank"));
                fieldName = "upRank";
                int upRank = IntParse.parse(entry.get("upRank"));
                fieldName = "quality";
                int quality = IntParse.parse(entry.get("quality"));
                fieldName = "exp";
                int[][] exp = IntArray2Parse.parse(entry.get("exp"));
                fieldName = "expTotal";
                long expTotal = LongParse.parse(entry.get("expTotal"));
                fieldName = "dustTotal";
                int dustTotal = IntParse.parse(entry.get("dustTotal"));
                fieldName = "hp";
                float hp = FloatParse.parse(entry.get("hp"));
                fieldName = "atk";
                float atk = FloatParse.parse(entry.get("atk"));
                fieldName = "def";
                float def = FloatParse.parse(entry.get("def"));
                fieldName = "mdef";
                float mdef = FloatParse.parse(entry.get("mdef"));
                fieldName = "hpRank";
                float hpRank = FloatParse.parse(entry.get("hpRank"));
                fieldName = "atkRank";
                float atkRank = FloatParse.parse(entry.get("atkRank"));
                fieldName = "defRank";
                float defRank = FloatParse.parse(entry.get("defRank"));
                fieldName = "mdefRank";
                float mdefRank = FloatParse.parse(entry.get("mdefRank"));

                HeroLevelConfig config = new HeroLevelConfig(id, displayLevel, rank, upRank, quality, exp, expTotal, dustTotal, hp, atk, def, mdef, hpRank, atkRank, defRank, mdefRank);
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
