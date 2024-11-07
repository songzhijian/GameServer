package com.jx.config.model;

import com.jx.config.loader.NavyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Navy.xml
*/
public class NavyConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**等级*/
    private final int lv;
    /**属性倍率*/
    private final float attRate;
    /**负重值*/
    private final int load;
    /**破坏值*/
    private final float destroy;
    /**消耗*/
    private final int[][] cost;
    /**耗时[秒]*/
    private final int time;
    /**治疗消耗*/
    private final int[][] healCost;
    /**治疗耗时[秒]*/
    private final int healTime;
    /**战斗力*/
    private final int power;
    /**排行榜积分*/
    private final int rankPoint;

    /**
     * 获取所有配置
     */
    public static List<NavyConfig> findAll(){
        return NavyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static NavyConfig getByKey(int key){
        return NavyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 等级
     */
    public int getLv() {
        return lv;
    }

    /**
     * 属性倍率
     */
    public float getAttRate() {
        return attRate;
    }

    /**
     * 负重值
     */
    public int getLoad() {
        return load;
    }

    /**
     * 破坏值
     */
    public float getDestroy() {
        return destroy;
    }

    /**
     * 消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 耗时[秒]
     */
    public int getTime() {
        return time;
    }

    /**
     * 治疗消耗
     */
    public int[][] getHealCost() {
        return healCost;
    }

    /**
     * 治疗耗时[秒]
     */
    public int getHealTime() {
        return healTime;
    }

    /**
     * 战斗力
     */
    public int getPower() {
        return power;
    }

    /**
     * 排行榜积分
     */
    public int getRankPoint() {
        return rankPoint;
    }

    //#endregion

    //#region 构造函数

    public NavyConfig(int id, int lv, float attRate, int load, float destroy, int[][] cost, int time, int[][] healCost, int healTime, int power, int rankPoint){
        this.id = id;
        this.lv = lv;
        this.attRate = attRate;
        this.load = load;
        this.destroy = destroy;
        this.cost = cost;
        this.time = time;
        this.healCost = healCost;
        this.healTime = healTime;
        this.power = power;
        this.rankPoint = rankPoint;
    }

    //#endregion
}
