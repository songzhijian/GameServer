package com.jx.config.model;

import com.jx.config.loader.BattlePassConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Battle_Pass.xml
*/
public class BattlePassConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**创建时间方式*/
    private final int createTimeType;
    /**分数转换方式*/
    private final int[] scoreToLevelType;
    /**阶段任务*/
    private final int[][] stageTasks;
    /**礼包和功能*/
    private final int[][] giftIdAndFunc;
    /**分阶段方式*/
    private final int stageType;
    /**分阶段参数*/
    private final int[] stageTypeParam;
    /**全局任务*/
    private final int[] tasks;
    /**结算邮件*/
    private final int mailId;
    /**超出上限后，循环等级*/
    private final int loopLevel;
    /**一次购买的等级上线*/
    private final int oneBuyLevelMax;
    /**购买一级的消耗*/
    private final int[][] cost;
    /**可以购买总等级数量*/
    private final int buyLevelTotle;
    /**businessType*/
    private final int businessType;

    /**
     * 获取所有配置
     */
    public static List<BattlePassConfig> findAll(){
        return BattlePassConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BattlePassConfig getByKey(int key){
        return BattlePassConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 创建时间方式
     */
    public int getCreateTimeType() {
        return createTimeType;
    }

    /**
     * 分数转换方式
     */
    public int[] getScoreToLevelType() {
        return scoreToLevelType;
    }

    /**
     * 阶段任务
     */
    public int[][] getStageTasks() {
        return stageTasks;
    }

    /**
     * 礼包和功能
     */
    public int[][] getGiftIdAndFunc() {
        return giftIdAndFunc;
    }

    /**
     * 分阶段方式
     */
    public int getStageType() {
        return stageType;
    }

    /**
     * 分阶段参数
     */
    public int[] getStageTypeParam() {
        return stageTypeParam;
    }

    /**
     * 全局任务
     */
    public int[] getTasks() {
        return tasks;
    }

    /**
     * 结算邮件
     */
    public int getMailId() {
        return mailId;
    }

    /**
     * 超出上限后，循环等级
     */
    public int getLoopLevel() {
        return loopLevel;
    }

    /**
     * 一次购买的等级上线
     */
    public int getOneBuyLevelMax() {
        return oneBuyLevelMax;
    }

    /**
     * 购买一级的消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 可以购买总等级数量
     */
    public int getBuyLevelTotle() {
        return buyLevelTotle;
    }

    public int getBusinessType() {
        return businessType;
    }

    //#endregion

    //#region 构造函数

    public BattlePassConfig(int id, int createTimeType, int[] scoreToLevelType, int[][] stageTasks, int[][] giftIdAndFunc, int stageType, int[] stageTypeParam, int[] tasks, int mailId, int loopLevel, int oneBuyLevelMax, int[][] cost, int buyLevelTotle, int businessType){
        this.id = id;
        this.createTimeType = createTimeType;
        this.scoreToLevelType = scoreToLevelType;
        this.stageTasks = stageTasks;
        this.giftIdAndFunc = giftIdAndFunc;
        this.stageType = stageType;
        this.stageTypeParam = stageTypeParam;
        this.tasks = tasks;
        this.mailId = mailId;
        this.loopLevel = loopLevel;
        this.oneBuyLevelMax = oneBuyLevelMax;
        this.cost = cost;
        this.buyLevelTotle = buyLevelTotle;
        this.businessType = businessType;
    }

    //#endregion
}
