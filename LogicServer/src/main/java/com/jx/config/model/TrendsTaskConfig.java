package com.jx.config.model;

import com.jx.config.loader.TrendsTaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trends_Task.xml
*/
public class TrendsTaskConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**任务*/
    private final int taskType;
    /**任务参数*/
    private final int[] taskValue;

    /**
     * 获取所有配置
     */
    public static List<TrendsTaskConfig> findAll(){
        return TrendsTaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TrendsTaskConfig getByKey(int key){
        return TrendsTaskConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 任务
     */
    public int getTaskType() {
        return taskType;
    }

    /**
     * 任务参数
     */
    public int[] getTaskValue() {
        return taskValue;
    }

    //#endregion

    //#region 构造函数

    public TrendsTaskConfig(int id, int taskType, int[] taskValue){
        this.id = id;
        this.taskType = taskType;
        this.taskValue = taskValue;
    }

    //#endregion
}
