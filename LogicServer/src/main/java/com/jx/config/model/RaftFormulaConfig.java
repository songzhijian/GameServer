package com.jx.config.model;

import com.jx.config.loader.RaftFormulaConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Raft_Formula.xml
*/
public class RaftFormulaConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**<原材料需求>*/
    private final int[][] cost;
    /**<产品>*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<RaftFormulaConfig> findAll(){
        return RaftFormulaConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RaftFormulaConfig getByKey(int key){
        return RaftFormulaConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * <原材料需求>
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * <产品>
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public RaftFormulaConfig(int id, int[][] cost, int[][] reward){
        this.id = id;
        this.cost = cost;
        this.reward = reward;
    }

    //#endregion
}
