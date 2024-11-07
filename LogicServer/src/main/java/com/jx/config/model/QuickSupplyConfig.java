package com.jx.config.model;

import com.jx.config.loader.QuickSupplyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Quick_Supply.xml
*/
public class QuickSupplyConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**补充道具*/
    private final int[] supplyItemList;
    /**补充价格*/
    private final int[][] supplyPrice;
    /**直购价格*/
    private final int diamondPrince;

    /**
     * 获取所有配置
     */
    public static List<QuickSupplyConfig> findAll(){
        return QuickSupplyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static QuickSupplyConfig getByKey(int key){
        return QuickSupplyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 补充道具
     */
    public int[] getSupplyItemList() {
        return supplyItemList;
    }

    /**
     * 补充价格
     */
    public int[][] getSupplyPrice() {
        return supplyPrice;
    }

    /**
     * 直购价格
     */
    public int getDiamondPrince() {
        return diamondPrince;
    }

    //#endregion

    //#region 构造函数

    public QuickSupplyConfig(int id, int[] supplyItemList, int[][] supplyPrice, int diamondPrince){
        this.id = id;
        this.supplyItemList = supplyItemList;
        this.supplyPrice = supplyPrice;
        this.diamondPrince = diamondPrince;
    }

    //#endregion
}
