package com.jx.config.model;

import com.jx.config.loader.SkillPassiveConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Skill_Passive.xml
*/
public class SkillPassiveConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**触发时点*/
    private final int[] triggerTime;
    /**触发条件*/
    private final int[] triggerCon;
    /**不满足条件逻辑*/
    private final int triggerLogicFalse;
    /**触发次数上限*/
    private final int triggerLimit;
    /**触发时播放美术效果*/
    private final String src;
    /**触发时播放音效*/
    private final String sound;
    /**触发时播放配音*/
    private final String cast;
    /**触发时播放动作*/
    private final String ani;
    /**触发时触发技能逻辑*/
    private final int triggerSkill;
    /**触发buff效果[仅限对自己]*/
    private final String[] triggerBuff;
    /**不满足条件时触发技能逻辑*/
    private final int triggerSkillFalse;
    /**不满足条件时触发buff效果[仅限对自己]*/
    private final String[] triggerBuffFalse;

    /**
     * 获取所有配置
     */
    public static List<SkillPassiveConfig> findAll(){
        return SkillPassiveConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SkillPassiveConfig getByKey(int key){
        return SkillPassiveConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 触发时点
     */
    public int[] getTriggerTime() {
        return triggerTime;
    }

    /**
     * 触发条件
     */
    public int[] getTriggerCon() {
        return triggerCon;
    }

    /**
     * 不满足条件逻辑
     */
    public int getTriggerLogicFalse() {
        return triggerLogicFalse;
    }

    /**
     * 触发次数上限
     */
    public int getTriggerLimit() {
        return triggerLimit;
    }

    /**
     * 触发时播放美术效果
     */
    public String getSrc() {
        return src;
    }

    /**
     * 触发时播放音效
     */
    public String getSound() {
        return sound;
    }

    /**
     * 触发时播放配音
     */
    public String getCast() {
        return cast;
    }

    /**
     * 触发时播放动作
     */
    public String getAni() {
        return ani;
    }

    /**
     * 触发时触发技能逻辑
     */
    public int getTriggerSkill() {
        return triggerSkill;
    }

    /**
     * 触发buff效果[仅限对自己]
     */
    public String[] getTriggerBuff() {
        return triggerBuff;
    }

    /**
     * 不满足条件时触发技能逻辑
     */
    public int getTriggerSkillFalse() {
        return triggerSkillFalse;
    }

    /**
     * 不满足条件时触发buff效果[仅限对自己]
     */
    public String[] getTriggerBuffFalse() {
        return triggerBuffFalse;
    }

    //#endregion

    //#region 构造函数

    public SkillPassiveConfig(int id, int[] triggerTime, int[] triggerCon, int triggerLogicFalse, int triggerLimit, String src, String sound, String cast, String ani, int triggerSkill, String[] triggerBuff, int triggerSkillFalse, String[] triggerBuffFalse){
        this.id = id;
        this.triggerTime = triggerTime;
        this.triggerCon = triggerCon;
        this.triggerLogicFalse = triggerLogicFalse;
        this.triggerLimit = triggerLimit;
        this.src = src;
        this.sound = sound;
        this.cast = cast;
        this.ani = ani;
        this.triggerSkill = triggerSkill;
        this.triggerBuff = triggerBuff;
        this.triggerSkillFalse = triggerSkillFalse;
        this.triggerBuffFalse = triggerBuffFalse;
    }

    //#endregion
}
