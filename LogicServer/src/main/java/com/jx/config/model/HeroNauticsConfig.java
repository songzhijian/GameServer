package com.jx.config.model;

import com.jx.config.loader.HeroNauticsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Nautics.xml
*/
public class HeroNauticsConfig extends AbstractConfig implements IConfig {

    /**英雄id【英雄id都要填写】*/
    private final int id;
    /**是否有航海术*/
    private final int nautics;
    /**航海术位置1*/
    private final int role1;
    /**航海术效果1*/
    private final int[][] eff1;
    /**航海术位置2*/
    private final int role2;
    /**航海术效果2*/
    private final int[][] eff2;
    /**航海术位置3*/
    private final int role3;
    /**航海术效果3*/
    private final int[][] eff3;
    /**航海技能1*/
    private final int[][] nauticsSkill1;
    /**航海技能2*/
    private final int[][] nauticsSkill2;
    /**航海装备数量*/
    private final int equipCount;

    /**
     * 获取所有配置
     */
    public static List<HeroNauticsConfig> findAll(){
        return HeroNauticsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroNauticsConfig getByKey(int key){
        return HeroNauticsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 英雄id【英雄id都要填写】
     */
    public int getId() {
        return id;
    }

    /**
     * 是否有航海术
     */
    public int getNautics() {
        return nautics;
    }

    /**
     * 航海术位置1
     */
    public int getRole1() {
        return role1;
    }

    /**
     * 航海术效果1
     */
    public int[][] getEff1() {
        return eff1;
    }

    /**
     * 航海术位置2
     */
    public int getRole2() {
        return role2;
    }

    /**
     * 航海术效果2
     */
    public int[][] getEff2() {
        return eff2;
    }

    /**
     * 航海术位置3
     */
    public int getRole3() {
        return role3;
    }

    /**
     * 航海术效果3
     */
    public int[][] getEff3() {
        return eff3;
    }

    /**
     * 航海技能1
     */
    public int[][] getNauticsSkill1() {
        return nauticsSkill1;
    }

    /**
     * 航海技能2
     */
    public int[][] getNauticsSkill2() {
        return nauticsSkill2;
    }

    /**
     * 航海装备数量
     */
    public int getEquipCount() {
        return equipCount;
    }

    //#endregion

    //#region 构造函数

    public HeroNauticsConfig(int id, int nautics, int role1, int[][] eff1, int role2, int[][] eff2, int role3, int[][] eff3, int[][] nauticsSkill1, int[][] nauticsSkill2, int equipCount){
        this.id = id;
        this.nautics = nautics;
        this.role1 = role1;
        this.eff1 = eff1;
        this.role2 = role2;
        this.eff2 = eff2;
        this.role3 = role3;
        this.eff3 = eff3;
        this.nauticsSkill1 = nauticsSkill1;
        this.nauticsSkill2 = nauticsSkill2;
        this.equipCount = equipCount;
    }

    //#endregion
}
