package com.jx.config.model;

import com.jx.config.loader.ArtifactGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Artifact_Group.xml
*/
public class ArtifactGroupConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**功能组*/
    private final int[] fun;

    /**
     * 获取所有配置
     */
    public static List<ArtifactGroupConfig> findAll(){
        return ArtifactGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ArtifactGroupConfig getByKey(int key){
        return ArtifactGroupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 功能组
     */
    public int[] getFun() {
        return fun;
    }

    //#endregion

    //#region 构造函数

    public ArtifactGroupConfig(int id, int[] fun){
        this.id = id;
        this.fun = fun;
    }

    //#endregion
}
