package com.jx.config.model;

import com.jx.config.loader.ArenaRankConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Arena_Rank.xml
*/
public class ArenaRankConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**名次区间*/
    private final int[] rank;
    /**1位置的寻觅范围*/
    private final int[] enemyZone1;
    /**2位置的寻觅范围*/
    private final int[] enemyZone2;
    /**3位置的寻觅范围*/
    private final int[] enemyZone3;
    /**1步长*/
    private final int[] zoneStep1;
    /**2步长*/
    private final int[] zoneStep2;
    /**3步长*/
    private final int[] zoneStep3;
    /**赛季结算奖励*/
    private final int[][] reward;
    /**重置积分*/
    private final int resetIntegral;

    /**
     * 获取所有配置
     */
    public static List<ArenaRankConfig> findAll(){
        return ArenaRankConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ArenaRankConfig getByKey(int key){
        return ArenaRankConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 名次区间
     */
    public int[] getRank() {
        return rank;
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
     * 赛季结算奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 重置积分
     */
    public int getResetIntegral() {
        return resetIntegral;
    }

    //#endregion

    //#region 构造函数

    public ArenaRankConfig(int id, int[] rank, int[] enemyZone1, int[] enemyZone2, int[] enemyZone3, int[] zoneStep1, int[] zoneStep2, int[] zoneStep3, int[][] reward, int resetIntegral){
        this.id = id;
        this.rank = rank;
        this.enemyZone1 = enemyZone1;
        this.enemyZone2 = enemyZone2;
        this.enemyZone3 = enemyZone3;
        this.zoneStep1 = zoneStep1;
        this.zoneStep2 = zoneStep2;
        this.zoneStep3 = zoneStep3;
        this.reward = reward;
        this.resetIntegral = resetIntegral;
    }

    //#endregion
}
