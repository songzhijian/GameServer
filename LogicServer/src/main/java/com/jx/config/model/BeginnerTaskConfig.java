package com.jx.config.model;

import com.jx.config.loader.BeginnerTaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 BeginnerTask.xml
*/
public class BeginnerTaskConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**任务列表*/
    private final int[] questList;
    /**下一幕*/
    private final int nextID;

    /**
     * 获取所有配置
     */
    public static List<BeginnerTaskConfig> findAll(){
        return BeginnerTaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BeginnerTaskConfig getByKey(int key){
        return BeginnerTaskConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 任务列表
     */
    public int[] getQuestList() {
        return questList;
    }

    /**
     * 下一幕
     */
    public int getNextID() {
        return nextID;
    }

    //#endregion

    //#region 构造函数

    public BeginnerTaskConfig(int id, int[] questList, int nextID){
        this.id = id;
        this.questList = questList;
        this.nextID = nextID;
    }

    //#endregion
}
