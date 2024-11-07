package com.jx.config.model;

import com.jx.config.loader.AdventureExpAccelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Adventure_Exp_Accel.xml
*/
public class AdventureExpAccelConfig extends AbstractConfig implements IConfig {

    /**id(赛季ID)*/
    private final int id;
    /**赛季开启天数*/
    private final int[][] day;
    /**推荐等级*/
    private final int[] level;
    /**加成作用号*/
    private final int[] buff;
    /**赛季等级上限*/
    private final int seasonLimit;

    /**
     * 获取所有配置
     */
    public static List<AdventureExpAccelConfig> findAll(){
        return AdventureExpAccelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AdventureExpAccelConfig getByKey(int key){
        return AdventureExpAccelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id(赛季ID)
     */
    public int getId() {
        return id;
    }

    /**
     * 赛季开启天数
     */
    public int[][] getDay() {
        return day;
    }

    /**
     * 推荐等级
     */
    public int[] getLevel() {
        return level;
    }

    /**
     * 加成作用号
     */
    public int[] getBuff() {
        return buff;
    }

    /**
     * 赛季等级上限
     */
    public int getSeasonLimit() {
        return seasonLimit;
    }

    //#endregion

    //#region 构造函数

    public AdventureExpAccelConfig(int id, int[][] day, int[] level, int[] buff, int seasonLimit){
        this.id = id;
        this.day = day;
        this.level = level;
        this.buff = buff;
        this.seasonLimit = seasonLimit;
    }

    //#endregion
}
