package com.jx.config.model;

import com.jx.config.loader.HeroExclusiveConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Exclusive.xml
*/
public class HeroExclusiveConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**归属英雄*/
    private final int hero;
    /**等级*/
    private final int level;
    /**消耗*/
    private final int[][] cost;
    /**att*/
    private final double[][] att;

    /**
     * 获取所有配置
     */
    public static List<HeroExclusiveConfig> findAll(){
        return HeroExclusiveConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroExclusiveConfig getByKey(int key){
        return HeroExclusiveConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 归属英雄
     */
    public int getHero() {
        return hero;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * att
     */
    public double[][] getAtt() {
        return att;
    }

    //#endregion

    //#region 构造函数

    public HeroExclusiveConfig(int id, int hero, int level, int[][] cost, double[][] att){
        this.id = id;
        this.hero = hero;
        this.level = level;
        this.cost = cost;
        this.att = att;
    }

    //#endregion
}
