package com.jx.config.model;

import com.jx.config.loader.WarehouseWaterConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Warehouse_Water.xml
*/
public class WarehouseWaterConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**饱食度*/
    private final int satiety;
    /**等级*/
    private final int lv;
    /**道具链接*/
    private final int itemLink;

    /**
     * 获取所有配置
     */
    public static List<WarehouseWaterConfig> findAll(){
        return WarehouseWaterConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WarehouseWaterConfig getByKey(int key){
        return WarehouseWaterConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 饱食度
     */
    public int getSatiety() {
        return satiety;
    }

    /**
     * 等级
     */
    public int getLv() {
        return lv;
    }

    /**
     * 道具链接
     */
    public int getItemLink() {
        return itemLink;
    }

    //#endregion

    //#region 构造函数

    public WarehouseWaterConfig(int id, int satiety, int lv, int itemLink){
        this.id = id;
        this.satiety = satiety;
        this.lv = lv;
        this.itemLink = itemLink;
    }

    //#endregion
}
