package com.jx.config.model;

import com.jx.config.loader.TowerInterestPointConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tower_Interest_Point.xml
*/
public class TowerInterestPointConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**类型*/
    private final int type;
    /**品质*/
    private final int quality;
    /**等级*/
    private final int level;
    /**需要战斗*/
    private final int isBattle;
    /**世界怪物索引*/
    private final int worldMonster;
    /**成长奖励*/
    private final int[][] reward_1;
    /**非成长奖励*/
    private final int[][] reward_2;
    /**限时（秒）*/
    private final int limitTime;
    /**条件1*/
    private final int[] cond_1;
    /**条件2*/
    private final int[] cond_2;
    /**获取笔记经验*/
    private final int notePointExp;

    /**
     * 获取所有配置
     */
    public static List<TowerInterestPointConfig> findAll(){
        return TowerInterestPointConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TowerInterestPointConfig getByKey(int key){
        return TowerInterestPointConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 品质
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 需要战斗
     */
    public int getIsBattle() {
        return isBattle;
    }

    /**
     * 世界怪物索引
     */
    public int getWorldMonster() {
        return worldMonster;
    }

    /**
     * 成长奖励
     */
    public int[][] getReward_1() {
        return reward_1;
    }

    /**
     * 非成长奖励
     */
    public int[][] getReward_2() {
        return reward_2;
    }

    /**
     * 限时（秒）
     */
    public int getLimitTime() {
        return limitTime;
    }

    /**
     * 条件1
     */
    public int[] getCond_1() {
        return cond_1;
    }

    /**
     * 条件2
     */
    public int[] getCond_2() {
        return cond_2;
    }

    /**
     * 获取笔记经验
     */
    public int getNotePointExp() {
        return notePointExp;
    }

    //#endregion

    //#region 构造函数

    public TowerInterestPointConfig(int id, int type, int quality, int level, int isBattle, int worldMonster, int[][] reward_1, int[][] reward_2, int limitTime, int[] cond_1, int[] cond_2, int notePointExp){
        this.id = id;
        this.type = type;
        this.quality = quality;
        this.level = level;
        this.isBattle = isBattle;
        this.worldMonster = worldMonster;
        this.reward_1 = reward_1;
        this.reward_2 = reward_2;
        this.limitTime = limitTime;
        this.cond_1 = cond_1;
        this.cond_2 = cond_2;
        this.notePointExp = notePointExp;
    }

    //#endregion
}
