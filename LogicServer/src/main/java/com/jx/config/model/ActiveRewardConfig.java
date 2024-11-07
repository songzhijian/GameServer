package com.jx.config.model;

import com.jx.config.loader.ActiveRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 ActiveReward.xml
*/
public class ActiveRewardConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**类型*/
    private final int type;
    /**类型参数*/
    private final int param;
    /**解锁类型*/
    private final long[] conditionType;
    /**活跃度*/
    private final int activityValue;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<ActiveRewardConfig> findAll(){
        return ActiveRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ActiveRewardConfig getByKey(int key){
        return ActiveRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 类型参数
     */
    public int getParam() {
        return param;
    }

    /**
     * 解锁类型
     */
    public long[] getConditionType() {
        return conditionType;
    }

    /**
     * 活跃度
     */
    public int getActivityValue() {
        return activityValue;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public ActiveRewardConfig(int id, int type, int param, long[] conditionType, int activityValue, int[][] reward){
        this.id = id;
        this.type = type;
        this.param = param;
        this.conditionType = conditionType;
        this.activityValue = activityValue;
        this.reward = reward;
    }

    //#endregion
}
