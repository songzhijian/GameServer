package com.jx.config.model;

import com.jx.config.loader.HolyrelicLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Holyrelic_Level.xml
*/
public class HolyrelicLevelConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**归属圣物*/
    private final int holyrelic;
    /**等级*/
    private final int level;
    /**升级消耗*/
    private final int[][] cost;
    /**战力评分*/
    private final int power;
    /**基础属性加成*/
    private final int[][] attr1;
    /**2阶属性*/
    private final int[][] attr2;
    /**3阶属性*/
    private final int[][] attr3;
    /**4阶属性*/
    private final int[][] attr4;

    /**
     * 获取所有配置
     */
    public static List<HolyrelicLevelConfig> findAll(){
        return HolyrelicLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HolyrelicLevelConfig getByKey(int key){
        return HolyrelicLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 归属圣物
     */
    public int getHolyrelic() {
        return holyrelic;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 升级消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 战力评分
     */
    public int getPower() {
        return power;
    }

    /**
     * 基础属性加成
     */
    public int[][] getAttr1() {
        return attr1;
    }

    /**
     * 2阶属性
     */
    public int[][] getAttr2() {
        return attr2;
    }

    /**
     * 3阶属性
     */
    public int[][] getAttr3() {
        return attr3;
    }

    /**
     * 4阶属性
     */
    public int[][] getAttr4() {
        return attr4;
    }

    //#endregion

    //#region 构造函数

    public HolyrelicLevelConfig(int id, int holyrelic, int level, int[][] cost, int power, int[][] attr1, int[][] attr2, int[][] attr3, int[][] attr4){
        this.id = id;
        this.holyrelic = holyrelic;
        this.level = level;
        this.cost = cost;
        this.power = power;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
        this.attr4 = attr4;
    }

    //#endregion
}
