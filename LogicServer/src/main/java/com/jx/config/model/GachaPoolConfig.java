package com.jx.config.model;

import com.jx.config.loader.GachaPoolConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Gacha_Pool.xml
*/
public class GachaPoolConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**抽卡类型*/
    private final int pool;
    /**是否被循环调用*/
    private final int isRecycle;
    /**卡池保底作弊*/
    private final int[][] fixCheatByPoolId;
    /**大保底作弊*/
    private final int[][] cheatRPPool;
    /**概率=选出race/填写方法：[左闭区间值,右开区间值,RandomGroup]*/
    private final int[][] race;
    /**作弊记录*/
    private final int cheatMark;
    /**4绿作弊*/
    private final int cheat4Green;
    /**作弊卡池*/
    private final int cheatGBPool;

    /**
     * 获取所有配置
     */
    public static List<GachaPoolConfig> findAll(){
        return GachaPoolConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GachaPoolConfig getByKey(int key){
        return GachaPoolConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 抽卡类型
     */
    public int getPool() {
        return pool;
    }

    /**
     * 是否被循环调用
     */
    public int getIsRecycle() {
        return isRecycle;
    }

    /**
     * 卡池保底作弊
     */
    public int[][] getFixCheatByPoolId() {
        return fixCheatByPoolId;
    }

    /**
     * 大保底作弊
     */
    public int[][] getCheatRPPool() {
        return cheatRPPool;
    }

    /**
     * 概率=选出race/填写方法：[左闭区间值,右开区间值,RandomGroup]
     */
    public int[][] getRace() {
        return race;
    }

    /**
     * 作弊记录
     */
    public int getCheatMark() {
        return cheatMark;
    }

    /**
     * 4绿作弊
     */
    public int getCheat4Green() {
        return cheat4Green;
    }

    /**
     * 作弊卡池
     */
    public int getCheatGBPool() {
        return cheatGBPool;
    }

    //#endregion

    //#region 构造函数

    public GachaPoolConfig(int id, int pool, int isRecycle, int[][] fixCheatByPoolId, int[][] cheatRPPool, int[][] race, int cheatMark, int cheat4Green, int cheatGBPool){
        this.id = id;
        this.pool = pool;
        this.isRecycle = isRecycle;
        this.fixCheatByPoolId = fixCheatByPoolId;
        this.cheatRPPool = cheatRPPool;
        this.race = race;
        this.cheatMark = cheatMark;
        this.cheat4Green = cheat4Green;
        this.cheatGBPool = cheatGBPool;
    }

    //#endregion
}
