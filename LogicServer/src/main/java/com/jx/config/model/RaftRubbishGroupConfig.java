package com.jx.config.model;

import com.jx.config.loader.RaftRubbishGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Raft_Rubbish_Group.xml
*/
public class RaftRubbishGroupConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**组内容*/
    private final int[] param;
    /**开启任务*/
    private final int Num;

    /**
     * 获取所有配置
     */
    public static List<RaftRubbishGroupConfig> findAll(){
        return RaftRubbishGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RaftRubbishGroupConfig getByKey(int key){
        return RaftRubbishGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 组内容
     */
    public int[] getParam() {
        return param;
    }

    /**
     * 开启任务
     */
    public int getNum() {
        return Num;
    }

    //#endregion

    //#region 构造函数

    public RaftRubbishGroupConfig(int id, int[] param, int Num){
        this.id = id;
        this.param = param;
        this.Num = Num;
    }

    //#endregion
}
