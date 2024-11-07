package com.jx.config.model;

import com.jx.config.loader.StrikePirateEnemyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Strike_Pirate_Enemy.xml
*/
public class StrikePirateEnemyConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**对应StageBattle的id*/
    private final int stageBattle;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<StrikePirateEnemyConfig> findAll(){
        return StrikePirateEnemyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StrikePirateEnemyConfig getByKey(int key){
        return StrikePirateEnemyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 对应StageBattle的id
     */
    public int getStageBattle() {
        return stageBattle;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public StrikePirateEnemyConfig(int id, int stageBattle, int[][] reward){
        this.id = id;
        this.stageBattle = stageBattle;
        this.reward = reward;
    }

    //#endregion
}
