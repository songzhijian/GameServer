package com.jx.config.model;

import com.jx.config.loader.EscortGoodsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 EscortGoods.xml
*/
public class EscortGoodsConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**母船的等级范围*/
    private final int[] boatLevel;
    /**运输货物*/
    private final int[] goods;
    /**消耗*/
    private final int[][] cost;
    /**押镖奖励*/
    private final int[][][] reward;
    /**劫镖奖励*/
    private final int[][] robberyReward;

    /**
     * 获取所有配置
     */
    public static List<EscortGoodsConfig> findAll(){
        return EscortGoodsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static EscortGoodsConfig getByKey(int key){
        return EscortGoodsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 母船的等级范围
     */
    public int[] getBoatLevel() {
        return boatLevel;
    }

    /**
     * 运输货物
     */
    public int[] getGoods() {
        return goods;
    }

    /**
     * 消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 押镖奖励
     */
    public int[][][] getReward() {
        return reward;
    }

    /**
     * 劫镖奖励
     */
    public int[][] getRobberyReward() {
        return robberyReward;
    }

    //#endregion

    //#region 构造函数

    public EscortGoodsConfig(int id, int[] boatLevel, int[] goods, int[][] cost, int[][][] reward, int[][] robberyReward){
        this.id = id;
        this.boatLevel = boatLevel;
        this.goods = goods;
        this.cost = cost;
        this.reward = reward;
        this.robberyReward = robberyReward;
    }

    //#endregion
}
