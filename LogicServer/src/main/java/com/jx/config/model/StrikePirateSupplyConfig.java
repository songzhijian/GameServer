package com.jx.config.model;

import com.jx.config.loader.StrikePirateSupplyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Strike_Pirate_Supply.xml
*/
public class StrikePirateSupplyConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**挂机收益时长*/
    private final int time;
    /**挂机消耗*/
    private final int[][] consume;
    /**是否免费*/
    private final boolean isFree;

    /**
     * 获取所有配置
     */
    public static List<StrikePirateSupplyConfig> findAll(){
        return StrikePirateSupplyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StrikePirateSupplyConfig getByKey(int key){
        return StrikePirateSupplyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 挂机收益时长
     */
    public int getTime() {
        return time;
    }

    /**
     * 挂机消耗
     */
    public int[][] getConsume() {
        return consume;
    }

    /**
     * 是否免费
     */
    public boolean isIsFree() {
        return isFree;
    }

    //#endregion

    //#region 构造函数

    public StrikePirateSupplyConfig(int id, int time, int[][] consume, boolean isFree){
        this.id = id;
        this.time = time;
        this.consume = consume;
        this.isFree = isFree;
    }

    //#endregion
}
