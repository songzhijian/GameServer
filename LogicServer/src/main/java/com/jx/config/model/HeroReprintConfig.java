package com.jx.config.model;

import com.jx.config.loader.HeroReprintConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Reprint.xml
*/
public class HeroReprintConfig extends AbstractConfig implements IConfig {

    /**重印信息id*/
    private final int id;
    /**归属英雄*/
    private final int hero;
    /**解锁赛季*/
    private final int unlockSeason;
    /**资质条件*/
    private final int unlockCon;
    /**消耗*/
    private final int[] cost;

    /**
     * 获取所有配置
     */
    public static List<HeroReprintConfig> findAll(){
        return HeroReprintConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroReprintConfig getByKey(int key){
        return HeroReprintConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 重印信息id
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
     * 解锁赛季
     */
    public int getUnlockSeason() {
        return unlockSeason;
    }

    /**
     * 资质条件
     */
    public int getUnlockCon() {
        return unlockCon;
    }

    /**
     * 消耗
     */
    public int[] getCost() {
        return cost;
    }

    //#endregion

    //#region 构造函数

    public HeroReprintConfig(int id, int hero, int unlockSeason, int unlockCon, int[] cost){
        this.id = id;
        this.hero = hero;
        this.unlockSeason = unlockSeason;
        this.unlockCon = unlockCon;
        this.cost = cost;
    }

    //#endregion
}
