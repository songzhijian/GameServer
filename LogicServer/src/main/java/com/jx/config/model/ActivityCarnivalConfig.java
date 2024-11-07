package com.jx.config.model;

import com.jx.config.loader.ActivityCarnivalConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Activity_Carnival.xml
*/
public class ActivityCarnivalConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**天数*/
    private final int dayNum;
    /**免费奖励*/
    private final int[][] freeReward;
    /**任务列表*/
    private final int[] taskList;
    /**商品列表*/
    private final int[] productList;

    /**
     * 获取所有配置
     */
    public static List<ActivityCarnivalConfig> findAll(){
        return ActivityCarnivalConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ActivityCarnivalConfig getByKey(int key){
        return ActivityCarnivalConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 天数
     */
    public int getDayNum() {
        return dayNum;
    }

    /**
     * 免费奖励
     */
    public int[][] getFreeReward() {
        return freeReward;
    }

    /**
     * 任务列表
     */
    public int[] getTaskList() {
        return taskList;
    }

    /**
     * 商品列表
     */
    public int[] getProductList() {
        return productList;
    }

    //#endregion

    //#region 构造函数

    public ActivityCarnivalConfig(int id, int dayNum, int[][] freeReward, int[] taskList, int[] productList){
        this.id = id;
        this.dayNum = dayNum;
        this.freeReward = freeReward;
        this.taskList = taskList;
        this.productList = productList;
    }

    //#endregion
}
