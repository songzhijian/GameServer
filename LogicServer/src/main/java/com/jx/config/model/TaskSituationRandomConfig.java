package com.jx.config.model;

import com.jx.config.loader.TaskSituationRandomConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Task_Situation_Random.xml
*/
public class TaskSituationRandomConfig extends AbstractConfig implements IConfig {

    /**序号*/
    private final int id;
    /**随机前置条件*/
    private final long[][] randomPreconditions;
    /**随机组*/
    private final int[] randomTaskGroup;

    /**
     * 获取所有配置
     */
    public static List<TaskSituationRandomConfig> findAll(){
        return TaskSituationRandomConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TaskSituationRandomConfig getByKey(int key){
        return TaskSituationRandomConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序号
     */
    public int getId() {
        return id;
    }

    /**
     * 随机前置条件
     */
    public long[][] getRandomPreconditions() {
        return randomPreconditions;
    }

    /**
     * 随机组
     */
    public int[] getRandomTaskGroup() {
        return randomTaskGroup;
    }

    //#endregion

    //#region 构造函数

    public TaskSituationRandomConfig(int id, long[][] randomPreconditions, int[] randomTaskGroup){
        this.id = id;
        this.randomPreconditions = randomPreconditions;
        this.randomTaskGroup = randomTaskGroup;
    }

    //#endregion
}
