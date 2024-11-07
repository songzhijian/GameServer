package com.jx.config.model;

import com.jx.config.loader.WordlessBookConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Wordless_Book.xml
*/
public class WordlessBookConfig extends AbstractConfig implements IConfig {

    /**等级*/
    private final int id;
    /**需要能量*/
    private final int[][] cost;
    /**属性成长*/
    private final double[][] att;
    /**等级上限*/
    private final int lvLimit;

    /**
     * 获取所有配置
     */
    public static List<WordlessBookConfig> findAll(){
        return WordlessBookConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WordlessBookConfig getByKey(int key){
        return WordlessBookConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 等级
     */
    public int getId() {
        return id;
    }

    /**
     * 需要能量
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 属性成长
     */
    public double[][] getAtt() {
        return att;
    }

    /**
     * 等级上限
     */
    public int getLvLimit() {
        return lvLimit;
    }

    //#endregion

    //#region 构造函数

    public WordlessBookConfig(int id, int[][] cost, double[][] att, int lvLimit){
        this.id = id;
        this.cost = cost;
        this.att = att;
        this.lvLimit = lvLimit;
    }

    //#endregion
}
