package com.jx.config.model;

import com.jx.config.loader.HighArenaArenaRankConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 HighArenaArena_Rank.xml
*/
public class HighArenaArenaRankConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**排名*/
    private final int[] rank;
    /**名称*/
    private final String name;
    /**图标*/
    private final String icon;
    /**1位置的寻觅范围*/
    private final int[] enemyZone1;
    /**2位置的寻觅范围*/
    private final int[] enemyZone2;
    /**3位置的寻觅范围*/
    private final int[] enemyZone3;
    /**4位置的寻觅范围*/
    private final int[] enemyZone4;
    /**5位置的寻觅范围*/
    private final int[] enemyZone5;
    /**1步长*/
    private final int[] zoneStep1;
    /**2步长*/
    private final int[] zoneStep2;
    /**3步长*/
    private final int[] zoneStep3;
    /**4步长*/
    private final int[] zoneStep4;
    /**5步长*/
    private final int[] zoneStep5;
    /**重置积分*/
    private final int resetIntegral;
    /**积分效率*/
    private final int efficiency;

    /**
     * 获取所有配置
     */
    public static List<HighArenaArenaRankConfig> findAll(){
        return HighArenaArenaRankConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HighArenaArenaRankConfig getByKey(int key){
        return HighArenaArenaRankConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 排名
     */
    public int[] getRank() {
        return rank;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 1位置的寻觅范围
     */
    public int[] getEnemyZone1() {
        return enemyZone1;
    }

    /**
     * 2位置的寻觅范围
     */
    public int[] getEnemyZone2() {
        return enemyZone2;
    }

    /**
     * 3位置的寻觅范围
     */
    public int[] getEnemyZone3() {
        return enemyZone3;
    }

    /**
     * 4位置的寻觅范围
     */
    public int[] getEnemyZone4() {
        return enemyZone4;
    }

    /**
     * 5位置的寻觅范围
     */
    public int[] getEnemyZone5() {
        return enemyZone5;
    }

    /**
     * 1步长
     */
    public int[] getZoneStep1() {
        return zoneStep1;
    }

    /**
     * 2步长
     */
    public int[] getZoneStep2() {
        return zoneStep2;
    }

    /**
     * 3步长
     */
    public int[] getZoneStep3() {
        return zoneStep3;
    }

    /**
     * 4步长
     */
    public int[] getZoneStep4() {
        return zoneStep4;
    }

    /**
     * 5步长
     */
    public int[] getZoneStep5() {
        return zoneStep5;
    }

    /**
     * 重置积分
     */
    public int getResetIntegral() {
        return resetIntegral;
    }

    /**
     * 积分效率
     */
    public int getEfficiency() {
        return efficiency;
    }

    //#endregion

    //#region 构造函数

    public HighArenaArenaRankConfig(int id, int[] rank, String name, String icon, int[] enemyZone1, int[] enemyZone2, int[] enemyZone3, int[] enemyZone4, int[] enemyZone5, int[] zoneStep1, int[] zoneStep2, int[] zoneStep3, int[] zoneStep4, int[] zoneStep5, int resetIntegral, int efficiency){
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.icon = icon;
        this.enemyZone1 = enemyZone1;
        this.enemyZone2 = enemyZone2;
        this.enemyZone3 = enemyZone3;
        this.enemyZone4 = enemyZone4;
        this.enemyZone5 = enemyZone5;
        this.zoneStep1 = zoneStep1;
        this.zoneStep2 = zoneStep2;
        this.zoneStep3 = zoneStep3;
        this.zoneStep4 = zoneStep4;
        this.zoneStep5 = zoneStep5;
        this.resetIntegral = resetIntegral;
        this.efficiency = efficiency;
    }

    //#endregion
}
