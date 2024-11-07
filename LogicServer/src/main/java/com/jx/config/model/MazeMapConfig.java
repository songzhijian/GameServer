package com.jx.config.model;

import com.jx.config.loader.MazeMapConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Map.xml
*/
public class MazeMapConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**房间列表*/
    private final int[] roomList;
    /**房间起点列表*/
    private final int[] startList;

    /**
     * 获取所有配置
     */
    public static List<MazeMapConfig> findAll(){
        return MazeMapConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeMapConfig getByKey(int key){
        return MazeMapConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 房间列表
     */
    public int[] getRoomList() {
        return roomList;
    }

    /**
     * 房间起点列表
     */
    public int[] getStartList() {
        return startList;
    }

    //#endregion

    //#region 构造函数

    public MazeMapConfig(int id, int[] roomList, int[] startList){
        this.id = id;
        this.roomList = roomList;
        this.startList = startList;
    }

    //#endregion
}
