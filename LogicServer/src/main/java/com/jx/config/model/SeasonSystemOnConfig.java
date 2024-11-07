package com.jx.config.model;

import com.jx.config.loader.SeasonSystemOnConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Season_System_On.xml
*/
public class SeasonSystemOnConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**初始等级*/
    private final int[] startLevel;

    /**
     * 获取所有配置
     */
    public static List<SeasonSystemOnConfig> findAll(){
        return SeasonSystemOnConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SeasonSystemOnConfig getByKey(int key){
        return SeasonSystemOnConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 初始等级
     */
    public int[] getStartLevel() {
        return startLevel;
    }

    //#endregion

    //#region 构造函数

    public SeasonSystemOnConfig(int id, int[] startLevel){
        this.id = id;
        this.startLevel = startLevel;
    }

    //#endregion
}
