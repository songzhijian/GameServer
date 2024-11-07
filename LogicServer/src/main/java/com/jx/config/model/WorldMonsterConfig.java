package com.jx.config.model;

import com.jx.config.loader.WorldMonsterConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Monster.xml
*/
public class WorldMonsterConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**名称*/
    private final int name;
    /**等级*/
    private final int level;
    /**类型*/
    private final int type;
    /**前置击杀怪物id*/
    private final int preMonsterId;
    /**怪物部队*/
    private final int[] army;
    /**伤兵比*/
    private final int hurtRate;
    /**首次击杀奖励*/
    private final int[][] rewardFirstKill;
    /**击杀奖励*/
    private final int[][] reward;
    /**联盟礼物*/
    private final int[][] allianceGift;
    /**首次击杀联盟礼物*/
    private final int[][] allianceGiftFirstKill;
    /**推荐战力*/
    private final int powerLimit;
    /**怪物头像*/
    private final String iconHead;
    /**巡逻半径*/
    private final int patrollRadius;
    /**巡逻CD*/
    private final int patrollCd;
    /**基础速度*/
    private final int baseSpeed;
    /**生命周期*/
    private final int lifeTime;
    /**排行榜积分*/
    private final int rankPoint;
    /**占地半径*/
    private final int radius;

    /**
     * 获取所有配置
     */
    public static List<WorldMonsterConfig> findAll(){
        return WorldMonsterConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldMonsterConfig getByKey(int key){
        return WorldMonsterConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 名称
     */
    public int getName() {
        return name;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 前置击杀怪物id
     */
    public int getPreMonsterId() {
        return preMonsterId;
    }

    /**
     * 怪物部队
     */
    public int[] getArmy() {
        return army;
    }

    /**
     * 伤兵比
     */
    public int getHurtRate() {
        return hurtRate;
    }

    /**
     * 首次击杀奖励
     */
    public int[][] getRewardFirstKill() {
        return rewardFirstKill;
    }

    /**
     * 击杀奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 联盟礼物
     */
    public int[][] getAllianceGift() {
        return allianceGift;
    }

    /**
     * 首次击杀联盟礼物
     */
    public int[][] getAllianceGiftFirstKill() {
        return allianceGiftFirstKill;
    }

    /**
     * 推荐战力
     */
    public int getPowerLimit() {
        return powerLimit;
    }

    /**
     * 怪物头像
     */
    public String getIconHead() {
        return iconHead;
    }

    /**
     * 巡逻半径
     */
    public int getPatrollRadius() {
        return patrollRadius;
    }

    /**
     * 巡逻CD
     */
    public int getPatrollCd() {
        return patrollCd;
    }

    /**
     * 基础速度
     */
    public int getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * 生命周期
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * 排行榜积分
     */
    public int getRankPoint() {
        return rankPoint;
    }

    /**
     * 占地半径
     */
    public int getRadius() {
        return radius;
    }

    //#endregion

    //#region 构造函数

    public WorldMonsterConfig(int id, int name, int level, int type, int preMonsterId, int[] army, int hurtRate, int[][] rewardFirstKill, int[][] reward, int[][] allianceGift, int[][] allianceGiftFirstKill, int powerLimit, String iconHead, int patrollRadius, int patrollCd, int baseSpeed, int lifeTime, int rankPoint, int radius){
        this.id = id;
        this.name = name;
        this.level = level;
        this.type = type;
        this.preMonsterId = preMonsterId;
        this.army = army;
        this.hurtRate = hurtRate;
        this.rewardFirstKill = rewardFirstKill;
        this.reward = reward;
        this.allianceGift = allianceGift;
        this.allianceGiftFirstKill = allianceGiftFirstKill;
        this.powerLimit = powerLimit;
        this.iconHead = iconHead;
        this.patrollRadius = patrollRadius;
        this.patrollCd = patrollCd;
        this.baseSpeed = baseSpeed;
        this.lifeTime = lifeTime;
        this.rankPoint = rankPoint;
        this.radius = radius;
    }

    //#endregion
}
