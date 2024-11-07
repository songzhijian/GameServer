package com.jx.config.model;

import com.jx.config.loader.DrifterConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Drifter.xml
*/
public class DrifterConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**漂流速度(cm/s)*/
    private final int[] speed;
    /**刷新权重*/
    private final int randWeight;
    /**资源获取*/
    private final int[][] reward;
    /**垃圾类型*/
    private final int type;
    /**参数*/
    private final int[] param;

    /**
     * 获取所有配置
     */
    public static List<DrifterConfig> findAll(){
        return DrifterConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static DrifterConfig getByKey(int key){
        return DrifterConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 漂流速度(cm/s)
     */
    public int[] getSpeed() {
        return speed;
    }

    /**
     * 刷新权重
     */
    public int getRandWeight() {
        return randWeight;
    }

    /**
     * 资源获取
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 垃圾类型
     */
    public int getType() {
        return type;
    }

    /**
     * 参数
     */
    public int[] getParam() {
        return param;
    }

    //#endregion

    //#region 构造函数

    public DrifterConfig(int id, int[] speed, int randWeight, int[][] reward, int type, int[] param){
        this.id = id;
        this.speed = speed;
        this.randWeight = randWeight;
        this.reward = reward;
        this.type = type;
        this.param = param;
    }

    //#endregion
}
