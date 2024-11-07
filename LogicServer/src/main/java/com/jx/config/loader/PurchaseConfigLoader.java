package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.PurchaseConfig;
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
* 工具生成 配置文件 Purchase.xml
*/
@ConfigLoader
public class PurchaseConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Purchase";

    private static Map<Integer/*唯一Id*/, PurchaseConfig> data = new HashMap<>();
    private static List<PurchaseConfig> configs = new ArrayList<>();

    /**
     * 获取所有配置文件
     */
    public static List<PurchaseConfig> findAll(){
        return configs;
    }

    public static Map<Integer/*唯一Id*/, PurchaseConfig> getData() {
        return data;
    }

    /**
     * 获取唯一ID对应的配置文件
     */
    public static PurchaseConfig getByKey(int key){
        return data.get(key);
    }

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>> all = XmlUtils.getXMLFile(CONFIG_NAME);

        Map<Integer, PurchaseConfig> tempMap = new HashMap<>();
        List<PurchaseConfig> tempList = new ArrayList<>();
        Object errorId = null;
        String fieldName = null;
        for (Map<String, String> entry : all) {
            // 各个字段
            try {
                fieldName = "id";
                int id = IntParse.parse(entry.get("id"));
                errorId = id;
                fieldName = "type";
                int type = IntParse.parse(entry.get("type"));
                fieldName = "clientSystem";
                String clientSystem = StringParse.parse(entry.get("clientSystem"));
                fieldName = "cost";
                int[][] cost = IntArray2Parse.parse(entry.get("cost"));
                fieldName = "cond";
                long[][] cond = LongArray2Parse.parse(entry.get("cond"));
                fieldName = "name";
                int name = IntParse.parse(entry.get("name"));
                fieldName = "showType";
                int showType = IntParse.parse(entry.get("showType"));
                fieldName = "showParam";
                String[] showParam = StringArrayParse.parse(entry.get("showParam"));
                fieldName = "slogan";
                int[] slogan = IntArrayParse.parse(entry.get("slogan"));
                fieldName = "labelTxt";
                int[] labelTxt = IntArrayParse.parse(entry.get("labelTxt"));
                fieldName = "order";
                int order = IntParse.parse(entry.get("order"));
                fieldName = "productId";
                String productId = StringParse.parse(entry.get("productId"));
                fieldName = "limitType";
                int limitType = IntParse.parse(entry.get("limitType"));
                fieldName = "limitCount";
                int limitCount = IntParse.parse(entry.get("limitCount"));
                fieldName = "defaultPrice";
                float defaultPrice = FloatParse.parse(entry.get("defaultPrice"));
                fieldName = "baseGem";
                int baseGem = IntParse.parse(entry.get("baseGem"));
                fieldName = "extraReward";
                int[][] extraReward = IntArray2Parse.parse(entry.get("extraReward"));
                fieldName = "alliance_gift";
                int[][] alliance_gift = IntArray2Parse.parse(entry.get("alliance_gift"));
                fieldName = "VIPCard";
                int[][] VIPCard = IntArray2Parse.parse(entry.get("VIPCard"));
                fieldName = "firstTimeReward";
                int[][] firstTimeReward = IntArray2Parse.parse(entry.get("firstTimeReward"));
                fieldName = "dailyReward";
                int[][] dailyReward = IntArray2Parse.parse(entry.get("dailyReward"));
                fieldName = "displayCond";
                long[][] displayCond = LongArray2Parse.parse(entry.get("displayCond"));
                fieldName = "displayCompCond";
                long[][] displayCompCond = LongArray2Parse.parse(entry.get("displayCompCond"));
                fieldName = "displayCond_or";
                long[][] displayCond_or = LongArray2Parse.parse(entry.get("displayCond_or"));
                fieldName = "validTime";
                int validTime = IntParse.parse(entry.get("validTime"));
                fieldName = "reset";
                boolean reset = BooleanParse.parse(entry.get("reset"));
                fieldName = "time";
                String[] time = StringArrayParse.parse(entry.get("time"));
                fieldName = "group";
                int group = IntParse.parse(entry.get("group"));
                fieldName = "trigger_cd";
                int trigger_cd = IntParse.parse(entry.get("trigger_cd"));
                fieldName = "popup";
                boolean popup = BooleanParse.parse(entry.get("popup"));
                fieldName = "clientVersion";
                String clientVersion = StringParse.parse(entry.get("clientVersion"));
                fieldName = "pushNow";
                boolean pushNow = BooleanParse.parse(entry.get("pushNow"));
                fieldName = "servers";
                long[][] servers = LongArray2Parse.parse(entry.get("servers"));
                fieldName = "isExtraDisplay";
                String isExtraDisplay = StringParse.parse(entry.get("isExtraDisplay"));

                PurchaseConfig config = new PurchaseConfig(id, type, clientSystem, cost, cond, name, showType, showParam, slogan, labelTxt, order, productId, limitType, limitCount, defaultPrice, baseGem, extraReward, alliance_gift, VIPCard, firstTimeReward, dailyReward, displayCond, displayCompCond, displayCond_or, validTime, reset, time, group, trigger_cd, popup, clientVersion, pushNow, servers, isExtraDisplay);
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
