package com.jx.config.model;

import com.jx.config.loader.MazeRouteConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Route.xml
*/
public class MazeRouteConfig extends AbstractConfig implements IConfig {

    /**节点id*/
    private final int id;
    /**节点类型*/
    private final int type;
    /**房间*/
    private final int room;
    /**步级*/
    private final int step;
    /**后置节点*/
    private final int[] nextIds;
    /**节点奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<MazeRouteConfig> findAll(){
        return MazeRouteConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeRouteConfig getByKey(int key){
        return MazeRouteConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 节点id
     */
    public int getId() {
        return id;
    }

    /**
     * 节点类型
     */
    public int getType() {
        return type;
    }

    /**
     * 房间
     */
    public int getRoom() {
        return room;
    }

    /**
     * 步级
     */
    public int getStep() {
        return step;
    }

    /**
     * 后置节点
     */
    public int[] getNextIds() {
        return nextIds;
    }

    /**
     * 节点奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public MazeRouteConfig(int id, int type, int room, int step, int[] nextIds, int[][] reward){
        this.id = id;
        this.type = type;
        this.room = room;
        this.step = step;
        this.nextIds = nextIds;
        this.reward = reward;
    }

    //#endregion
}
