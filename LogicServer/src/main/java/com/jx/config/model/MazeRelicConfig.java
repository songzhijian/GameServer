package com.jx.config.model;

import com.jx.config.loader.MazeRelicConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Relic.xml
*/
public class MazeRelicConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**遗物被动*/
    private final int skillPassive;
    /**遗物技能*/
    private final int[] skillBase;

    /**
     * 获取所有配置
     */
    public static List<MazeRelicConfig> findAll(){
        return MazeRelicConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeRelicConfig getByKey(int key){
        return MazeRelicConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 遗物被动
     */
    public int getSkillPassive() {
        return skillPassive;
    }

    /**
     * 遗物技能
     */
    public int[] getSkillBase() {
        return skillBase;
    }

    //#endregion

    //#region 构造函数

    public MazeRelicConfig(int id, int skillPassive, int[] skillBase){
        this.id = id;
        this.skillPassive = skillPassive;
        this.skillBase = skillBase;
    }

    //#endregion
}
