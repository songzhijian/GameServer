package com.jx.config.model;

import com.jx.config.loader.HeroQualityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Quality.xml
*/
public class HeroQualityConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**种族积分*/
    private final int credits;
    /**种族积分*/
    private final int[][] wordlessBookPower;
    /**coef*/
    private final float coef;
    /**hpAdd*/
    private final float hpAdd;
    /**atkAdd*/
    private final float atkAdd;
    /**defAdd*/
    private final float defAdd;
    /**mdefAdd*/
    private final float mdefAdd;
    /**对应等级*/
    private final int level;
    /**能否突破等级上限*/
    private final int canExceedLv;
    /**合成【下四族】[类别,资质,数量]*/
    private final int[] need1;
    /**多少本卡*/
    private final int same;
    /**多少蓝卡*/
    private final int science;
    /**合成【上三族】*/
    private final int[] need2;
    /**多少本卡*/
    private final int same2;

    /**
     * 获取所有配置
     */
    public static List<HeroQualityConfig> findAll(){
        return HeroQualityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroQualityConfig getByKey(int key){
        return HeroQualityConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 种族积分
     */
    public int getCredits() {
        return credits;
    }

    /**
     * 种族积分
     */
    public int[][] getWordlessBookPower() {
        return wordlessBookPower;
    }

    /**
     * coef
     */
    public float getCoef() {
        return coef;
    }

    /**
     * hpAdd
     */
    public float getHpAdd() {
        return hpAdd;
    }

    /**
     * atkAdd
     */
    public float getAtkAdd() {
        return atkAdd;
    }

    /**
     * defAdd
     */
    public float getDefAdd() {
        return defAdd;
    }

    /**
     * mdefAdd
     */
    public float getMdefAdd() {
        return mdefAdd;
    }

    /**
     * 对应等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 能否突破等级上限
     */
    public int getCanExceedLv() {
        return canExceedLv;
    }

    /**
     * 合成【下四族】[类别,资质,数量]
     */
    public int[] getNeed1() {
        return need1;
    }

    /**
     * 多少本卡
     */
    public int getSame() {
        return same;
    }

    /**
     * 多少蓝卡
     */
    public int getScience() {
        return science;
    }

    /**
     * 合成【上三族】
     */
    public int[] getNeed2() {
        return need2;
    }

    /**
     * 多少本卡
     */
    public int getSame2() {
        return same2;
    }

    //#endregion

    //#region 构造函数

    public HeroQualityConfig(int id, int credits, int[][] wordlessBookPower, float coef, float hpAdd, float atkAdd, float defAdd, float mdefAdd, int level, int canExceedLv, int[] need1, int same, int science, int[] need2, int same2){
        this.id = id;
        this.credits = credits;
        this.wordlessBookPower = wordlessBookPower;
        this.coef = coef;
        this.hpAdd = hpAdd;
        this.atkAdd = atkAdd;
        this.defAdd = defAdd;
        this.mdefAdd = mdefAdd;
        this.level = level;
        this.canExceedLv = canExceedLv;
        this.need1 = need1;
        this.same = same;
        this.science = science;
        this.need2 = need2;
        this.same2 = same2;
    }

    //#endregion
}
