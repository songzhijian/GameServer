package com.jx.config.model;

import com.jx.config.loader.MazeStepIntensityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Step_Intensity.xml
*/
public class MazeStepIntensityConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**属性修正*/
    private final int[][] attributeModification;

    /**
     * 获取所有配置
     */
    public static List<MazeStepIntensityConfig> findAll(){
        return MazeStepIntensityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeStepIntensityConfig getByKey(int key){
        return MazeStepIntensityConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 属性修正
     */
    public int[][] getAttributeModification() {
        return attributeModification;
    }

    //#endregion

    //#region 构造函数

    public MazeStepIntensityConfig(int id, int[][] attributeModification){
        this.id = id;
        this.attributeModification = attributeModification;
    }

    //#endregion
}
