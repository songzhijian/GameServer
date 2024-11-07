package com.jx.config.model;

import com.jx.config.loader.PurchaseFirstRechargeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Purchase_First_Recharge.xml
*/
public class PurchaseFirstRechargeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**归属礼包*/
    private final int belong;
    /**天数*/
    private final int dayNum;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<PurchaseFirstRechargeConfig> findAll(){
        return PurchaseFirstRechargeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PurchaseFirstRechargeConfig getByKey(int key){
        return PurchaseFirstRechargeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 归属礼包
     */
    public int getBelong() {
        return belong;
    }

    /**
     * 天数
     */
    public int getDayNum() {
        return dayNum;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public PurchaseFirstRechargeConfig(int id, int belong, int dayNum, int[][] reward){
        this.id = id;
        this.belong = belong;
        this.dayNum = dayNum;
        this.reward = reward;
    }

    //#endregion
}
