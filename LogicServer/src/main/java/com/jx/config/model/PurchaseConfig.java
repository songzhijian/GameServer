package com.jx.config.model;

import com.jx.config.loader.PurchaseConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Purchase.xml
*/
public class PurchaseConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**功能类型*/
    private final int type;
    /**系统类型*/
    private final String clientSystem;
    /**道具购买*/
    private final int[][] cost;
    /**购买条件*/
    private final long[][] cond;
    /**商品名*/
    private final int name;
    /**表现类型*/
    private final int showType;
    /**表现参数*/
    private final String[] showParam;
    /**商品宣传语*/
    private final int[] slogan;
    /**标签文字*/
    private final int[] labelTxt;
    /**排序*/
    private final int order;
    /**通用IAP*/
    private final String productId;
    /**限购类型*/
    private final int limitType;
    /**限购次数*/
    private final int limitCount;
    /**基础美元定价*/
    private final float defaultPrice;
    /**基础宝石数量*/
    private final int baseGem;
    /**额外道具奖励*/
    private final int[][] extraReward;
    /**联盟礼物*/
    private final int[][] alliance_gift;
    /**VIP卡*/
    private final int[][] VIPCard;
    /**首充奖励*/
    private final int[][] firstTimeReward;
    /**每日奖励（若有）*/
    private final int[][] dailyReward;
    /**不计数触发条件*/
    private final long[][] displayCond;
    /**计数触发条件*/
    private final long[][] displayCompCond;
    /**不计数触发条件2*/
    private final long[][] displayCond_or;
    /**限购时间*/
    private final int validTime;
    /**重置条件*/
    private final boolean reset;
    /**时间方式*/
    private final String[] time;
    /**礼包组id*/
    private final int group;
    /**触发冷却时间*/
    private final int trigger_cd;
    /**触发时弹窗*/
    private final boolean popup;
    /**礼包版本*/
    private final String clientVersion;
    /**即刻推送*/
    private final boolean pushNow;
    /**生效服务器*/
    private final long[][] servers;
    /**是否额外显示*/
    private final String isExtraDisplay;

    /**
     * 获取所有配置
     */
    public static List<PurchaseConfig> findAll(){
        return PurchaseConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PurchaseConfig getByKey(int key){
        return PurchaseConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 功能类型
     */
    public int getType() {
        return type;
    }

    /**
     * 系统类型
     */
    public String getClientSystem() {
        return clientSystem;
    }

    /**
     * 道具购买
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 购买条件
     */
    public long[][] getCond() {
        return cond;
    }

    /**
     * 商品名
     */
    public int getName() {
        return name;
    }

    /**
     * 表现类型
     */
    public int getShowType() {
        return showType;
    }

    /**
     * 表现参数
     */
    public String[] getShowParam() {
        return showParam;
    }

    /**
     * 商品宣传语
     */
    public int[] getSlogan() {
        return slogan;
    }

    /**
     * 标签文字
     */
    public int[] getLabelTxt() {
        return labelTxt;
    }

    /**
     * 排序
     */
    public int getOrder() {
        return order;
    }

    /**
     * 通用IAP
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 限购类型
     */
    public int getLimitType() {
        return limitType;
    }

    /**
     * 限购次数
     */
    public int getLimitCount() {
        return limitCount;
    }

    /**
     * 基础美元定价
     */
    public float getDefaultPrice() {
        return defaultPrice;
    }

    /**
     * 基础宝石数量
     */
    public int getBaseGem() {
        return baseGem;
    }

    /**
     * 额外道具奖励
     */
    public int[][] getExtraReward() {
        return extraReward;
    }

    /**
     * 联盟礼物
     */
    public int[][] getAlliance_gift() {
        return alliance_gift;
    }

    /**
     * VIP卡
     */
    public int[][] getVIPCard() {
        return VIPCard;
    }

    /**
     * 首充奖励
     */
    public int[][] getFirstTimeReward() {
        return firstTimeReward;
    }

    /**
     * 每日奖励（若有）
     */
    public int[][] getDailyReward() {
        return dailyReward;
    }

    /**
     * 不计数触发条件
     */
    public long[][] getDisplayCond() {
        return displayCond;
    }

    /**
     * 计数触发条件
     */
    public long[][] getDisplayCompCond() {
        return displayCompCond;
    }

    /**
     * 不计数触发条件2
     */
    public long[][] getDisplayCond_or() {
        return displayCond_or;
    }

    /**
     * 限购时间
     */
    public int getValidTime() {
        return validTime;
    }

    /**
     * 重置条件
     */
    public boolean isReset() {
        return reset;
    }

    /**
     * 时间方式
     */
    public String[] getTime() {
        return time;
    }

    /**
     * 礼包组id
     */
    public int getGroup() {
        return group;
    }

    /**
     * 触发冷却时间
     */
    public int getTrigger_cd() {
        return trigger_cd;
    }

    /**
     * 触发时弹窗
     */
    public boolean isPopup() {
        return popup;
    }

    /**
     * 礼包版本
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * 即刻推送
     */
    public boolean isPushNow() {
        return pushNow;
    }

    /**
     * 生效服务器
     */
    public long[][] getServers() {
        return servers;
    }

    /**
     * 是否额外显示
     */
    public String getIsExtraDisplay() {
        return isExtraDisplay;
    }

    //#endregion

    //#region 构造函数

    public PurchaseConfig(int id, int type, String clientSystem, int[][] cost, long[][] cond, int name, int showType, String[] showParam, int[] slogan, int[] labelTxt, int order, String productId, int limitType, int limitCount, float defaultPrice, int baseGem, int[][] extraReward, int[][] alliance_gift, int[][] VIPCard, int[][] firstTimeReward, int[][] dailyReward, long[][] displayCond, long[][] displayCompCond, long[][] displayCond_or, int validTime, boolean reset, String[] time, int group, int trigger_cd, boolean popup, String clientVersion, boolean pushNow, long[][] servers, String isExtraDisplay){
        this.id = id;
        this.type = type;
        this.clientSystem = clientSystem;
        this.cost = cost;
        this.cond = cond;
        this.name = name;
        this.showType = showType;
        this.showParam = showParam;
        this.slogan = slogan;
        this.labelTxt = labelTxt;
        this.order = order;
        this.productId = productId;
        this.limitType = limitType;
        this.limitCount = limitCount;
        this.defaultPrice = defaultPrice;
        this.baseGem = baseGem;
        this.extraReward = extraReward;
        this.alliance_gift = alliance_gift;
        this.VIPCard = VIPCard;
        this.firstTimeReward = firstTimeReward;
        this.dailyReward = dailyReward;
        this.displayCond = displayCond;
        this.displayCompCond = displayCompCond;
        this.displayCond_or = displayCond_or;
        this.validTime = validTime;
        this.reset = reset;
        this.time = time;
        this.group = group;
        this.trigger_cd = trigger_cd;
        this.popup = popup;
        this.clientVersion = clientVersion;
        this.pushNow = pushNow;
        this.servers = servers;
        this.isExtraDisplay = isExtraDisplay;
    }

    //#endregion
}
