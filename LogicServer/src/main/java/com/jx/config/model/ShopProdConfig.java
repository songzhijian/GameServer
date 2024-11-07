package com.jx.config.model;

import com.jx.config.loader.ShopProdConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Shop_Prod.xml
*/
public class ShopProdConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**货物*/
    private final int[][] prod;
    /**购买次数*/
    private final int buyCnt;
    /**价格*/
    private final int[][] price;

    /**
     * 获取所有配置
     */
    public static List<ShopProdConfig> findAll(){
        return ShopProdConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShopProdConfig getByKey(int key){
        return ShopProdConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 货物
     */
    public int[][] getProd() {
        return prod;
    }

    /**
     * 购买次数
     */
    public int getBuyCnt() {
        return buyCnt;
    }

    /**
     * 价格
     */
    public int[][] getPrice() {
        return price;
    }

    //#endregion

    //#region 构造函数

    public ShopProdConfig(int id, int[][] prod, int buyCnt, int[][] price){
        this.id = id;
        this.prod = prod;
        this.buyCnt = buyCnt;
        this.price = price;
    }

    //#endregion
}
