package com.jx.config.model;

import com.jx.config.loader.MazeDifficultyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Difficulty.xml
*/
public class MazeDifficultyConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**区间战力上限*/
    private final long combatPower;

    /**
     * 获取所有配置
     */
    public static List<MazeDifficultyConfig> findAll(){
        return MazeDifficultyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeDifficultyConfig getByKey(int key){
        return MazeDifficultyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 区间战力上限
     */
    public long getCombatPower() {
        return combatPower;
    }

    //#endregion

    //#region 构造函数

    public MazeDifficultyConfig(int id, long combatPower){
        this.id = id;
        this.combatPower = combatPower;
    }

    //#endregion
}
