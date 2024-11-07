package com.jx.config.model;

import com.jx.config.loader.TechInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tech_Info.xml
*/
public class TechInfoConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**等级*/
    private final int lvl;
    /**归属节点*/
    private final int node;
    /**资源消耗*/
    private final int[][] baseCost;
    /**基础消耗时长*/
    private final int baseTime;
    /**直购价格*/
    private final int[] hammerPrice;
    /**直购价格基底*/
    private final int[] reservePrice;
    /**需求实验室等级*/
    private final int labLvl;
    /**需求科技*/
    private final int[] techLvl;
    /**效果类型*/
    private final int[][] effect;
    /**战斗力*/
    private final int power;

    /**
     * 获取所有配置
     */
    public static List<TechInfoConfig> findAll(){
        return TechInfoConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TechInfoConfig getByKey(int key){
        return TechInfoConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 等级
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * 归属节点
     */
    public int getNode() {
        return node;
    }

    /**
     * 资源消耗
     */
    public int[][] getBaseCost() {
        return baseCost;
    }

    /**
     * 基础消耗时长
     */
    public int getBaseTime() {
        return baseTime;
    }

    /**
     * 直购价格
     */
    public int[] getHammerPrice() {
        return hammerPrice;
    }

    /**
     * 直购价格基底
     */
    public int[] getReservePrice() {
        return reservePrice;
    }

    /**
     * 需求实验室等级
     */
    public int getLabLvl() {
        return labLvl;
    }

    /**
     * 需求科技
     */
    public int[] getTechLvl() {
        return techLvl;
    }

    /**
     * 效果类型
     */
    public int[][] getEffect() {
        return effect;
    }

    /**
     * 战斗力
     */
    public int getPower() {
        return power;
    }

    //#endregion

    //#region 构造函数

    public TechInfoConfig(int id, int lvl, int node, int[][] baseCost, int baseTime, int[] hammerPrice, int[] reservePrice, int labLvl, int[] techLvl, int[][] effect, int power){
        this.id = id;
        this.lvl = lvl;
        this.node = node;
        this.baseCost = baseCost;
        this.baseTime = baseTime;
        this.hammerPrice = hammerPrice;
        this.reservePrice = reservePrice;
        this.labLvl = labLvl;
        this.techLvl = techLvl;
        this.effect = effect;
        this.power = power;
    }

    //#endregion
}
