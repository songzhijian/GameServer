package com.jx.config.model;

import com.jx.config.loader.SkillBaseExchangeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Skill_Base_Exchange.xml
*/
public class SkillBaseExchangeConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**归属英雄*/
    private final int hero;
    /**位置*/
    private final int position;
    /**档位*/
    private final int stage;
    /**类型*/
    private final int type;
    /**是否特殊逻辑*/
    private final int isSpecial;
    /**释放消耗*/
    private final int[] cost;
    /**特殊释放条件*/
    private final int[] condition;
    /**攻击范围类型*/
    private final int rangeType;
    /**攻击范围参数*/
    private final float[] range;
    /**目标类型*/
    private final int targetType;
    /**释放目标参数*/
    private final int[] targetParam;
    /**前置CD时间[秒]*/
    private final float cd1;
    /**CD时间[秒]*/
    private final float cd2;
    /**gcd*/
    private final float gcd;
    /**增加怒气*/
    private final int addPower;
    /**是否无视异常状态*/
    private final int unstoppable;
    /**前摇最末帧*/
    private final int frontHalf;
    /**后摇开始帧*/
    private final int behindHalf;
    /**前摇可被大招打断*/
    private final int canBreak1;
    /**后摇可被大招打断*/
    private final int canBreak2;
    /**前摇被打断是否重置*/
    private final int isResetCD;
    /**base结束帧*/
    private final int endFrame;
    /**位移参数*/
    private final int[][] movParam;
    /**特殊逻辑参数*/
    private final String param;
    /**是否蓄力型大招*/
    private final int isSing;
    /**是否持续施法*/
    private final int[] isSpell;
    /**持续施法中满怒是否立刻放大*/
    private final int spellUltra;

    /**
     * 获取所有配置
     */
    public static List<SkillBaseExchangeConfig> findAll(){
        return SkillBaseExchangeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SkillBaseExchangeConfig getByKey(int key){
        return SkillBaseExchangeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 归属英雄
     */
    public int getHero() {
        return hero;
    }

    /**
     * 位置
     */
    public int getPosition() {
        return position;
    }

    /**
     * 档位
     */
    public int getStage() {
        return stage;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 是否特殊逻辑
     */
    public int getIsSpecial() {
        return isSpecial;
    }

    /**
     * 释放消耗
     */
    public int[] getCost() {
        return cost;
    }

    /**
     * 特殊释放条件
     */
    public int[] getCondition() {
        return condition;
    }

    /**
     * 攻击范围类型
     */
    public int getRangeType() {
        return rangeType;
    }

    /**
     * 攻击范围参数
     */
    public float[] getRange() {
        return range;
    }

    /**
     * 目标类型
     */
    public int getTargetType() {
        return targetType;
    }

    /**
     * 释放目标参数
     */
    public int[] getTargetParam() {
        return targetParam;
    }

    /**
     * 前置CD时间[秒]
     */
    public float getCd1() {
        return cd1;
    }

    /**
     * CD时间[秒]
     */
    public float getCd2() {
        return cd2;
    }

    /**
     * gcd
     */
    public float getGcd() {
        return gcd;
    }

    /**
     * 增加怒气
     */
    public int getAddPower() {
        return addPower;
    }

    /**
     * 是否无视异常状态
     */
    public int getUnstoppable() {
        return unstoppable;
    }

    /**
     * 前摇最末帧
     */
    public int getFrontHalf() {
        return frontHalf;
    }

    /**
     * 后摇开始帧
     */
    public int getBehindHalf() {
        return behindHalf;
    }

    /**
     * 前摇可被大招打断
     */
    public int getCanBreak1() {
        return canBreak1;
    }

    /**
     * 后摇可被大招打断
     */
    public int getCanBreak2() {
        return canBreak2;
    }

    /**
     * 前摇被打断是否重置
     */
    public int getIsResetCD() {
        return isResetCD;
    }

    /**
     * base结束帧
     */
    public int getEndFrame() {
        return endFrame;
    }

    /**
     * 位移参数
     */
    public int[][] getMovParam() {
        return movParam;
    }

    /**
     * 特殊逻辑参数
     */
    public String getParam() {
        return param;
    }

    /**
     * 是否蓄力型大招
     */
    public int getIsSing() {
        return isSing;
    }

    /**
     * 是否持续施法
     */
    public int[] getIsSpell() {
        return isSpell;
    }

    /**
     * 持续施法中满怒是否立刻放大
     */
    public int getSpellUltra() {
        return spellUltra;
    }

    //#endregion

    //#region 构造函数

    public SkillBaseExchangeConfig(int id, int hero, int position, int stage, int type, int isSpecial, int[] cost, int[] condition, int rangeType, float[] range, int targetType, int[] targetParam, float cd1, float cd2, float gcd, int addPower, int unstoppable, int frontHalf, int behindHalf, int canBreak1, int canBreak2, int isResetCD, int endFrame, int[][] movParam, String param, int isSing, int[] isSpell, int spellUltra){
        this.id = id;
        this.hero = hero;
        this.position = position;
        this.stage = stage;
        this.type = type;
        this.isSpecial = isSpecial;
        this.cost = cost;
        this.condition = condition;
        this.rangeType = rangeType;
        this.range = range;
        this.targetType = targetType;
        this.targetParam = targetParam;
        this.cd1 = cd1;
        this.cd2 = cd2;
        this.gcd = gcd;
        this.addPower = addPower;
        this.unstoppable = unstoppable;
        this.frontHalf = frontHalf;
        this.behindHalf = behindHalf;
        this.canBreak1 = canBreak1;
        this.canBreak2 = canBreak2;
        this.isResetCD = isResetCD;
        this.endFrame = endFrame;
        this.movParam = movParam;
        this.param = param;
        this.isSing = isSing;
        this.isSpell = isSpell;
        this.spellUltra = spellUltra;
    }

    //#endregion
}
