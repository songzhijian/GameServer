package com.jx.config.model;

import com.jx.config.loader.WarehouseIngredientsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Warehouse_Ingredients.xml
*/
public class WarehouseIngredientsConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**等级*/
    private final int lv;
    /**每分钟产出*/
    private final int produce;
    /**道具链接*/
    private final int itemLink;

    /**
     * 获取所有配置
     */
    public static List<WarehouseIngredientsConfig> findAll(){
        return WarehouseIngredientsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WarehouseIngredientsConfig getByKey(int key){
        return WarehouseIngredientsConfigLoader.getByKey(key);
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
     * 每分钟产出
     */
    public int getProduce() {
        return produce;
    }

    /**
     * 道具链接
     */
    public int getItemLink() {
        return itemLink;
    }

    //#endregion

    //#region 构造函数

    public WarehouseIngredientsConfig(int id, int lv, int produce, int itemLink){
        this.id = id;
        this.lv = lv;
        this.produce = produce;
        this.itemLink = itemLink;
    }

    //#endregion
}
