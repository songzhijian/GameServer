package com.jx.config.model;

import com.jx.config.loader.GachaConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Gacha.xml
*/
public class GachaConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**需要消费*/
    private final int[][] cost;
    /**5连消费*/
    private final int[][] cost5;
    /**对应pool*/
    private final int pool;
    /**卡池名称*/
    private final int poolName;
    /**计数类型*/
    private final int businessType;

    /**
     * 获取所有配置
     */
    public static List<GachaConfig> findAll(){
        return GachaConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GachaConfig getByKey(int key){
        return GachaConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 需要消费
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 5连消费
     */
    public int[][] getCost5() {
        return cost5;
    }

    /**
     * 对应pool
     */
    public int getPool() {
        return pool;
    }

    /**
     * 卡池名称
     */
    public int getPoolName() {
        return poolName;
    }

    /**
     * 计数类型
     */
    public int getBusinessType() {
        return businessType;
    }

    //#endregion

    //#region 构造函数

    public GachaConfig(int id, int[][] cost, int[][] cost5, int pool, int poolName, int businessType){
        this.id = id;
        this.cost = cost;
        this.cost5 = cost5;
        this.pool = pool;
        this.poolName = poolName;
        this.businessType = businessType;
    }

    //#endregion
}
