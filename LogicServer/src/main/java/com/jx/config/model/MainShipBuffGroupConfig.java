package com.jx.config.model;

import com.jx.config.loader.MainShipBuffGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Main_Ship_Buff_Group.xml
*/
public class MainShipBuffGroupConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**世界buff，[[buffid1,itemid1,price1],[buffid2,itemid2,price2]...]*/
    private final int[][] mainShipBuff;
    /**购买限制[有以下buff的时候，禁止购买]*/
    private final int[] useLimit;

    /**
     * 获取所有配置
     */
    public static List<MainShipBuffGroupConfig> findAll(){
        return MainShipBuffGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MainShipBuffGroupConfig getByKey(int key){
        return MainShipBuffGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 世界buff，[[buffid1,itemid1,price1],[buffid2,itemid2,price2]...]
     */
    public int[][] getMainShipBuff() {
        return mainShipBuff;
    }

    /**
     * 购买限制[有以下buff的时候，禁止购买]
     */
    public int[] getUseLimit() {
        return useLimit;
    }

    //#endregion

    //#region 构造函数

    public MainShipBuffGroupConfig(int id, int[][] mainShipBuff, int[] useLimit){
        this.id = id;
        this.mainShipBuff = mainShipBuff;
        this.useLimit = useLimit;
    }

    //#endregion
}
