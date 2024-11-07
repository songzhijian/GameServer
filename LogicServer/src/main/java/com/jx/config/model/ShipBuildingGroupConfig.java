package com.jx.config.model;

import com.jx.config.loader.ShipBuildingGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Building_Group.xml
*/
public class ShipBuildingGroupConfig extends AbstractConfig implements IConfig {

    /**id【房间id=groupid+等级】*/
    private final int id;
    /**英雄驻扎的对应id*/
    private final int role;
    /**最高等级*/
    private final int maxLevel;
    /**类型【0=毛坯房,1=普通建筑,2=杂务,3=甲板上建筑,9=梯子】*/
    private final int type;
    /**是否可收纳*/
    private final int canStore;
    /**是否可移动*/
    private final int canMove;
    /**是否能拆除*/
    private final boolean isDemolition;
    /**拆除是否需要英雄*/
    private final boolean isDemolitionNeedHero;
    /**驻扎数量*/
    private final int stationNum;
    /**形状*/
    private final int[] size;
    /**最大建造数量*/
    private final int mostNum;
    /**入舱优先级*/
    private final int order;
    /**英雄瞬移*/
    private final int teleport;
    /**是否可重复*/
    private final int canDuplicate;
    /**默认船舱完成态*/
    private final int defaultCompletion;

    /**
     * 获取所有配置
     */
    public static List<ShipBuildingGroupConfig> findAll(){
        return ShipBuildingGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipBuildingGroupConfig getByKey(int key){
        return ShipBuildingGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id【房间id=groupid+等级】
     */
    public int getId() {
        return id;
    }

    /**
     * 英雄驻扎的对应id
     */
    public int getRole() {
        return role;
    }

    /**
     * 最高等级
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * 类型【0=毛坯房,1=普通建筑,2=杂务,3=甲板上建筑,9=梯子】
     */
    public int getType() {
        return type;
    }

    /**
     * 是否可收纳
     */
    public int getCanStore() {
        return canStore;
    }

    /**
     * 是否可移动
     */
    public int getCanMove() {
        return canMove;
    }

    /**
     * 是否能拆除
     */
    public boolean isIsDemolition() {
        return isDemolition;
    }

    /**
     * 拆除是否需要英雄
     */
    public boolean isIsDemolitionNeedHero() {
        return isDemolitionNeedHero;
    }

    /**
     * 驻扎数量
     */
    public int getStationNum() {
        return stationNum;
    }

    /**
     * 形状
     */
    public int[] getSize() {
        return size;
    }

    /**
     * 最大建造数量
     */
    public int getMostNum() {
        return mostNum;
    }

    /**
     * 入舱优先级
     */
    public int getOrder() {
        return order;
    }

    /**
     * 英雄瞬移
     */
    public int getTeleport() {
        return teleport;
    }

    /**
     * 是否可重复
     */
    public int getCanDuplicate() {
        return canDuplicate;
    }

    /**
     * 默认船舱完成态
     */
    public int getDefaultCompletion() {
        return defaultCompletion;
    }

    //#endregion

    //#region 构造函数

    public ShipBuildingGroupConfig(int id, int role, int maxLevel, int type, int canStore, int canMove, boolean isDemolition, boolean isDemolitionNeedHero, int stationNum, int[] size, int mostNum, int order, int teleport, int canDuplicate, int defaultCompletion){
        this.id = id;
        this.role = role;
        this.maxLevel = maxLevel;
        this.type = type;
        this.canStore = canStore;
        this.canMove = canMove;
        this.isDemolition = isDemolition;
        this.isDemolitionNeedHero = isDemolitionNeedHero;
        this.stationNum = stationNum;
        this.size = size;
        this.mostNum = mostNum;
        this.order = order;
        this.teleport = teleport;
        this.canDuplicate = canDuplicate;
        this.defaultCompletion = defaultCompletion;
    }

    //#endregion
}
