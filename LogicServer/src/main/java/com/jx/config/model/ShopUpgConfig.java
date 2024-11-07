package com.jx.config.model;

import com.jx.config.loader.ShopUpgConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Shop_Upg.xml
*/
public class ShopUpgConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**等级*/
    private final int lvl;
    /**升级条件*/
    private final long[][] cond;
    /**商品数量*/
    private final int prodQty;
    /**免费刷新次数*/
    private final int refreshCnt;
    /**付费刷新价格*/
    private final int[][] refreshCost;
    /**物品刷新随机组*/
    private final int[] prodRefreshRandom;

    /**
     * 获取所有配置
     */
    public static List<ShopUpgConfig> findAll(){
        return ShopUpgConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShopUpgConfig getByKey(int key){
        return ShopUpgConfigLoader.getByKey(key);
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
    public int getLvl() {
        return lvl;
    }

    /**
     * 升级条件
     */
    public long[][] getCond() {
        return cond;
    }

    /**
     * 商品数量
     */
    public int getProdQty() {
        return prodQty;
    }

    /**
     * 免费刷新次数
     */
    public int getRefreshCnt() {
        return refreshCnt;
    }

    /**
     * 付费刷新价格
     */
    public int[][] getRefreshCost() {
        return refreshCost;
    }

    /**
     * 物品刷新随机组
     */
    public int[] getProdRefreshRandom() {
        return prodRefreshRandom;
    }

    //#endregion

    //#region 构造函数

    public ShopUpgConfig(int id, int lvl, long[][] cond, int prodQty, int refreshCnt, int[][] refreshCost, int[] prodRefreshRandom){
        this.id = id;
        this.lvl = lvl;
        this.cond = cond;
        this.prodQty = prodQty;
        this.refreshCnt = refreshCnt;
        this.refreshCost = refreshCost;
        this.prodRefreshRandom = prodRefreshRandom;
    }

    //#endregion
}
