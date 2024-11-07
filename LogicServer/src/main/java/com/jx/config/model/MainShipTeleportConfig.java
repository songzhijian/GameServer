package com.jx.config.model;

import com.jx.config.loader.MainShipTeleportConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Main_Ship_Teleport.xml
*/
public class MainShipTeleportConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**1:耗道具道具，2:看是否冷却，3:看是否有次数，没有次数消耗钻石*/
    private final int[][] cost;
    /**礼包id*/
    private final int purchaseId;
    /**冷却时间秒s*/
    private final int cd;
    /**存储次数，每日0点更新*/
    private final int storageTime;
    /**每种类型传送参数*/
    private final int[] param;
    /**互斥作用号*/
    private final int[] exclusionEffects;

    /**
     * 获取所有配置
     */
    public static List<MainShipTeleportConfig> findAll(){
        return MainShipTeleportConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MainShipTeleportConfig getByKey(int key){
        return MainShipTeleportConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 1:耗道具道具，2:看是否冷却，3:看是否有次数，没有次数消耗钻石
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * 礼包id
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * 冷却时间秒s
     */
    public int getCd() {
        return cd;
    }

    /**
     * 存储次数，每日0点更新
     */
    public int getStorageTime() {
        return storageTime;
    }

    /**
     * 每种类型传送参数
     */
    public int[] getParam() {
        return param;
    }

    /**
     * 互斥作用号
     */
    public int[] getExclusionEffects() {
        return exclusionEffects;
    }

    //#endregion

    //#region 构造函数

    public MainShipTeleportConfig(int id, int[][] cost, int purchaseId, int cd, int storageTime, int[] param, int[] exclusionEffects){
        this.id = id;
        this.cost = cost;
        this.purchaseId = purchaseId;
        this.cd = cd;
        this.storageTime = storageTime;
        this.param = param;
        this.exclusionEffects = exclusionEffects;
    }

    //#endregion
}
