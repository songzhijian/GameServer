package com.jx.config.model;

import com.jx.config.loader.EquipDetailConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Equip_Detail.xml
*/
public class EquipDetailConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**阶段*/
    private final int quality;
    /**品阶*/
    private final int tier;
    /**属性类型*/
    private final int type;
    /**位置*/
    private final int position;
    /**图标*/
    private final String icon;
    /**att*/
    private final double[][] att;
    /**强化价值*/
    private final int upExp;
    /**强化上限*/
    private final int upLimit;
    /**标签概率【万分比概率】*/
    private final int raceRate;
    /**合成需要*/
    private final int[][] need;
    /**合成转化标的*/
    private final int target;
    /**能否被强化消耗*/
    private final int canCost;

    /**
     * 获取所有配置
     */
    public static List<EquipDetailConfig> findAll(){
        return EquipDetailConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static EquipDetailConfig getByKey(int key){
        return EquipDetailConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 阶段
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 品阶
     */
    public int getTier() {
        return tier;
    }

    /**
     * 属性类型
     */
    public int getType() {
        return type;
    }

    /**
     * 位置
     */
    public int getPosition() {
        return position;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * att
     */
    public double[][] getAtt() {
        return att;
    }

    /**
     * 强化价值
     */
    public int getUpExp() {
        return upExp;
    }

    /**
     * 强化上限
     */
    public int getUpLimit() {
        return upLimit;
    }

    /**
     * 标签概率【万分比概率】
     */
    public int getRaceRate() {
        return raceRate;
    }

    /**
     * 合成需要
     */
    public int[][] getNeed() {
        return need;
    }

    /**
     * 合成转化标的
     */
    public int getTarget() {
        return target;
    }

    /**
     * 能否被强化消耗
     */
    public int getCanCost() {
        return canCost;
    }

    //#endregion

    //#region 构造函数

    public EquipDetailConfig(int id, int quality, int tier, int type, int position, String icon, double[][] att, int upExp, int upLimit, int raceRate, int[][] need, int target, int canCost){
        this.id = id;
        this.quality = quality;
        this.tier = tier;
        this.type = type;
        this.position = position;
        this.icon = icon;
        this.att = att;
        this.upExp = upExp;
        this.upLimit = upLimit;
        this.raceRate = raceRate;
        this.need = need;
        this.target = target;
        this.canCost = canCost;
    }

    //#endregion
}
