package com.jx.config.model;

import com.jx.config.loader.NewbiesPointsEnemyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Newbies_Points_Enemy.xml
*/
public class NewbiesPointsEnemyConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**对应StageBattle的id*/
    private final int stageBattle;
    /**奖励*/
    private final int[][] reward;
    /**战斗失败后传送位置*/
    private final int[] transferLocation;

    /**
     * 获取所有配置
     */
    public static List<NewbiesPointsEnemyConfig> findAll(){
        return NewbiesPointsEnemyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static NewbiesPointsEnemyConfig getByKey(int key){
        return NewbiesPointsEnemyConfigLoader.getByKey(key);
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

    /**
     * 战斗失败后传送位置
     */
    public int[] getTransferLocation() {
        return transferLocation;
    }

    //#endregion

    //#region 构造函数

    public NewbiesPointsEnemyConfig(int id, int stageBattle, int[][] reward, int[] transferLocation){
        this.id = id;
        this.stageBattle = stageBattle;
        this.reward = reward;
        this.transferLocation = transferLocation;
    }

    //#endregion
}
