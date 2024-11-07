package com.jx.config.model;

import com.jx.config.loader.AlliancePortForceRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Port_Force_Reward.xml
*/
public class AlliancePortForceRewardConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**势力值进度*/
    private final int portForce;
    /**每日奖励*/
    private final int[][] dailyReward;

    /**
     * 获取所有配置
     */
    public static List<AlliancePortForceRewardConfig> findAll(){
        return AlliancePortForceRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AlliancePortForceRewardConfig getByKey(int key){
        return AlliancePortForceRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 势力值进度
     */
    public int getPortForce() {
        return portForce;
    }

    /**
     * 每日奖励
     */
    public int[][] getDailyReward() {
        return dailyReward;
    }

    //#endregion

    //#region 构造函数

    public AlliancePortForceRewardConfig(int id, int portForce, int[][] dailyReward){
        this.id = id;
        this.portForce = portForce;
        this.dailyReward = dailyReward;
    }

    //#endregion
}
