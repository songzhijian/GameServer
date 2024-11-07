package com.jx.config.model;

import com.jx.config.loader.SearchRoomOutputConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Search_Room_Output.xml
*/
public class SearchRoomOutputConfig extends AbstractConfig implements IConfig {

    /**id【房间id=groupid+等级】*/
    private final int id;
    /**组*/
    private final int group;
    /**等级*/
    private final int level;
    /**前置建筑*/
    private final long[][] preconditions;
    /**建造消耗*/
    private final int[][] consume;
    /**间隔时间内产出数量*/
    private final int output;
    /**产量上限*/
    private final int limit;

    /**
     * 获取所有配置
     */
    public static List<SearchRoomOutputConfig> findAll(){
        return SearchRoomOutputConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SearchRoomOutputConfig getByKey(int key){
        return SearchRoomOutputConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id【房间id=groupid+等级】
     */
    public int getId() {
        return id;
    }

    /**
     * 组
     */
    public int getGroup() {
        return group;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 前置建筑
     */
    public long[][] getPreconditions() {
        return preconditions;
    }

    /**
     * 建造消耗
     */
    public int[][] getConsume() {
        return consume;
    }

    /**
     * 间隔时间内产出数量
     */
    public int getOutput() {
        return output;
    }

    /**
     * 产量上限
     */
    public int getLimit() {
        return limit;
    }

    //#endregion

    //#region 构造函数

    public SearchRoomOutputConfig(int id, int group, int level, long[][] preconditions, int[][] consume, int output, int limit){
        this.id = id;
        this.group = group;
        this.level = level;
        this.preconditions = preconditions;
        this.consume = consume;
        this.output = output;
        this.limit = limit;
    }

    //#endregion
}
