package com.jx.config.model;

import com.jx.config.loader.AllianceTreasureConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Treasure.xml
*/
public class AllianceTreasureConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**宝藏等级*/
    private final int level;
    /**升下一级所需经验*/
    private final int exp;
    /**宝藏奖励*/
    private final int[][] reward;
    /**开启所需钥匙数量*/
    private final int needKey;

    /**
     * 获取所有配置
     */
    public static List<AllianceTreasureConfig> findAll(){
        return AllianceTreasureConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceTreasureConfig getByKey(int key){
        return AllianceTreasureConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 宝藏等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 升下一级所需经验
     */
    public int getExp() {
        return exp;
    }

    /**
     * 宝藏奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 开启所需钥匙数量
     */
    public int getNeedKey() {
        return needKey;
    }

    //#endregion

    //#region 构造函数

    public AllianceTreasureConfig(int id, int level, int exp, int[][] reward, int needKey){
        this.id = id;
        this.level = level;
        this.exp = exp;
        this.reward = reward;
        this.needKey = needKey;
    }

    //#endregion
}
