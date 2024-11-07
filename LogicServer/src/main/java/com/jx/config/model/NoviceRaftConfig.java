package com.jx.config.model;

import com.jx.config.loader.NoviceRaftConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 NoviceRaft.xml
*/
public class NoviceRaftConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**参数类型*/
    private final int type;
    /**参数*/
    private final int[][] param;
    /**参数2*/
    private final int[][] param2;
    /**完成条件*/
    private final int[][] condition;
    /**下一位*/
    private final int next;

    /**
     * 获取所有配置
     */
    public static List<NoviceRaftConfig> findAll(){
        return NoviceRaftConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static NoviceRaftConfig getByKey(int key){
        return NoviceRaftConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 参数类型
     */
    public int getType() {
        return type;
    }

    /**
     * 参数
     */
    public int[][] getParam() {
        return param;
    }

    /**
     * 参数2
     */
    public int[][] getParam2() {
        return param2;
    }

    /**
     * 完成条件
     */
    public int[][] getCondition() {
        return condition;
    }

    /**
     * 下一位
     */
    public int getNext() {
        return next;
    }

    //#endregion

    //#region 构造函数

    public NoviceRaftConfig(int id, int type, int[][] param, int[][] param2, int[][] condition, int next){
        this.id = id;
        this.type = type;
        this.param = param;
        this.param2 = param2;
        this.condition = condition;
        this.next = next;
    }

    //#endregion
}
