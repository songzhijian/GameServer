package com.jx.config.model;

import com.jx.config.loader.ShopConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Shop.xml
*/
public class ShopConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**商店类型*/
    private final int type;
    /**刷新方式*/
    private final String[] refreshTime;
    /**分等级索引*/
    private final int[] levelRule;
    /**是随机商品*/
    private final boolean isRandProd;
    /**商品（组）列表*/
    private final int[] prodList;
    /**显示资源列表*/
    private final int[] dispResList;
    /**商品来源*/
    private final int businessType;
    /**页签显示条件*/
    private final int showCondition;

    /**
     * 获取所有配置
     */
    public static List<ShopConfig> findAll(){
        return ShopConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShopConfig getByKey(int key){
        return ShopConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 商店类型
     */
    public int getType() {
        return type;
    }

    /**
     * 刷新方式
     */
    public String[] getRefreshTime() {
        return refreshTime;
    }

    /**
     * 分等级索引
     */
    public int[] getLevelRule() {
        return levelRule;
    }

    /**
     * 是随机商品
     */
    public boolean isIsRandProd() {
        return isRandProd;
    }

    /**
     * 商品（组）列表
     */
    public int[] getProdList() {
        return prodList;
    }

    /**
     * 显示资源列表
     */
    public int[] getDispResList() {
        return dispResList;
    }

    /**
     * 商品来源
     */
    public int getBusinessType() {
        return businessType;
    }

    /**
     * 页签显示条件
     */
    public int getShowCondition() {
        return showCondition;
    }

    //#endregion

    //#region 构造函数

    public ShopConfig(int id, int type, String[] refreshTime, int[] levelRule, boolean isRandProd, int[] prodList, int[] dispResList, int businessType, int showCondition){
        this.id = id;
        this.type = type;
        this.refreshTime = refreshTime;
        this.levelRule = levelRule;
        this.isRandProd = isRandProd;
        this.prodList = prodList;
        this.dispResList = dispResList;
        this.businessType = businessType;
        this.showCondition = showCondition;
    }

    //#endregion
}
