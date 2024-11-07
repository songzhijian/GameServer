package com.jx.config.model;

import com.jx.config.loader.HeroNauticsSkillConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Nautics_Skill.xml
*/
public class HeroNauticsSkillConfig extends AbstractConfig implements IConfig {

    /**航海技能id*/
    private final int id;
    /**品质*/
    private final int quality;
    /**生效职业*/
    private final int role;
    /**主动技能效果*/
    private final int[][] eff;
    /**被动技能效果*/
    private final int[][] passiveEff;

    /**
     * 获取所有配置
     */
    public static List<HeroNauticsSkillConfig> findAll(){
        return HeroNauticsSkillConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroNauticsSkillConfig getByKey(int key){
        return HeroNauticsSkillConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 航海技能id
     */
    public int getId() {
        return id;
    }

    /**
     * 品质
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 生效职业
     */
    public int getRole() {
        return role;
    }

    /**
     * 主动技能效果
     */
    public int[][] getEff() {
        return eff;
    }

    /**
     * 被动技能效果
     */
    public int[][] getPassiveEff() {
        return passiveEff;
    }

    //#endregion

    //#region 构造函数

    public HeroNauticsSkillConfig(int id, int quality, int role, int[][] eff, int[][] passiveEff){
        this.id = id;
        this.quality = quality;
        this.role = role;
        this.eff = eff;
        this.passiveEff = passiveEff;
    }

    //#endregion
}
