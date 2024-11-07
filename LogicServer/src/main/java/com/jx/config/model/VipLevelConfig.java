package com.jx.config.model;

import com.jx.config.loader.VipLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Vip_Level.xml
*/
public class VipLevelConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int lvl;
    /**赛季解锁*/
    private final int season;
    /**升级经验*/
    private final int exp;
    /**每日领取奖励*/
    private final int[][] dailyReward;
    /**VIP礼包*/
    private final int vipBonus;
    /**增益列表*/
    private final int[] worldBuff;
    /**商店等级*/
    private final int shopLvl;

    /**
     * 获取所有配置
     */
    public static List<VipLevelConfig> findAll(){
        return VipLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static VipLevelConfig getByKey(int key){
        return VipLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * 赛季解锁
     */
    public int getSeason() {
        return season;
    }

    /**
     * 升级经验
     */
    public int getExp() {
        return exp;
    }

    /**
     * 每日领取奖励
     */
    public int[][] getDailyReward() {
        return dailyReward;
    }

    /**
     * VIP礼包
     */
    public int getVipBonus() {
        return vipBonus;
    }

    /**
     * 增益列表
     */
    public int[] getWorldBuff() {
        return worldBuff;
    }

    /**
     * 商店等级
     */
    public int getShopLvl() {
        return shopLvl;
    }

    //#endregion

    //#region 构造函数

    public VipLevelConfig(int lvl, int season, int exp, int[][] dailyReward, int vipBonus, int[] worldBuff, int shopLvl){
        this.lvl = lvl;
        this.season = season;
        this.exp = exp;
        this.dailyReward = dailyReward;
        this.vipBonus = vipBonus;
        this.worldBuff = worldBuff;
        this.shopLvl = shopLvl;
    }

    //#endregion
}
