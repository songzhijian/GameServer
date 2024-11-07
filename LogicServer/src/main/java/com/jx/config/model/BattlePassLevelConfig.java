package com.jx.config.model;

import com.jx.config.loader.BattlePassLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Battle_Pass_Level.xml
*/
public class BattlePassLevelConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**键值*/
    private final int battlePassId;
    /**键值*/
    private final int battlePassLevel;
    /**普通奖励*/
    private final int[][] reward;
    /**付费奖励1*/
    private final int[][] pay_reward1;
    /**付费奖励2*/
    private final int[][] pay_reward2;

    /**
     * 获取所有配置
     */
    public static List<BattlePassLevelConfig> findAll(){
        return BattlePassLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BattlePassLevelConfig getByKey(int key){
        return BattlePassLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 键值
     */
    public int getBattlePassId() {
        return battlePassId;
    }

    /**
     * 键值
     */
    public int getBattlePassLevel() {
        return battlePassLevel;
    }

    /**
     * 普通奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 付费奖励1
     */
    public int[][] getPay_reward1() {
        return pay_reward1;
    }

    /**
     * 付费奖励2
     */
    public int[][] getPay_reward2() {
        return pay_reward2;
    }

    //#endregion

    //#region 构造函数

    public BattlePassLevelConfig(int id, int battlePassId, int battlePassLevel, int[][] reward, int[][] pay_reward1, int[][] pay_reward2){
        this.id = id;
        this.battlePassId = battlePassId;
        this.battlePassLevel = battlePassLevel;
        this.reward = reward;
        this.pay_reward1 = pay_reward1;
        this.pay_reward2 = pay_reward2;
    }

    //#endregion
}
