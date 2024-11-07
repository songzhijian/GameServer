package com.jx.config.model;

import com.jx.config.loader.StrikePirateLayerConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Strike_Pirate_Layer.xml
*/
public class StrikePirateLayerConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**归属Chapter*/
    private final int chapter;
    /**特殊条件*/
    private final int[] specialCondition;
    /**特殊条件描述*/
    private final int specialConditionDes;
    /**敌人1*/
    private final int enemy1;
    /**敌人2*/
    private final int enemy2;
    /**敌人3*/
    private final int enemy3;
    /**敌人4*/
    private final int enemy4;
    /**敌人5*/
    private final int enemy5;
    /**解锁分支条件*/
    private final int unlockCondition;
    /**结算参数*/
    private final int[][] unlockParam;
    /**敌人6*/
    private final int extraEnemy;
    /**奖励*/
    private final int[][] bonus;
    /**奖励*/
    private final int[][] mainBonus;

    /**
     * 获取所有配置
     */
    public static List<StrikePirateLayerConfig> findAll(){
        return StrikePirateLayerConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StrikePirateLayerConfig getByKey(int key){
        return StrikePirateLayerConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 归属Chapter
     */
    public int getChapter() {
        return chapter;
    }

    /**
     * 特殊条件
     */
    public int[] getSpecialCondition() {
        return specialCondition;
    }

    /**
     * 特殊条件描述
     */
    public int getSpecialConditionDes() {
        return specialConditionDes;
    }

    /**
     * 敌人1
     */
    public int getEnemy1() {
        return enemy1;
    }

    /**
     * 敌人2
     */
    public int getEnemy2() {
        return enemy2;
    }

    /**
     * 敌人3
     */
    public int getEnemy3() {
        return enemy3;
    }

    /**
     * 敌人4
     */
    public int getEnemy4() {
        return enemy4;
    }

    /**
     * 敌人5
     */
    public int getEnemy5() {
        return enemy5;
    }

    /**
     * 解锁分支条件
     */
    public int getUnlockCondition() {
        return unlockCondition;
    }

    /**
     * 结算参数
     */
    public int[][] getUnlockParam() {
        return unlockParam;
    }

    /**
     * 敌人6
     */
    public int getExtraEnemy() {
        return extraEnemy;
    }

    /**
     * 奖励
     */
    public int[][] getBonus() {
        return bonus;
    }

    /**
     * 奖励
     */
    public int[][] getMainBonus() {
        return mainBonus;
    }

    //#endregion

    //#region 构造函数

    public StrikePirateLayerConfig(int id, int chapter, int[] specialCondition, int specialConditionDes, int enemy1, int enemy2, int enemy3, int enemy4, int enemy5, int unlockCondition, int[][] unlockParam, int extraEnemy, int[][] bonus, int[][] mainBonus){
        this.id = id;
        this.chapter = chapter;
        this.specialCondition = specialCondition;
        this.specialConditionDes = specialConditionDes;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
        this.enemy5 = enemy5;
        this.unlockCondition = unlockCondition;
        this.unlockParam = unlockParam;
        this.extraEnemy = extraEnemy;
        this.bonus = bonus;
        this.mainBonus = mainBonus;
    }

    //#endregion
}
