package com.jx.config.model;

import com.jx.config.loader.AdventureLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Adventure_Level.xml
*/
public class AdventureLevelConfig extends AbstractConfig implements IConfig {

    /**id（代表等级）*/
    private final int id;
    /**升到下一级经验*/
    private final int nextExp;
    /**英雄等级限制*/
    private final int heroLevelLimit;

    /**
     * 获取所有配置
     */
    public static List<AdventureLevelConfig> findAll(){
        return AdventureLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AdventureLevelConfig getByKey(int key){
        return AdventureLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id（代表等级）
     */
    public int getId() {
        return id;
    }

    /**
     * 升到下一级经验
     */
    public int getNextExp() {
        return nextExp;
    }

    /**
     * 英雄等级限制
     */
    public int getHeroLevelLimit() {
        return heroLevelLimit;
    }

    //#endregion

    //#region 构造函数

    public AdventureLevelConfig(int id, int nextExp, int heroLevelLimit){
        this.id = id;
        this.nextExp = nextExp;
        this.heroLevelLimit = heroLevelLimit;
    }

    //#endregion
}
