package com.jx.config.model;

import com.jx.config.loader.RandomGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Random_Group.xml
*/
public class RandomGroupConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**随机模式（RandomType）*/
    private final int type;
    /**随机次数*/
    private final int num;
    /**是否重复*/
    private final boolean repeat;
    /**随机内容*/
    private final int[][] random;
    /**类型+权重*/
    private final int[][] weight;

    /**
     * 获取所有配置
     */
    public static List<RandomGroupConfig> findAll(){
        return RandomGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RandomGroupConfig getByKey(int key){
        return RandomGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 随机模式（RandomType）
     */
    public int getType() {
        return type;
    }

    /**
     * 随机次数
     */
    public int getNum() {
        return num;
    }

    /**
     * 是否重复
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * 随机内容
     */
    public int[][] getRandom() {
        return random;
    }

    /**
     * 类型+权重
     */
    public int[][] getWeight() {
        return weight;
    }

    //#endregion

    //#region 构造函数

    public RandomGroupConfig(int id, int type, int num, boolean repeat, int[][] random, int[][] weight){
        this.id = id;
        this.type = type;
        this.num = num;
        this.repeat = repeat;
        this.random = random;
        this.weight = weight;
    }

    //#endregion
}
