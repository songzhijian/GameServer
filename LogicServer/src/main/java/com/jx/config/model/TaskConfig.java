package com.jx.config.model;

import com.jx.config.loader.TaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Task.xml
*/
public class TaskConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**任务类型*/
    private final int type;
    /**类型参数*/
    private final int[] param;
    /**任务环境生成*/
    private final int situation;
    /**显示条件*/
    private final long[][] showCondition;
    /**接任务条件*/
    private final long[][] unlockCondition;
    /**添加时候是否要检查*/
    private final boolean check;
    /**完成条件*/
    private final long[][] completeCondition;
    /**任务奖励*/
    private final int[][] rewards;
    /**在战斗结算界面显示*/
    private final int isShowInResult;
    /**完成后接取的任务id*/
    private final int[] nextTaskIds;

    /**
     * 获取所有配置
     */
    public static List<TaskConfig> findAll(){
        return TaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TaskConfig getByKey(int key){
        return TaskConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 任务类型
     */
    public int getType() {
        return type;
    }

    /**
     * 类型参数
     */
    public int[] getParam() {
        return param;
    }

    /**
     * 任务环境生成
     */
    public int getSituation() {
        return situation;
    }

    /**
     * 显示条件
     */
    public long[][] getShowCondition() {
        return showCondition;
    }

    /**
     * 接任务条件
     */
    public long[][] getUnlockCondition() {
        return unlockCondition;
    }

    /**
     * 添加时候是否要检查
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * 完成条件
     */
    public long[][] getCompleteCondition() {
        return completeCondition;
    }

    /**
     * 任务奖励
     */
    public int[][] getRewards() {
        return rewards;
    }

    /**
     * 在战斗结算界面显示
     */
    public int getIsShowInResult() {
        return isShowInResult;
    }

    /**
     * 完成后接取的任务id
     */
    public int[] getNextTaskIds() {
        return nextTaskIds;
    }

    //#endregion

    //#region 构造函数

    public TaskConfig(int id, int type, int[] param, int situation, long[][] showCondition, long[][] unlockCondition, boolean check, long[][] completeCondition, int[][] rewards, int isShowInResult, int[] nextTaskIds){
        this.id = id;
        this.type = type;
        this.param = param;
        this.situation = situation;
        this.showCondition = showCondition;
        this.unlockCondition = unlockCondition;
        this.check = check;
        this.completeCondition = completeCondition;
        this.rewards = rewards;
        this.isShowInResult = isShowInResult;
        this.nextTaskIds = nextTaskIds;
    }

    //#endregion
}
