package com.jx.config.model;

import com.jx.config.loader.SeasonConfigConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Season_Config.xml
*/
public class SeasonConfigConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**英雄等级上限*/
    private final int heroLvLimit;

    /**
     * 获取所有配置
     */
    public static List<SeasonConfigConfig> findAll(){
        return SeasonConfigConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SeasonConfigConfig getByKey(int key){
        return SeasonConfigConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 英雄等级上限
     */
    public int getHeroLvLimit() {
        return heroLvLimit;
    }

    //#endregion

    //#region 构造函数

    public SeasonConfigConfig(int id, int heroLvLimit){
        this.id = id;
        this.heroLvLimit = heroLvLimit;
    }

    //#endregion
}
