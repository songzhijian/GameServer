package com.jx.config.model;

import com.jx.config.loader.TowerUpgradeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tower_Upgrade.xml
*/
public class TowerUpgradeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int lvl;
    /**科技币加成*/
    private final int rewardIncr;
    /**宝藏数量*/
    private final int type0Count;
    /**宝藏随机组*/
    private final int[][] type0Rand;
    /**怪物数量*/
    private final int type1Count;
    /**怪物随机组*/
    private final int[][] type1Rand;
    /**BOSS数量*/
    private final int type2Count;
    /**BOSS随机组*/
    private final int[][] type2Rand;
    /**营救数量*/
    private final int type3Count;
    /**营救随机组*/
    private final int[][] type3Rand;
    /**木筏数量*/
    private final int type4Count;
    /**木筏随机组*/
    private final int[][] type4Rand;
    /**笔记数量*/
    private final int noteCount;

    /**
     * 获取所有配置
     */
    public static List<TowerUpgradeConfig> findAll(){
        return TowerUpgradeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TowerUpgradeConfig getByKey(int key){
        return TowerUpgradeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * 科技币加成
     */
    public int getRewardIncr() {
        return rewardIncr;
    }

    /**
     * 宝藏数量
     */
    public int getType0Count() {
        return type0Count;
    }

    /**
     * 宝藏随机组
     */
    public int[][] getType0Rand() {
        return type0Rand;
    }

    /**
     * 怪物数量
     */
    public int getType1Count() {
        return type1Count;
    }

    /**
     * 怪物随机组
     */
    public int[][] getType1Rand() {
        return type1Rand;
    }

    /**
     * BOSS数量
     */
    public int getType2Count() {
        return type2Count;
    }

    /**
     * BOSS随机组
     */
    public int[][] getType2Rand() {
        return type2Rand;
    }

    /**
     * 营救数量
     */
    public int getType3Count() {
        return type3Count;
    }

    /**
     * 营救随机组
     */
    public int[][] getType3Rand() {
        return type3Rand;
    }

    /**
     * 木筏数量
     */
    public int getType4Count() {
        return type4Count;
    }

    /**
     * 木筏随机组
     */
    public int[][] getType4Rand() {
        return type4Rand;
    }

    /**
     * 笔记数量
     */
    public int getNoteCount() {
        return noteCount;
    }

    //#endregion

    //#region 构造函数

    public TowerUpgradeConfig(int lvl, int rewardIncr, int type0Count, int[][] type0Rand, int type1Count, int[][] type1Rand, int type2Count, int[][] type2Rand, int type3Count, int[][] type3Rand, int type4Count, int[][] type4Rand, int noteCount){
        this.lvl = lvl;
        this.rewardIncr = rewardIncr;
        this.type0Count = type0Count;
        this.type0Rand = type0Rand;
        this.type1Count = type1Count;
        this.type1Rand = type1Rand;
        this.type2Count = type2Count;
        this.type2Rand = type2Rand;
        this.type3Count = type3Count;
        this.type3Rand = type3Rand;
        this.type4Count = type4Count;
        this.type4Rand = type4Rand;
        this.noteCount = noteCount;
    }

    //#endregion
}
