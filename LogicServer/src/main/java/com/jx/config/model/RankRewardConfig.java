package com.jx.config.model;

import com.jx.config.loader.RankRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Rank_Reward.xml
*/
public class RankRewardConfig extends AbstractConfig implements IConfig {

    /**排行奖励id*/
    private final int id;
    /**名次下限*/
    private final int downLimit;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<RankRewardConfig> findAll(){
        return RankRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RankRewardConfig getByKey(int key){
        return RankRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 排行奖励id
     */
    public int getId() {
        return id;
    }

    /**
     * 名次下限
     */
    public int getDownLimit() {
        return downLimit;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public RankRewardConfig(int id, int downLimit, int[][] reward){
        this.id = id;
        this.downLimit = downLimit;
        this.reward = reward;
    }

    //#endregion
}
