package com.jx.config.model;

import com.jx.config.loader.ShipCapacityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Capacity.xml
*/
public class ShipCapacityConfig extends AbstractConfig implements IConfig {

    /**假id*/
    private final int id;
    /**真id*/
    private final int shipId;
    /**x坐标*/
    private final int xCoor;
    /**y坐标*/
    private final int yCoor;
    /**z坐标(如不填，即不需要）*/
    private final int zCoor;
    /**类型【0=空气，1=可建造，2=固定设施，3=杂物】*/
    private final int type;
    /**是否甲板上*/
    private final boolean onBoard;
    /**初始建筑【空=0=没有初始，填写=group id=Link:Building】*/
    private final int initBuilding;

    /**
     * 获取所有配置
     */
    public static List<ShipCapacityConfig> findAll(){
        return ShipCapacityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipCapacityConfig getByKey(int key){
        return ShipCapacityConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 假id
     */
    public int getId() {
        return id;
    }

    /**
     * 真id
     */
    public int getShipId() {
        return shipId;
    }

    /**
     * x坐标
     */
    public int getXCoor() {
        return xCoor;
    }

    /**
     * y坐标
     */
    public int getYCoor() {
        return yCoor;
    }

    /**
     * z坐标(如不填，即不需要）
     */
    public int getZCoor() {
        return zCoor;
    }

    /**
     * 类型【0=空气，1=可建造，2=固定设施，3=杂物】
     */
    public int getType() {
        return type;
    }

    /**
     * 是否甲板上
     */
    public boolean isOnBoard() {
        return onBoard;
    }

    /**
     * 初始建筑【空=0=没有初始，填写=group id=Link:Building】
     */
    public int getInitBuilding() {
        return initBuilding;
    }

    //#endregion

    //#region 构造函数

    public ShipCapacityConfig(int id, int shipId, int xCoor, int yCoor, int zCoor, int type, boolean onBoard, int initBuilding){
        this.id = id;
        this.shipId = shipId;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.zCoor = zCoor;
        this.type = type;
        this.onBoard = onBoard;
        this.initBuilding = initBuilding;
    }

    //#endregion
}
