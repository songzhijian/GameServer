package com.jx.config.model;

import com.jx.config.loader.ShipBuildingConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Building.xml
*/
public class ShipBuildingConfig extends AbstractConfig implements IConfig {

    /**id【房间id=groupid+等级】*/
    private final int id;
    /**组*/
    private final int group;
    /**等级*/
    private final int level;
    /**升级时长（秒）*/
    private final int upgradeTime;
    /**前置建筑*/
    private final long[][] preconditions;
    /**建造消耗*/
    private final int[][] consume;
    /**效果*/
    private final int[][] eff;
    /**当有英雄工作时额外产生的效果*/
    private final int[][] extraEff;
    /**战斗力*/
    private final int power;

    /**
     * 获取所有配置
     */
    public static List<ShipBuildingConfig> findAll(){
        return ShipBuildingConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipBuildingConfig getByKey(int key){
        return ShipBuildingConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id【房间id=groupid+等级】
     */
    public int getId() {
        return id;
    }

    /**
     * 组
     */
    public int getGroup() {
        return group;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 升级时长（秒）
     */
    public int getUpgradeTime() {
        return upgradeTime;
    }

    /**
     * 前置建筑
     */
    public long[][] getPreconditions() {
        return preconditions;
    }

    /**
     * 建造消耗
     */
    public int[][] getConsume() {
        return consume;
    }

    /**
     * 效果
     */
    public int[][] getEff() {
        return eff;
    }

    /**
     * 当有英雄工作时额外产生的效果
     */
    public int[][] getExtraEff() {
        return extraEff;
    }

    /**
     * 战斗力
     */
    public int getPower() {
        return power;
    }

    //#endregion

    //#region 构造函数

    public ShipBuildingConfig(int id, int group, int level, int upgradeTime, long[][] preconditions, int[][] consume, int[][] eff, int[][] extraEff, int power){
        this.id = id;
        this.group = group;
        this.level = level;
        this.upgradeTime = upgradeTime;
        this.preconditions = preconditions;
        this.consume = consume;
        this.eff = eff;
        this.extraEff = extraEff;
        this.power = power;
    }

    //#endregion
}
