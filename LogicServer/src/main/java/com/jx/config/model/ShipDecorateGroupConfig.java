package com.jx.config.model;

import com.jx.config.loader.ShipDecorateGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Decorate_Group.xml
*/
public class ShipDecorateGroupConfig extends AbstractConfig implements IConfig {

    /**groupid*/
    private final int id;
    /**更换消耗【空=无消耗】*/
    private final int[][] cost;

    /**
     * 获取所有配置
     */
    public static List<ShipDecorateGroupConfig> findAll(){
        return ShipDecorateGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipDecorateGroupConfig getByKey(int key){
        return ShipDecorateGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * groupid
     */
    public int getId() {
        return id;
    }

    /**
     * 更换消耗【空=无消耗】
     */
    public int[][] getCost() {
        return cost;
    }

    //#endregion

    //#region 构造函数

    public ShipDecorateGroupConfig(int id, int[][] cost){
        this.id = id;
        this.cost = cost;
    }

    //#endregion
}
