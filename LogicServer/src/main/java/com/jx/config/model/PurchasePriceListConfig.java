package com.jx.config.model;

import com.jx.config.loader.PurchasePriceListConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Purchase_Price_List.xml
*/
public class PurchasePriceListConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**次数*/
    private final int[] Num;
    /**消耗*/
    private final int[][] cost;
    /**奖励*/
    private final int[][] reward;
    /**类型*/
    private final int type;

    /**
     * 获取所有配置
     */
    public static List<PurchasePriceListConfig> findAll(){
        return PurchasePriceListConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PurchasePriceListConfig getByKey(int key){
        return PurchasePriceListConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 次数
     */
    public int[] getNum() {
        return Num;
    }

    /**
     * 消耗
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    //#endregion

    //#region 构造函数

    public PurchasePriceListConfig(int id, int[] Num, int[][] cost, int[][] reward, int type){
        this.id = id;
        this.Num = Num;
        this.cost = cost;
        this.reward = reward;
        this.type = type;
    }

    //#endregion
}
