package com.jx.config.model;

import com.jx.config.loader.RaftRubbishConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Raft_Rubbish.xml
*/
public class RaftRubbishConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**垃圾刷新中心*/
    private final int[] RefreshCenter;
    /**垃圾生成范围*/
    private final int[] RefreshArea;
    /**漂流方向*/
    private final int[] rotation;
    /**刷新间隔*/
    private final int[] refreshRange;
    /**生成垃圾*/
    private final int[][] item;
    /**生成数量*/
    private final int Num;

    /**
     * 获取所有配置
     */
    public static List<RaftRubbishConfig> findAll(){
        return RaftRubbishConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RaftRubbishConfig getByKey(int key){
        return RaftRubbishConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 垃圾刷新中心
     */
    public int[] getRefreshCenter() {
        return RefreshCenter;
    }

    /**
     * 垃圾生成范围
     */
    public int[] getRefreshArea() {
        return RefreshArea;
    }

    /**
     * 漂流方向
     */
    public int[] getRotation() {
        return rotation;
    }

    /**
     * 刷新间隔
     */
    public int[] getRefreshRange() {
        return refreshRange;
    }

    /**
     * 生成垃圾
     */
    public int[][] getItem() {
        return item;
    }

    /**
     * 生成数量
     */
    public int getNum() {
        return Num;
    }

    //#endregion

    //#region 构造函数

    public RaftRubbishConfig(int id, int[] RefreshCenter, int[] RefreshArea, int[] rotation, int[] refreshRange, int[][] item, int Num){
        this.id = id;
        this.RefreshCenter = RefreshCenter;
        this.RefreshArea = RefreshArea;
        this.rotation = rotation;
        this.refreshRange = refreshRange;
        this.item = item;
        this.Num = Num;
    }

    //#endregion
}
