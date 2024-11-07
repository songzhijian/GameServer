package com.jx.config.model;

import com.jx.config.loader.ChapterTaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 ChapterTask.xml
*/
public class ChapterTaskConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**任务列表*/
    private final int[] questList;
    /**下一章*/
    private final int nextID;
    /**父任务*/
    private final int parentTask;

    /**
     * 获取所有配置
     */
    public static List<ChapterTaskConfig> findAll(){
        return ChapterTaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ChapterTaskConfig getByKey(int key){
        return ChapterTaskConfigLoader.getByKey(key);
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
     * 下一章
     */
    public int getNextID() {
        return nextID;
    }

    /**
     * 父任务
     */
    public int getParentTask() {
        return parentTask;
    }

    //#endregion

    //#region 构造函数

    public ChapterTaskConfig(int id, int[] questList, int nextID, int parentTask){
        this.id = id;
        this.questList = questList;
        this.nextID = nextID;
        this.parentTask = parentTask;
    }

    //#endregion
}
