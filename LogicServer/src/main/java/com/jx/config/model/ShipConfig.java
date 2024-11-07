package com.jx.config.model;

import com.jx.config.loader.ShipConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship.xml
*/
public class ShipConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**解锁条件*/
    private final long[][] unlockCondition;
    /**品质*/
    private final int color;
    /**船体索引*/
    private final int capacity;
    /**舱体大小*/
    private final int[] capacitySize;
    /**舱体源点偏移*/
    private final float[] capacityCoor;
    /**基础耐久度*/
    private final int baseDurability;
    /**基础速度*/
    private final float baseSpeed;
    /**船舱格子数量*/
    private final int cabinCapacity;
    /**基础水兵上限*/
    private final int baseNavy;
    /**基交易品仓库容量上限*/
    private final int baseCabinTrade;
    /**基础食品仓库上限*/
    private final int baseCabinFood;
    /**基础饮用水仓库上限*/
    private final int baseCabinWater;
    /**基础定价*/
    private final int[][] basePrice;
    /**房间特点[白名单制度]*/
    private final int[] roomFeature;
    /**甲板设施[20100=瞭望塔,20200=主帆,20300=操舵,20400=甲板火炮]*/
    private final int[] shipFacilities;
    /**船装备[21=船首像,22=船尾楼,23=船装甲,24=撞角,25=辅助帆]*/
    private final int[] shipEquip;
    /**船装饰[11=船帆颜色，12=船徽，13=船体油漆，14=船特效]*/
    private final int[] shipDecorate;
    /**船长室最高等级*/
    private final int mainBuildingMaxLv;
    /**船舱结构版本*/
    private final int cabinFrameworkVersion;
    /**购买条件*/
    private final long[][] buyCondition;

    /**
     * 获取所有配置
     */
    public static List<ShipConfig> findAll(){
        return ShipConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipConfig getByKey(int key){
        return ShipConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 解锁条件
     */
    public long[][] getUnlockCondition() {
        return unlockCondition;
    }

    /**
     * 品质
     */
    public int getColor() {
        return color;
    }

    /**
     * 船体索引
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 舱体大小
     */
    public int[] getCapacitySize() {
        return capacitySize;
    }

    /**
     * 舱体源点偏移
     */
    public float[] getCapacityCoor() {
        return capacityCoor;
    }

    /**
     * 基础耐久度
     */
    public int getBaseDurability() {
        return baseDurability;
    }

    /**
     * 基础速度
     */
    public float getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * 船舱格子数量
     */
    public int getCabinCapacity() {
        return cabinCapacity;
    }

    /**
     * 基础水兵上限
     */
    public int getBaseNavy() {
        return baseNavy;
    }

    /**
     * 基交易品仓库容量上限
     */
    public int getBaseCabinTrade() {
        return baseCabinTrade;
    }

    /**
     * 基础食品仓库上限
     */
    public int getBaseCabinFood() {
        return baseCabinFood;
    }

    /**
     * 基础饮用水仓库上限
     */
    public int getBaseCabinWater() {
        return baseCabinWater;
    }

    /**
     * 基础定价
     */
    public int[][] getBasePrice() {
        return basePrice;
    }

    /**
     * 房间特点[白名单制度]
     */
    public int[] getRoomFeature() {
        return roomFeature;
    }

    /**
     * 甲板设施[20100=瞭望塔,20200=主帆,20300=操舵,20400=甲板火炮]
     */
    public int[] getShipFacilities() {
        return shipFacilities;
    }

    /**
     * 船装备[21=船首像,22=船尾楼,23=船装甲,24=撞角,25=辅助帆]
     */
    public int[] getShipEquip() {
        return shipEquip;
    }

    /**
     * 船装饰[11=船帆颜色，12=船徽，13=船体油漆，14=船特效]
     */
    public int[] getShipDecorate() {
        return shipDecorate;
    }

    /**
     * 船长室最高等级
     */
    public int getMainBuildingMaxLv() {
        return mainBuildingMaxLv;
    }

    /**
     * 船舱结构版本
     */
    public int getCabinFrameworkVersion() {
        return cabinFrameworkVersion;
    }

    /**
     * 购买条件
     */
    public long[][] getBuyCondition() {
        return buyCondition;
    }

    //#endregion

    //#region 构造函数

    public ShipConfig(int id, long[][] unlockCondition, int color, int capacity, int[] capacitySize, float[] capacityCoor, int baseDurability, float baseSpeed, int cabinCapacity, int baseNavy, int baseCabinTrade, int baseCabinFood, int baseCabinWater, int[][] basePrice, int[] roomFeature, int[] shipFacilities, int[] shipEquip, int[] shipDecorate, int mainBuildingMaxLv, int cabinFrameworkVersion, long[][] buyCondition){
        this.id = id;
        this.unlockCondition = unlockCondition;
        this.color = color;
        this.capacity = capacity;
        this.capacitySize = capacitySize;
        this.capacityCoor = capacityCoor;
        this.baseDurability = baseDurability;
        this.baseSpeed = baseSpeed;
        this.cabinCapacity = cabinCapacity;
        this.baseNavy = baseNavy;
        this.baseCabinTrade = baseCabinTrade;
        this.baseCabinFood = baseCabinFood;
        this.baseCabinWater = baseCabinWater;
        this.basePrice = basePrice;
        this.roomFeature = roomFeature;
        this.shipFacilities = shipFacilities;
        this.shipEquip = shipEquip;
        this.shipDecorate = shipDecorate;
        this.mainBuildingMaxLv = mainBuildingMaxLv;
        this.cabinFrameworkVersion = cabinFrameworkVersion;
        this.buyCondition = buyCondition;
    }

    //#endregion
}
