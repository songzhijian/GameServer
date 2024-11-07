package com.jx.config.model;

import com.jx.config.loader.WarehouseFoodsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Warehouse_Foods.xml
*/
public class WarehouseFoodsConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**等级*/
    private final int lv;
    /**消耗*/
    private final int[][] cost;
    /**耗时[秒]*/
    private final int time;
    /**饱食度*/
    private final int satiety;
    /**道具链接*/
    private final int itemLink;

    /**
     * 获取所有配置
     */
    public static List<WarehouseFoodsConfig> findAll(){
        return WarehouseFoodsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WarehouseFoodsConfig getByKey(int key){
        return WarehouseFoodsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 等级
     */
    public int getLv() {
        return lv;
    }

    /**
     * 消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 耗时[秒]
     */
    public int getTime() {
        return time;
    }

    /**
     * 饱食度
     */
    public int getSatiety() {
        return satiety;
    }

    /**
     * 道具链接
     */
    public int getItemLink() {
        return itemLink;
    }

    //#endregion

    //#region 构造函数

    public WarehouseFoodsConfig(int id, int lv, int[][] cost, int time, int satiety, int itemLink){
        this.id = id;
        this.lv = lv;
        this.cost = cost;
        this.time = time;
        this.satiety = satiety;
        this.itemLink = itemLink;
    }

    //#endregion
}
