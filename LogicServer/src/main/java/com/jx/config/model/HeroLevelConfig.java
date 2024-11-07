package com.jx.config.model;

import com.jx.config.loader.HeroLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Level.xml
*/
public class HeroLevelConfig extends AbstractConfig implements IConfig {

    /**等级*/
    private final int id;
    /**显示等级*/
    private final int displayLevel;
    /**对应Rank*/
    private final int rank;
    /**突破RANK*/
    private final int upRank;
    /**需要Quality*/
    private final int quality;
    /**需要经验*/
    private final int[][] exp;
    /**总经验*/
    private final long expTotal;
    /**总粉尘*/
    private final int dustTotal;
    /**hp*/
    private final float hp;
    /**atk*/
    private final float atk;
    /**def*/
    private final float def;
    /**mdef*/
    private final float mdef;
    /**hpRank*/
    private final float hpRank;
    /**atkRank*/
    private final float atkRank;
    /**defRank*/
    private final float defRank;
    /**mdefRank*/
    private final float mdefRank;

    /**
     * 获取所有配置
     */
    public static List<HeroLevelConfig> findAll(){
        return HeroLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroLevelConfig getByKey(int key){
        return HeroLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 等级
     */
    public int getId() {
        return id;
    }

    /**
     * 显示等级
     */
    public int getDisplayLevel() {
        return displayLevel;
    }

    /**
     * 对应Rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * 突破RANK
     */
    public int getUpRank() {
        return upRank;
    }

    /**
     * 需要Quality
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 需要经验
     */
    public int[][] getExp() {
        return exp;
    }

    /**
     * 总经验
     */
    public long getExpTotal() {
        return expTotal;
    }

    /**
     * 总粉尘
     */
    public int getDustTotal() {
        return dustTotal;
    }

    /**
     * hp
     */
    public float getHp() {
        return hp;
    }

    /**
     * atk
     */
    public float getAtk() {
        return atk;
    }

    /**
     * def
     */
    public float getDef() {
        return def;
    }

    /**
     * mdef
     */
    public float getMdef() {
        return mdef;
    }

    /**
     * hpRank
     */
    public float getHpRank() {
        return hpRank;
    }

    /**
     * atkRank
     */
    public float getAtkRank() {
        return atkRank;
    }

    /**
     * defRank
     */
    public float getDefRank() {
        return defRank;
    }

    /**
     * mdefRank
     */
    public float getMdefRank() {
        return mdefRank;
    }

    //#endregion

    //#region 构造函数

    public HeroLevelConfig(int id, int displayLevel, int rank, int upRank, int quality, int[][] exp, long expTotal, int dustTotal, float hp, float atk, float def, float mdef, float hpRank, float atkRank, float defRank, float mdefRank){
        this.id = id;
        this.displayLevel = displayLevel;
        this.rank = rank;
        this.upRank = upRank;
        this.quality = quality;
        this.exp = exp;
        this.expTotal = expTotal;
        this.dustTotal = dustTotal;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mdef = mdef;
        this.hpRank = hpRank;
        this.atkRank = atkRank;
        this.defRank = defRank;
        this.mdefRank = mdefRank;
    }

    //#endregion
}
