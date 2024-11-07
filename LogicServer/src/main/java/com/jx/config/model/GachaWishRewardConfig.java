package com.jx.config.model;

import com.jx.config.loader.GachaWishRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Gacha_Wish_Reward.xml
*/
public class GachaWishRewardConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**阶段1心愿能量消耗*/
    private final int cost1;
    /**阶段1心愿奖励*/
    private final int[][] reward1;
    /**阶段2心愿能量消耗*/
    private final int cost2;
    /**阶段2心愿奖励*/
    private final int[][] reward2;
    /**阶段3心愿能量消耗*/
    private final int cost3;
    /**阶段3心愿奖励*/
    private final int[][] reward3;
    /**阶段4心愿能量消耗*/
    private final int cost4;
    /**阶段4心愿奖励*/
    private final int[][] reward4;

    /**
     * 获取所有配置
     */
    public static List<GachaWishRewardConfig> findAll(){
        return GachaWishRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GachaWishRewardConfig getByKey(int key){
        return GachaWishRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 阶段1心愿能量消耗
     */
    public int getCost1() {
        return cost1;
    }

    /**
     * 阶段1心愿奖励
     */
    public int[][] getReward1() {
        return reward1;
    }

    /**
     * 阶段2心愿能量消耗
     */
    public int getCost2() {
        return cost2;
    }

    /**
     * 阶段2心愿奖励
     */
    public int[][] getReward2() {
        return reward2;
    }

    /**
     * 阶段3心愿能量消耗
     */
    public int getCost3() {
        return cost3;
    }

    /**
     * 阶段3心愿奖励
     */
    public int[][] getReward3() {
        return reward3;
    }

    /**
     * 阶段4心愿能量消耗
     */
    public int getCost4() {
        return cost4;
    }

    /**
     * 阶段4心愿奖励
     */
    public int[][] getReward4() {
        return reward4;
    }

    //#endregion

    //#region 构造函数

    public GachaWishRewardConfig(int id, int cost1, int[][] reward1, int cost2, int[][] reward2, int cost3, int[][] reward3, int cost4, int[][] reward4){
        this.id = id;
        this.cost1 = cost1;
        this.reward1 = reward1;
        this.cost2 = cost2;
        this.reward2 = reward2;
        this.cost3 = cost3;
        this.reward3 = reward3;
        this.cost4 = cost4;
        this.reward4 = reward4;
    }

    //#endregion
}
