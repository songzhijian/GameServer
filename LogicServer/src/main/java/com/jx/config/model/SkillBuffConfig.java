package com.jx.config.model;

import com.jx.config.loader.SkillBuffConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Skill_Buff.xml
*/
public class SkillBuffConfig extends AbstractConfig implements IConfig {

    /**buff索引*/
    private final String buffId;
    /**瞬时类型*/
    private final int timeType;
    /**buff归属类型标签*/
    private final int type;
    /**增益减益类型*/
    private final int label;
    /**无视免疫状态*/
    private final int unstoppable;
    /**赋予概率*/
    private final float p;
    /**受击加怒气*/
    private final int addPower;
    /**持续时间*/
    private final int[] time;
    /**叠加规则*/
    private final int overlayType;
    /**max层数*/
    private final int maxLayer;
    /**满层转化*/
    private final int transform;
    /**效果*/
    private final float[][] eff;
    /**调用技能参数*/
    private final int[] cited;
    /**图标*/
    private final String icon;
    /**描述*/
    private final int description;

    /**
     * 获取所有配置
     */
    public static List<SkillBuffConfig> findAll(){
        return SkillBuffConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SkillBuffConfig getByKey(String key){
        return SkillBuffConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * buff索引
     */
    public String getBuffId() {
        return buffId;
    }

    /**
     * 瞬时类型
     */
    public int getTimeType() {
        return timeType;
    }

    /**
     * buff归属类型标签
     */
    public int getType() {
        return type;
    }

    /**
     * 增益减益类型
     */
    public int getLabel() {
        return label;
    }

    /**
     * 无视免疫状态
     */
    public int getUnstoppable() {
        return unstoppable;
    }

    /**
     * 赋予概率
     */
    public float getP() {
        return p;
    }

    /**
     * 受击加怒气
     */
    public int getAddPower() {
        return addPower;
    }

    /**
     * 持续时间
     */
    public int[] getTime() {
        return time;
    }

    /**
     * 叠加规则
     */
    public int getOverlayType() {
        return overlayType;
    }

    /**
     * max层数
     */
    public int getMaxLayer() {
        return maxLayer;
    }

    /**
     * 满层转化
     */
    public int getTransform() {
        return transform;
    }

    /**
     * 效果
     */
    public float[][] getEff() {
        return eff;
    }

    /**
     * 调用技能参数
     */
    public int[] getCited() {
        return cited;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 描述
     */
    public int getDescription() {
        return description;
    }

    //#endregion

    //#region 构造函数

    public SkillBuffConfig(String buffId, int timeType, int type, int label, int unstoppable, float p, int addPower, int[] time, int overlayType, int maxLayer, int transform, float[][] eff, int[] cited, String icon, int description){
        this.buffId = buffId;
        this.timeType = timeType;
        this.type = type;
        this.label = label;
        this.unstoppable = unstoppable;
        this.p = p;
        this.addPower = addPower;
        this.time = time;
        this.overlayType = overlayType;
        this.maxLayer = maxLayer;
        this.transform = transform;
        this.eff = eff;
        this.cited = cited;
        this.icon = icon;
        this.description = description;
    }

    //#endregion
}
