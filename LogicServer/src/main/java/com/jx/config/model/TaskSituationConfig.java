package com.jx.config.model;

import com.jx.config.loader.TaskSituationConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Task_Situation.xml
*/
public class TaskSituationConfig extends AbstractConfig implements IConfig {

    /**序号*/
    private final int id;
    /**随机条件*/
    private final int[][] random;
    /**完成条件*/
    private final int[][] complete;
    /**接取消耗*/
    private final int[][] receiveCost;
    /**立即完成消耗*/
    private final int[][] completeCost;

    /**
     * 获取所有配置
     */
    public static List<TaskSituationConfig> findAll(){
        return TaskSituationConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TaskSituationConfig getByKey(int key){
        return TaskSituationConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序号
     */
    public int getId() {
        return id;
    }

    /**
     * 随机条件
     */
    public int[][] getRandom() {
        return random;
    }

    /**
     * 完成条件
     */
    public int[][] getComplete() {
        return complete;
    }

    /**
     * 接取消耗
     */
    public int[][] getReceiveCost() {
        return receiveCost;
    }

    /**
     * 立即完成消耗
     */
    public int[][] getCompleteCost() {
        return completeCost;
    }

    //#endregion

    //#region 构造函数

    public TaskSituationConfig(int id, int[][] random, int[][] complete, int[][] receiveCost, int[][] completeCost){
        this.id = id;
        this.random = random;
        this.complete = complete;
        this.receiveCost = receiveCost;
        this.completeCost = completeCost;
    }

    //#endregion
}
