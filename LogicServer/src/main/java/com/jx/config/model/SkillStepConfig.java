package com.jx.config.model;

import com.jx.config.loader.SkillStepConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Skill_Step.xml
*/
public class SkillStepConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final String skillId;
    /**归属技能*/
    private final int skill;
    /**归属英雄*/
    private final int hero;
    /**上一步step*/
    private final String front;
    /**类型*/
    private final int type;
    /**是否重置list*/
    private final int isResetList;
    /**攻击范围类型*/
    private final int rangeType;
    /**攻击范围参数*/
    private final int[] rangeParam;
    /**释放目标类型*/
    private final int targetType;
    /**释放目标参数*/
    private final int[] targetParam;
    /**优先目标类型*/
    private final int priorityType;
    /**优先目标参数*/
    private final int[] priorityParam;
    /**下一步step*/
    private final String next;
    /**子弹目标位置逻辑类型*/
    private final int moveLogic;
    /**子弹创造位置逻辑*/
    private final int createPos;
    /**创造位置的参数*/
    private final String createParam;
    /**创造位置偏移量*/
    private final float[] createCoor;
    /**子弹移动速度【-1=需要计算速度】*/
    private final float missleSpd;
    /**子弹多少帧移动到【当missleSpd=-1时生效】*/
    private final int missleTime;
    /**子弹循环方式*/
    private final int missleType;
    /**子弹资源*/
    private final String[] missleSrc;
    /**触发Step方式*/
    private final int triggerType;
    /**子弹结束帧*/
    private final int missleEndFrame;
    /**是否必命中*/
    private final int boundHit;
    /**强制对自己施法*/
    private final int actOnSelf;
    /**作用2的触发条件*/
    private final String[] atkCondition;
    /**作用2【触发条件生效下的作用】*/
    private final String[] atkEff2;
    /**是否屏蔽已经被赋予attack的目标不能再被筛选到*/
    private final int isKickList;

    /**
     * 获取所有配置
     */
    public static List<SkillStepConfig> findAll(){
        return SkillStepConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SkillStepConfig getByKey(String key){
        return SkillStepConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public String getSkillId() {
        return skillId;
    }

    /**
     * 归属技能
     */
    public int getSkill() {
        return skill;
    }

    /**
     * 归属英雄
     */
    public int getHero() {
        return hero;
    }

    /**
     * 上一步step
     */
    public String getFront() {
        return front;
    }

    /**
     * 类型
     */
    public int getType() {
        return type;
    }

    /**
     * 是否重置list
     */
    public int getIsResetList() {
        return isResetList;
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
    public int[] getRangeParam() {
        return rangeParam;
    }

    /**
     * 释放目标类型
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
     * 优先目标类型
     */
    public int getPriorityType() {
        return priorityType;
    }

    /**
     * 优先目标参数
     */
    public int[] getPriorityParam() {
        return priorityParam;
    }

    /**
     * 下一步step
     */
    public String getNext() {
        return next;
    }

    /**
     * 子弹目标位置逻辑类型
     */
    public int getMoveLogic() {
        return moveLogic;
    }

    /**
     * 子弹创造位置逻辑
     */
    public int getCreatePos() {
        return createPos;
    }

    /**
     * 创造位置的参数
     */
    public String getCreateParam() {
        return createParam;
    }

    /**
     * 创造位置偏移量
     */
    public float[] getCreateCoor() {
        return createCoor;
    }

    /**
     * 子弹移动速度【-1=需要计算速度】
     */
    public float getMissleSpd() {
        return missleSpd;
    }

    /**
     * 子弹多少帧移动到【当missleSpd=-1时生效】
     */
    public int getMissleTime() {
        return missleTime;
    }

    /**
     * 子弹循环方式
     */
    public int getMissleType() {
        return missleType;
    }

    /**
     * 子弹资源
     */
    public String[] getMissleSrc() {
        return missleSrc;
    }

    /**
     * 触发Step方式
     */
    public int getTriggerType() {
        return triggerType;
    }

    /**
     * 子弹结束帧
     */
    public int getMissleEndFrame() {
        return missleEndFrame;
    }

    /**
     * 是否必命中
     */
    public int getBoundHit() {
        return boundHit;
    }

    /**
     * 强制对自己施法
     */
    public int getActOnSelf() {
        return actOnSelf;
    }

    /**
     * 作用2的触发条件
     */
    public String[] getAtkCondition() {
        return atkCondition;
    }

    /**
     * 作用2【触发条件生效下的作用】
     */
    public String[] getAtkEff2() {
        return atkEff2;
    }

    /**
     * 是否屏蔽已经被赋予attack的目标不能再被筛选到
     */
    public int getIsKickList() {
        return isKickList;
    }

    //#endregion

    //#region 构造函数

    public SkillStepConfig(String skillId, int skill, int hero, String front, int type, int isResetList, int rangeType, int[] rangeParam, int targetType, int[] targetParam, int priorityType, int[] priorityParam, String next, int moveLogic, int createPos, String createParam, float[] createCoor, float missleSpd, int missleTime, int missleType, String[] missleSrc, int triggerType, int missleEndFrame, int boundHit, int actOnSelf, String[] atkCondition, String[] atkEff2, int isKickList){
        this.skillId = skillId;
        this.skill = skill;
        this.hero = hero;
        this.front = front;
        this.type = type;
        this.isResetList = isResetList;
        this.rangeType = rangeType;
        this.rangeParam = rangeParam;
        this.targetType = targetType;
        this.targetParam = targetParam;
        this.priorityType = priorityType;
        this.priorityParam = priorityParam;
        this.next = next;
        this.moveLogic = moveLogic;
        this.createPos = createPos;
        this.createParam = createParam;
        this.createCoor = createCoor;
        this.missleSpd = missleSpd;
        this.missleTime = missleTime;
        this.missleType = missleType;
        this.missleSrc = missleSrc;
        this.triggerType = triggerType;
        this.missleEndFrame = missleEndFrame;
        this.boundHit = boundHit;
        this.actOnSelf = actOnSelf;
        this.atkCondition = atkCondition;
        this.atkEff2 = atkEff2;
        this.isKickList = isKickList;
    }

    //#endregion
}
