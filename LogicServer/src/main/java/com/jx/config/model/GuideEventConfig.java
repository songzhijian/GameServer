package com.jx.config.model;

import com.jx.config.loader.GuideEventConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 GuideEvent.xml
*/
public class GuideEventConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**服务器行为*/
    private final int[] guideActionType;
    /**服务器行为*/
    private final int[][][] guideActionParams;

    /**
     * 获取所有配置
     */
    public static List<GuideEventConfig> findAll(){
        return GuideEventConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GuideEventConfig getByKey(int key){
        return GuideEventConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 服务器行为
     */
    public int[] getGuideActionType() {
        return guideActionType;
    }

    /**
     * 服务器行为
     */
    public int[][][] getGuideActionParams() {
        return guideActionParams;
    }

    //#endregion

    //#region 构造函数

    public GuideEventConfig(int id, int[] guideActionType, int[][][] guideActionParams){
        this.id = id;
        this.guideActionType = guideActionType;
        this.guideActionParams = guideActionParams;
    }

    //#endregion
}
