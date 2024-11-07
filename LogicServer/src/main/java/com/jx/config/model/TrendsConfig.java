package com.jx.config.model;

import com.jx.config.loader.TrendsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trends.xml
*/
public class TrendsConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**所属赛季*/
    private final int season;
    /**下一阶段ID*/
    private final int nextId;
    /**任务ID*/
    private final int[] taskId;
    /**阶段开启条件*/
    private final int[] openCondition;
    /**阶段时长*/
    private final int durationTime;
    /**阶段结束方式*/
    private final int FinishCondition;
    /**阶段名称*/
    private final int name;
    /**完成奖励*/
    private final int[][] reward;
    /**奖励类型*/
    private final int rewardType;
    /**领奖时间*/
    private final int rewardGetTime;
    /**完成解锁功能*/
    private final int[] functionUnlock;

    /**
     * 获取所有配置
     */
    public static List<TrendsConfig> findAll(){
        return TrendsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TrendsConfig getByKey(int key){
        return TrendsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 所属赛季
     */
    public int getSeason() {
        return season;
    }

    /**
     * 下一阶段ID
     */
    public int getNextId() {
        return nextId;
    }

    /**
     * 任务ID
     */
    public int[] getTaskId() {
        return taskId;
    }

    /**
     * 阶段开启条件
     */
    public int[] getOpenCondition() {
        return openCondition;
    }

    /**
     * 阶段时长
     */
    public int getDurationTime() {
        return durationTime;
    }

    /**
     * 阶段结束方式
     */
    public int getFinishCondition() {
        return FinishCondition;
    }

    /**
     * 阶段名称
     */
    public int getName() {
        return name;
    }

    /**
     * 完成奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 奖励类型
     */
    public int getRewardType() {
        return rewardType;
    }

    /**
     * 领奖时间
     */
    public int getRewardGetTime() {
        return rewardGetTime;
    }

    /**
     * 完成解锁功能
     */
    public int[] getFunctionUnlock() {
        return functionUnlock;
    }

    //#endregion

    //#region 构造函数

    public TrendsConfig(int id, int season, int nextId, int[] taskId, int[] openCondition, int durationTime, int FinishCondition, int name, int[][] reward, int rewardType, int rewardGetTime, int[] functionUnlock){
        this.id = id;
        this.season = season;
        this.nextId = nextId;
        this.taskId = taskId;
        this.openCondition = openCondition;
        this.durationTime = durationTime;
        this.FinishCondition = FinishCondition;
        this.name = name;
        this.reward = reward;
        this.rewardType = rewardType;
        this.rewardGetTime = rewardGetTime;
        this.functionUnlock = functionUnlock;
    }

    //#endregion
}
