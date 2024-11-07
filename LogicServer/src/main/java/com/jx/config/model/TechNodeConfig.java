package com.jx.config.model;

import com.jx.config.loader.TechNodeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tech_Node.xml
*/
public class TechNodeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**最大等级*/
    private final int maxLvl;
    /**科技内容列表*/
    private final int[] techList;
    /**前置科技列表*/
    private final int[] prevNode;
    /**后续科技列表*/
    private final int[] nextNode;

    /**
     * 获取所有配置
     */
    public static List<TechNodeConfig> findAll(){
        return TechNodeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TechNodeConfig getByKey(int key){
        return TechNodeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 最大等级
     */
    public int getMaxLvl() {
        return maxLvl;
    }

    /**
     * 科技内容列表
     */
    public int[] getTechList() {
        return techList;
    }

    /**
     * 前置科技列表
     */
    public int[] getPrevNode() {
        return prevNode;
    }

    /**
     * 后续科技列表
     */
    public int[] getNextNode() {
        return nextNode;
    }

    //#endregion

    //#region 构造函数

    public TechNodeConfig(int id, int maxLvl, int[] techList, int[] prevNode, int[] nextNode){
        this.id = id;
        this.maxLvl = maxLvl;
        this.techList = techList;
        this.prevNode = prevNode;
        this.nextNode = nextNode;
    }

    //#endregion
}
