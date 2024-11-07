package com.jx.config.model;

import com.jx.config.loader.TechTabConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tech_Tab.xml
*/
public class TechTabConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**科技树列表*/
    private final int[] techTreeList;
    /**开启条件*/
    private final int[] cond;

    /**
     * 获取所有配置
     */
    public static List<TechTabConfig> findAll(){
        return TechTabConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TechTabConfig getByKey(int key){
        return TechTabConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 科技树列表
     */
    public int[] getTechTreeList() {
        return techTreeList;
    }

    /**
     * 开启条件
     */
    public int[] getCond() {
        return cond;
    }

    //#endregion

    //#region 构造函数

    public TechTabConfig(int id, int[] techTreeList, int[] cond){
        this.id = id;
        this.techTreeList = techTreeList;
        this.cond = cond;
    }

    //#endregion
}
