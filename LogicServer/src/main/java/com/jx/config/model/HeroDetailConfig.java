package com.jx.config.model;

import com.jx.config.loader.HeroDetailConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Detail.xml
*/
public class HeroDetailConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**是否可用*/
    private final int canUse;
    /**是否在系统佣兵中*/
    private final int canMercenary;
    /**图鉴奖励*/
    private final int[][] handbookReward;
    /**继承属性系数(不配置默认100%)*/
    private final int[][] inheritAtt;
    /**初始品质*/
    private final int initQuality;
    /**品质上限*/
    private final int qualityLimit;
    /**等级上限*/
    private final int levelLimit;
    /**抽卡中是否触发cheat*/
    private final boolean triggerCheat;
    /**阵营*/
    private final int race;
    /**男女*/
    private final int male;
    /**近程远程*/
    private final int range;
    /**属性类型*/
    private final int type;
    /**职业*/
    private final int role;
    /**普攻*/
    private final int[][] normalAtk;
    /**技能1*/
    private final int[][] skill1;
    /**技能2*/
    private final int[][] skill2;
    /**技能3*/
    private final int[][] skill3;
    /**技能4*/
    private final int[][] skill4;
    /**hpBase*/
    private final float hpBase;
    /**atkBase*/
    private final float atkBase;
    /**defBase*/
    private final float defBase;
    /**mdefBase*/
    private final float mdefBase;
    /**hpCoef*/
    private final float hpCoef;
    /**atkCoef*/
    private final float atkCoef;
    /**defCoef*/
    private final float defCoef;
    /**mdefCoef*/
    private final float mdefCoef;
    /**天赋数量【空=0=没有天赋，2=就2个天赋，4=4个天赋】*/
    private final int TalentCount;
    /**特长id*/
    private final int Speciality;
    /**位置1解锁条件[quality]*/
    private final int talent1unlock;
    /**位置2解锁条件[quality]*/
    private final int talent2unlock;
    /**位置3解锁条件[quality]*/
    private final int talent3unlock;
    /**位置4解锁条件[quality]*/
    private final int talent4unlock;
    /**天赋随机包*/
    private final int talentRandomGroup;
    /**重印信息【空=0=无重印，填写则填ID】*/
    private final int[] reprint;
    /**重印后必杀id*/
    private final int[] reprintUltra;
    /**是否具备专属[空=0=不具有，填写id=有]*/
    private final int exclusive;

    /**
     * 获取所有配置
     */
    public static List<HeroDetailConfig> findAll(){
        return HeroDetailConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroDetailConfig getByKey(int key){
        return HeroDetailConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 是否可用
     */
    public int getCanUse() {
        return canUse;
    }

    /**
     * 是否在系统佣兵中
     */
    public int getCanMercenary() {
        return canMercenary;
    }

    /**
     * 图鉴奖励
     */
    public int[][] getHandbookReward() {
        return handbookReward;
    }

    /**
     * 继承属性系数(不配置默认100%)
     */
    public int[][] getInheritAtt() {
        return inheritAtt;
    }

    /**
     * 初始品质
     */
    public int getInitQuality() {
        return initQuality;
    }

    /**
     * 品质上限
     */
    public int getQualityLimit() {
        return qualityLimit;
    }

    /**
     * 等级上限
     */
    public int getLevelLimit() {
        return levelLimit;
    }

    /**
     * 抽卡中是否触发cheat
     */
    public boolean isTriggerCheat() {
        return triggerCheat;
    }

    /**
     * 阵营
     */
    public int getRace() {
        return race;
    }

    /**
     * 男女
     */
    public int getMale() {
        return male;
    }

    /**
     * 近程远程
     */
    public int getRange() {
        return range;
    }

    /**
     * 属性类型
     */
    public int getType() {
        return type;
    }

    /**
     * 职业
     */
    public int getRole() {
        return role;
    }

    /**
     * 普攻
     */
    public int[][] getNormalAtk() {
        return normalAtk;
    }

    /**
     * 技能1
     */
    public int[][] getSkill1() {
        return skill1;
    }

    /**
     * 技能2
     */
    public int[][] getSkill2() {
        return skill2;
    }

    /**
     * 技能3
     */
    public int[][] getSkill3() {
        return skill3;
    }

    /**
     * 技能4
     */
    public int[][] getSkill4() {
        return skill4;
    }

    /**
     * hpBase
     */
    public float getHpBase() {
        return hpBase;
    }

    /**
     * atkBase
     */
    public float getAtkBase() {
        return atkBase;
    }

    /**
     * defBase
     */
    public float getDefBase() {
        return defBase;
    }

    /**
     * mdefBase
     */
    public float getMdefBase() {
        return mdefBase;
    }

    /**
     * hpCoef
     */
    public float getHpCoef() {
        return hpCoef;
    }

    /**
     * atkCoef
     */
    public float getAtkCoef() {
        return atkCoef;
    }

    /**
     * defCoef
     */
    public float getDefCoef() {
        return defCoef;
    }

    /**
     * mdefCoef
     */
    public float getMdefCoef() {
        return mdefCoef;
    }

    /**
     * 天赋数量【空=0=没有天赋，2=就2个天赋，4=4个天赋】
     */
    public int getTalentCount() {
        return TalentCount;
    }

    /**
     * 特长id
     */
    public int getSpeciality() {
        return Speciality;
    }

    /**
     * 位置1解锁条件[quality]
     */
    public int getTalent1unlock() {
        return talent1unlock;
    }

    /**
     * 位置2解锁条件[quality]
     */
    public int getTalent2unlock() {
        return talent2unlock;
    }

    /**
     * 位置3解锁条件[quality]
     */
    public int getTalent3unlock() {
        return talent3unlock;
    }

    /**
     * 位置4解锁条件[quality]
     */
    public int getTalent4unlock() {
        return talent4unlock;
    }

    /**
     * 天赋随机包
     */
    public int getTalentRandomGroup() {
        return talentRandomGroup;
    }

    /**
     * 重印信息【空=0=无重印，填写则填ID】
     */
    public int[] getReprint() {
        return reprint;
    }

    /**
     * 重印后必杀id
     */
    public int[] getReprintUltra() {
        return reprintUltra;
    }

    /**
     * 是否具备专属[空=0=不具有，填写id=有]
     */
    public int getExclusive() {
        return exclusive;
    }

    //#endregion

    //#region 构造函数

    public HeroDetailConfig(int id, int canUse, int canMercenary, int[][] handbookReward, int[][] inheritAtt, int initQuality, int qualityLimit, int levelLimit, boolean triggerCheat, int race, int male, int range, int type, int role, int[][] normalAtk, int[][] skill1, int[][] skill2, int[][] skill3, int[][] skill4, float hpBase, float atkBase, float defBase, float mdefBase, float hpCoef, float atkCoef, float defCoef, float mdefCoef, int TalentCount, int Speciality, int talent1unlock, int talent2unlock, int talent3unlock, int talent4unlock, int talentRandomGroup, int[] reprint, int[] reprintUltra, int exclusive){
        this.id = id;
        this.canUse = canUse;
        this.canMercenary = canMercenary;
        this.handbookReward = handbookReward;
        this.inheritAtt = inheritAtt;
        this.initQuality = initQuality;
        this.qualityLimit = qualityLimit;
        this.levelLimit = levelLimit;
        this.triggerCheat = triggerCheat;
        this.race = race;
        this.male = male;
        this.range = range;
        this.type = type;
        this.role = role;
        this.normalAtk = normalAtk;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.hpBase = hpBase;
        this.atkBase = atkBase;
        this.defBase = defBase;
        this.mdefBase = mdefBase;
        this.hpCoef = hpCoef;
        this.atkCoef = atkCoef;
        this.defCoef = defCoef;
        this.mdefCoef = mdefCoef;
        this.TalentCount = TalentCount;
        this.Speciality = Speciality;
        this.talent1unlock = talent1unlock;
        this.talent2unlock = talent2unlock;
        this.talent3unlock = talent3unlock;
        this.talent4unlock = talent4unlock;
        this.talentRandomGroup = talentRandomGroup;
        this.reprint = reprint;
        this.reprintUltra = reprintUltra;
        this.exclusive = exclusive;
    }

    //#endregion
}
