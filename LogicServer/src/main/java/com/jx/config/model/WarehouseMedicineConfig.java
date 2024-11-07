package com.jx.config.model;

import com.jx.config.loader.WarehouseMedicineConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Warehouse_Medicine.xml
*/
public class WarehouseMedicineConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**等级*/
    private final int lv;
    /**消耗*/
    private final int[][] cost;
    /**耗时[秒]*/
    private final int time;
    /**能加速的时间*/
    private final int timeUp;
    /**道具链接*/
    private final int itemLink;

    /**
     * 获取所有配置
     */
    public static List<WarehouseMedicineConfig> findAll(){
        return WarehouseMedicineConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WarehouseMedicineConfig getByKey(int key){
        return WarehouseMedicineConfigLoader.getByKey(key);
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
     * 能加速的时间
     */
    public int getTimeUp() {
        return timeUp;
    }

    /**
     * 道具链接
     */
    public int getItemLink() {
        return itemLink;
    }

    //#endregion

    //#region 构造函数

    public WarehouseMedicineConfig(int id, int lv, int[][] cost, int time, int timeUp, int itemLink){
        this.id = id;
        this.lv = lv;
        this.cost = cost;
        this.time = time;
        this.timeUp = timeUp;
        this.itemLink = itemLink;
    }

    //#endregion
}
