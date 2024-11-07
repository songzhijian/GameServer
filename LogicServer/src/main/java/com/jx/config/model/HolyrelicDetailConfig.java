package com.jx.config.model;

import com.jx.config.loader.HolyrelicDetailConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Holyrelic_Detail.xml
*/
public class HolyrelicDetailConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**品质*/
    private final int quality;
    /**是否特性养成*/
    private final int special;
    /**唤醒消耗*/
    private final int[][] cost;
    /**等级上限*/
    private final int levelLimit;
    /**赛季等级上限*/
    private final int[][] seasonLimit;

    /**
     * 获取所有配置
     */
    public static List<HolyrelicDetailConfig> findAll(){
        return HolyrelicDetailConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HolyrelicDetailConfig getByKey(int key){
        return HolyrelicDetailConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 品质
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 是否特性养成
     */
    public int getSpecial() {
        return special;
    }

    /**
     * 唤醒消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 等级上限
     */
    public int getLevelLimit() {
        return levelLimit;
    }

    /**
     * 赛季等级上限
     */
    public int[][] getSeasonLimit() {
        return seasonLimit;
    }

    //#endregion

    //#region 构造函数

    public HolyrelicDetailConfig(int id, int quality, int special, int[][] cost, int levelLimit, int[][] seasonLimit){
        this.id = id;
        this.quality = quality;
        this.special = special;
        this.cost = cost;
        this.levelLimit = levelLimit;
        this.seasonLimit = seasonLimit;
    }

    //#endregion
}
