package com.jx.config.model;

import com.jx.config.loader.TechTreeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tech_Tree.xml
*/
public class TechTreeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**节点列表*/
    private final int[] nodeList;
    /**根节点列表*/
    private final int[] rootNodeList;
    /**解锁条件*/
    private final long[][] unlockCond;
    /**图鉴奖励*/
    private final int[] collectReward;

    /**
     * 获取所有配置
     */
    public static List<TechTreeConfig> findAll(){
        return TechTreeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TechTreeConfig getByKey(int key){
        return TechTreeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 节点列表
     */
    public int[] getNodeList() {
        return nodeList;
    }

    /**
     * 根节点列表
     */
    public int[] getRootNodeList() {
        return rootNodeList;
    }

    /**
     * 解锁条件
     */
    public long[][] getUnlockCond() {
        return unlockCond;
    }

    /**
     * 图鉴奖励
     */
    public int[] getCollectReward() {
        return collectReward;
    }

    //#endregion

    //#region 构造函数

    public TechTreeConfig(int id, int[] nodeList, int[] rootNodeList, long[][] unlockCond, int[] collectReward){
        this.id = id;
        this.nodeList = nodeList;
        this.rootNodeList = rootNodeList;
        this.unlockCond = unlockCond;
        this.collectReward = collectReward;
    }

    //#endregion
}
