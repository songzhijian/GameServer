package com.jx.config.model;

import com.jx.config.loader.MazeLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Level.xml
*/
public class MazeLevelConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**贤者之石等级上限*/
    private final int rank;
    /**地图库id*/
    private final int[] mapLib;
    /**额外英雄库*/
    private final int[] heroLib;
    /**遗物库*/
    private final int[] relicLib;
    /**交易库*/
    private final int[] tradeLib;
    /**房间1通关奖励*/
    private final int[][] passReward1;
    /**房间2通关奖励*/
    private final int[][] passReward2;
    /**房间3通关奖励*/
    private final int[][] passReward3;

    /**
     * 获取所有配置
     */
    public static List<MazeLevelConfig> findAll(){
        return MazeLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeLevelConfig getByKey(int key){
        return MazeLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 贤者之石等级上限
     */
    public int getRank() {
        return rank;
    }

    /**
     * 地图库id
     */
    public int[] getMapLib() {
        return mapLib;
    }

    /**
     * 额外英雄库
     */
    public int[] getHeroLib() {
        return heroLib;
    }

    /**
     * 遗物库
     */
    public int[] getRelicLib() {
        return relicLib;
    }

    /**
     * 交易库
     */
    public int[] getTradeLib() {
        return tradeLib;
    }

    /**
     * 房间1通关奖励
     */
    public int[][] getPassReward1() {
        return passReward1;
    }

    /**
     * 房间2通关奖励
     */
    public int[][] getPassReward2() {
        return passReward2;
    }

    /**
     * 房间3通关奖励
     */
    public int[][] getPassReward3() {
        return passReward3;
    }

    //#endregion

    //#region 构造函数

    public MazeLevelConfig(int id, int rank, int[] mapLib, int[] heroLib, int[] relicLib, int[] tradeLib, int[][] passReward1, int[][] passReward2, int[][] passReward3){
        this.id = id;
        this.rank = rank;
        this.mapLib = mapLib;
        this.heroLib = heroLib;
        this.relicLib = relicLib;
        this.tradeLib = tradeLib;
        this.passReward1 = passReward1;
        this.passReward2 = passReward2;
        this.passReward3 = passReward3;
    }

    //#endregion
}
