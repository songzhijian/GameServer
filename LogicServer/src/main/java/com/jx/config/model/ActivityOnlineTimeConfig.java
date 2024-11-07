package com.jx.config.model;

import com.jx.config.loader.ActivityOnlineTimeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Activity_Online_Time.xml
*/
public class ActivityOnlineTimeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**累计时间（秒）*/
    private final int onlineValue;
    /**奖励*/
    private final int[][] reward;
    /**奖励升级条件*/
    private final long[][] upgradeCondition;
    /**下一级id*/
    private final int nextId;

    /**
     * 获取所有配置
     */
    public static List<ActivityOnlineTimeConfig> findAll(){
        return ActivityOnlineTimeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ActivityOnlineTimeConfig getByKey(int key){
        return ActivityOnlineTimeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 累计时间（秒）
     */
    public int getOnlineValue() {
        return onlineValue;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 奖励升级条件
     */
    public long[][] getUpgradeCondition() {
        return upgradeCondition;
    }

    /**
     * 下一级id
     */
    public int getNextId() {
        return nextId;
    }

    //#endregion

    //#region 构造函数

    public ActivityOnlineTimeConfig(int id, int onlineValue, int[][] reward, long[][] upgradeCondition, int nextId){
        this.id = id;
        this.onlineValue = onlineValue;
        this.reward = reward;
        this.upgradeCondition = upgradeCondition;
        this.nextId = nextId;
    }

    //#endregion
}
