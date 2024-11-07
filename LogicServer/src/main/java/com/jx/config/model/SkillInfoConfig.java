package com.jx.config.model;

import com.jx.config.loader.SkillInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Skill_Info.xml
*/
public class SkillInfoConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**英雄归属*/
    private final int hero;
    /**技能索引*/
    private final int skillEff;
    /**技能战力*/
    private final int power;

    /**
     * 获取所有配置
     */
    public static List<SkillInfoConfig> findAll(){
        return SkillInfoConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SkillInfoConfig getByKey(int key){
        return SkillInfoConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 英雄归属
     */
    public int getHero() {
        return hero;
    }

    /**
     * 技能索引
     */
    public int getSkillEff() {
        return skillEff;
    }

    /**
     * 技能战力
     */
    public int getPower() {
        return power;
    }

    //#endregion

    //#region 构造函数

    public SkillInfoConfig(int id, int hero, int skillEff, int power){
        this.id = id;
        this.hero = hero;
        this.skillEff = skillEff;
        this.power = power;
    }

    //#endregion
}
