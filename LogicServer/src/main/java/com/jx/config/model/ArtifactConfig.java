package com.jx.config.model;

import com.jx.config.loader.ArtifactConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Artifact.xml
*/
public class ArtifactConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**解锁消耗道具*/
    private final int[][] unlockCost;

    /**
     * 获取所有配置
     */
    public static List<ArtifactConfig> findAll(){
        return ArtifactConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ArtifactConfig getByKey(int key){
        return ArtifactConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 解锁消耗道具
     */
    public int[][] getUnlockCost() {
        return unlockCost;
    }

    //#endregion

    //#region 构造函数

    public ArtifactConfig(int id, int[][] unlockCost){
        this.id = id;
        this.unlockCost = unlockCost;
    }

    //#endregion
}
