package com.jx.config.model;

import com.jx.config.loader.StageBattleBotConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Stage_Battle_Bot.xml
*/
public class StageBattleBotConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
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
    /**等级1*/
    private final int level1;
    /**等级2*/
    private final int level2;
    /**等级3*/
    private final int level3;
    /**等级4*/
    private final int level4;
    /**等级5*/
    private final int level5;
    /**资质1*/
    private final int quality1;
    /**资质2*/
    private final int quality2;
    /**资质3*/
    private final int quality3;
    /**资质4*/
    private final int quality4;
    /**资质5*/
    private final int quality5;
    /**士兵1*/
    private final int[][] navy1;
    /**士兵2*/
    private final int[][] navy2;
    /**士兵3*/
    private final int[][] navy3;
    /**士兵4*/
    private final int[][] navy4;
    /**士兵5*/
    private final int[][] navy5;
    /**装备1*/
    private final int[][] equip1;
    /**装备2*/
    private final int[][] equip2;
    /**装备3*/
    private final int[][] equip3;
    /**装备4*/
    private final int[][] equip4;
    /**装备5*/
    private final int[][] equip5;
    /**buff1*/
    private final String[] buff1;
    /**buff2*/
    private final String[] buff2;
    /**buff3*/
    private final String[] buff3;
    /**buff4*/
    private final String[] buff4;
    /**buff5*/
    private final String[] buff5;
    /**敌人怒气*/
    private final int[] powerEnemy;
    /**我方怒气*/
    private final int[] powerPlayer;
    /**我方怒气速度*/
    private final int powerSpdPlayer;
    /**敌人怒气速度*/
    private final int powerSpdEnemy;
    /**敌人HPCoef-对应42*/
    private final int HpCoefEnemy;
    /**敌人ATKCoef-对应45*/
    private final int AtkCoefEnemy;
    /**boss位*/
    private final int boss;
    /**bossHPCoef-对应42*/
    private final int HpCoefBoss;
    /**bossATKCoef-对应45*/
    private final int AtkCoefBoss;
    /**等级压制*/
    private final int levelSuppress;
    /**等级压制2*/
    private final int levelSuppress2;
    /**兵损系数*/
    private final int troopLoss;

    /**
     * 获取所有配置
     */
    public static List<StageBattleBotConfig> findAll(){
        return StageBattleBotConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StageBattleBotConfig getByKey(int key){
        return StageBattleBotConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
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
     * 等级1
     */
    public int getLevel1() {
        return level1;
    }

    /**
     * 等级2
     */
    public int getLevel2() {
        return level2;
    }

    /**
     * 等级3
     */
    public int getLevel3() {
        return level3;
    }

    /**
     * 等级4
     */
    public int getLevel4() {
        return level4;
    }

    /**
     * 等级5
     */
    public int getLevel5() {
        return level5;
    }

    /**
     * 资质1
     */
    public int getQuality1() {
        return quality1;
    }

    /**
     * 资质2
     */
    public int getQuality2() {
        return quality2;
    }

    /**
     * 资质3
     */
    public int getQuality3() {
        return quality3;
    }

    /**
     * 资质4
     */
    public int getQuality4() {
        return quality4;
    }

    /**
     * 资质5
     */
    public int getQuality5() {
        return quality5;
    }

    /**
     * 士兵1
     */
    public int[][] getNavy1() {
        return navy1;
    }

    /**
     * 士兵2
     */
    public int[][] getNavy2() {
        return navy2;
    }

    /**
     * 士兵3
     */
    public int[][] getNavy3() {
        return navy3;
    }

    /**
     * 士兵4
     */
    public int[][] getNavy4() {
        return navy4;
    }

    /**
     * 士兵5
     */
    public int[][] getNavy5() {
        return navy5;
    }

    /**
     * 装备1
     */
    public int[][] getEquip1() {
        return equip1;
    }

    /**
     * 装备2
     */
    public int[][] getEquip2() {
        return equip2;
    }

    /**
     * 装备3
     */
    public int[][] getEquip3() {
        return equip3;
    }

    /**
     * 装备4
     */
    public int[][] getEquip4() {
        return equip4;
    }

    /**
     * 装备5
     */
    public int[][] getEquip5() {
        return equip5;
    }

    /**
     * buff1
     */
    public String[] getBuff1() {
        return buff1;
    }

    /**
     * buff2
     */
    public String[] getBuff2() {
        return buff2;
    }

    /**
     * buff3
     */
    public String[] getBuff3() {
        return buff3;
    }

    /**
     * buff4
     */
    public String[] getBuff4() {
        return buff4;
    }

    /**
     * buff5
     */
    public String[] getBuff5() {
        return buff5;
    }

    /**
     * 敌人怒气
     */
    public int[] getPowerEnemy() {
        return powerEnemy;
    }

    /**
     * 我方怒气
     */
    public int[] getPowerPlayer() {
        return powerPlayer;
    }

    /**
     * 我方怒气速度
     */
    public int getPowerSpdPlayer() {
        return powerSpdPlayer;
    }

    /**
     * 敌人怒气速度
     */
    public int getPowerSpdEnemy() {
        return powerSpdEnemy;
    }

    /**
     * 敌人HPCoef-对应42
     */
    public int getHpCoefEnemy() {
        return HpCoefEnemy;
    }

    /**
     * 敌人ATKCoef-对应45
     */
    public int getAtkCoefEnemy() {
        return AtkCoefEnemy;
    }

    /**
     * boss位
     */
    public int getBoss() {
        return boss;
    }

    /**
     * bossHPCoef-对应42
     */
    public int getHpCoefBoss() {
        return HpCoefBoss;
    }

    /**
     * bossATKCoef-对应45
     */
    public int getAtkCoefBoss() {
        return AtkCoefBoss;
    }

    /**
     * 等级压制
     */
    public int getLevelSuppress() {
        return levelSuppress;
    }

    /**
     * 等级压制2
     */
    public int getLevelSuppress2() {
        return levelSuppress2;
    }

    /**
     * 兵损系数
     */
    public int getTroopLoss() {
        return troopLoss;
    }

    //#endregion

    //#region 构造函数

    public StageBattleBotConfig(int id, int enemy1, int enemy2, int enemy3, int enemy4, int enemy5, int level1, int level2, int level3, int level4, int level5, int quality1, int quality2, int quality3, int quality4, int quality5, int[][] navy1, int[][] navy2, int[][] navy3, int[][] navy4, int[][] navy5, int[][] equip1, int[][] equip2, int[][] equip3, int[][] equip4, int[][] equip5, String[] buff1, String[] buff2, String[] buff3, String[] buff4, String[] buff5, int[] powerEnemy, int[] powerPlayer, int powerSpdPlayer, int powerSpdEnemy, int HpCoefEnemy, int AtkCoefEnemy, int boss, int HpCoefBoss, int AtkCoefBoss, int levelSuppress, int levelSuppress2, int troopLoss){
        this.id = id;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
        this.enemy5 = enemy5;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.level4 = level4;
        this.level5 = level5;
        this.quality1 = quality1;
        this.quality2 = quality2;
        this.quality3 = quality3;
        this.quality4 = quality4;
        this.quality5 = quality5;
        this.navy1 = navy1;
        this.navy2 = navy2;
        this.navy3 = navy3;
        this.navy4 = navy4;
        this.navy5 = navy5;
        this.equip1 = equip1;
        this.equip2 = equip2;
        this.equip3 = equip3;
        this.equip4 = equip4;
        this.equip5 = equip5;
        this.buff1 = buff1;
        this.buff2 = buff2;
        this.buff3 = buff3;
        this.buff4 = buff4;
        this.buff5 = buff5;
        this.powerEnemy = powerEnemy;
        this.powerPlayer = powerPlayer;
        this.powerSpdPlayer = powerSpdPlayer;
        this.powerSpdEnemy = powerSpdEnemy;
        this.HpCoefEnemy = HpCoefEnemy;
        this.AtkCoefEnemy = AtkCoefEnemy;
        this.boss = boss;
        this.HpCoefBoss = HpCoefBoss;
        this.AtkCoefBoss = AtkCoefBoss;
        this.levelSuppress = levelSuppress;
        this.levelSuppress2 = levelSuppress2;
        this.troopLoss = troopLoss;
    }

    //#endregion
}
