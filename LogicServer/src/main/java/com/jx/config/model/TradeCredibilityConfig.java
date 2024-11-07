package com.jx.config.model;

import com.jx.config.loader.TradeCredibilityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Credibility.xml
*/
public class TradeCredibilityConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**信用等级*/
    private final int displayLevel;
    /**需要经验*/
    private final int exp;
    /**进货税率降低,万分比，直接加减*/
    private final int tax;

    /**
     * 获取所有配置
     */
    public static List<TradeCredibilityConfig> findAll(){
        return TradeCredibilityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradeCredibilityConfig getByKey(int key){
        return TradeCredibilityConfigLoader.getByKey(key);
    }

    //#region getter
    public int getId() {
        return id;
    }

    /**
     * 信用等级
     */
    public int getDisplayLevel() {
        return displayLevel;
    }

    /**
     * 需要经验
     */
    public int getExp() {
        return exp;
    }

    /**
     * 进货税率降低,万分比，直接加减
     */
    public int getTax() {
        return tax;
    }

    //#endregion

    //#region 构造函数

    public TradeCredibilityConfig(int id, int displayLevel, int exp, int tax){
        this.id = id;
        this.displayLevel = displayLevel;
        this.exp = exp;
        this.tax = tax;
    }

    //#endregion
}
