package com.jx.config.model;

import com.jx.config.loader.MoodConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Mood.xml
*/
public class MoodConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**心情值*/
    private final int[] moodValue;
    /**效果*/
    private final int[][] eff;

    /**
     * 获取所有配置
     */
    public static List<MoodConfig> findAll(){
        return MoodConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MoodConfig getByKey(int key){
        return MoodConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 心情值
     */
    public int[] getMoodValue() {
        return moodValue;
    }

    /**
     * 效果
     */
    public int[][] getEff() {
        return eff;
    }

    //#endregion

    //#region 构造函数

    public MoodConfig(int id, int[] moodValue, int[][] eff){
        this.id = id;
        this.moodValue = moodValue;
        this.eff = eff;
    }

    //#endregion
}
