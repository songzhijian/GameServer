package com.jx.config.model;

import com.jx.config.loader.TradeGoodsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Goods.xml
*/
public class TradeGoodsConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**大品类*/
    private final int type;
    /**细分品类*/
    private final int subcategory;
    /**冒险等级控制商品解锁*/
    private final long[][] gradingAdventureLv;
    /**信用等级控制商品解锁*/
    private final long[][] gradingCredibilityLv;
    /**换水的数量*/
    private final int waterCount;
    /**目标水id*/
    private final int waterId;
    /**道具链接*/
    private final int itemLink;

    /**
     * 获取所有配置
     */
    public static List<TradeGoodsConfig> findAll(){
        return TradeGoodsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradeGoodsConfig getByKey(int key){
        return TradeGoodsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 大品类
     */
    public int getType() {
        return type;
    }

    /**
     * 细分品类
     */
    public int getSubcategory() {
        return subcategory;
    }

    /**
     * 冒险等级控制商品解锁
     */
    public long[][] getGradingAdventureLv() {
        return gradingAdventureLv;
    }

    /**
     * 信用等级控制商品解锁
     */
    public long[][] getGradingCredibilityLv() {
        return gradingCredibilityLv;
    }

    /**
     * 换水的数量
     */
    public int getWaterCount() {
        return waterCount;
    }

    /**
     * 目标水id
     */
    public int getWaterId() {
        return waterId;
    }

    /**
     * 道具链接
     */
    public int getItemLink() {
        return itemLink;
    }

    //#endregion

    //#region 构造函数

    public TradeGoodsConfig(int id, int type, int subcategory, long[][] gradingAdventureLv, long[][] gradingCredibilityLv, int waterCount, int waterId, int itemLink){
        this.id = id;
        this.type = type;
        this.subcategory = subcategory;
        this.gradingAdventureLv = gradingAdventureLv;
        this.gradingCredibilityLv = gradingCredibilityLv;
        this.waterCount = waterCount;
        this.waterId = waterId;
        this.itemLink = itemLink;
    }

    //#endregion
}
