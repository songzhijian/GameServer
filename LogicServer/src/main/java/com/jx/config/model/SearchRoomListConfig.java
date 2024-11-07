package com.jx.config.model;

import com.jx.config.loader.SearchRoomListConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Search_Room_List.xml
*/
public class SearchRoomListConfig extends AbstractConfig implements IConfig {

    /**船组id*/
    private final int id;
    /**搜寻船类型*/
    private final int type;
    /**搜寻船图标*/
    private final String shipIcon;
    /**产出物资源id*/
    private final int outputResouceId;
    /**解锁科技*/
    private final int preTechnology;
    /**需要大船的品质*/
    private final int preColor;
    /**最高等级*/
    private final int maxLevel;

    /**
     * 获取所有配置
     */
    public static List<SearchRoomListConfig> findAll(){
        return SearchRoomListConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SearchRoomListConfig getByKey(int key){
        return SearchRoomListConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 船组id
     */
    public int getId() {
        return id;
    }

    /**
     * 搜寻船类型
     */
    public int getType() {
        return type;
    }

    /**
     * 搜寻船图标
     */
    public String getShipIcon() {
        return shipIcon;
    }

    /**
     * 产出物资源id
     */
    public int getOutputResouceId() {
        return outputResouceId;
    }

    /**
     * 解锁科技
     */
    public int getPreTechnology() {
        return preTechnology;
    }

    /**
     * 需要大船的品质
     */
    public int getPreColor() {
        return preColor;
    }

    /**
     * 最高等级
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    //#endregion

    //#region 构造函数

    public SearchRoomListConfig(int id, int type, String shipIcon, int outputResouceId, int preTechnology, int preColor, int maxLevel){
        this.id = id;
        this.type = type;
        this.shipIcon = shipIcon;
        this.outputResouceId = outputResouceId;
        this.preTechnology = preTechnology;
        this.preColor = preColor;
        this.maxLevel = maxLevel;
    }

    //#endregion
}
