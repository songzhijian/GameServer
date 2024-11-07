package com.jx.config.model;

import com.jx.config.loader.SceneConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Scene.xml
*/
public class SceneConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**名字*/
    private final String name;
    /**类型*/
    private final int[] size;
    /**关联地图名称*/
    private final String relevanceMap;
    /**是否支持循环地图*/
    private final int mapRecurrence;
    /**是否锁定相机高度*/
    private final int cameraLock;
    /**相机持续锁定主船*/
    private final int cameraLockBoat;
    /**地图数据id*/
    private final String mapDataId;
    /**附加阻挡*/
    private final int[] block;
    /**新手坐标*/
    private final int[] position;
    /**航线id*/
    private final String sailLineDataId;
    /**场景使用逻辑(程序自己填写)*/
    private final int[][] logicType;
    /**环形地图*/
    private final boolean ring;
    /**销毁方式（程序填写）*/
    private final int[] destroy;
    /**出生区人数*/
    private final int[] numOfBirth;
    /**可出生商圈*/
    private final int[] birthArea;
    /**商圈数*/
    private final int[][] numOfArea;
    /**速度因子*/
    private final float speed;
    /**地图镜头高度*/
    private final int zoom;

    /**
     * 获取所有配置
     */
    public static List<SceneConfig> findAll(){
        return SceneConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SceneConfig getByKey(int key){
        return SceneConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 类型
     */
    public int[] getSize() {
        return size;
    }

    /**
     * 关联地图名称
     */
    public String getRelevanceMap() {
        return relevanceMap;
    }

    /**
     * 是否支持循环地图
     */
    public int getMapRecurrence() {
        return mapRecurrence;
    }

    /**
     * 是否锁定相机高度
     */
    public int getCameraLock() {
        return cameraLock;
    }

    /**
     * 相机持续锁定主船
     */
    public int getCameraLockBoat() {
        return cameraLockBoat;
    }

    /**
     * 地图数据id
     */
    public String getMapDataId() {
        return mapDataId;
    }

    /**
     * 附加阻挡
     */
    public int[] getBlock() {
        return block;
    }

    /**
     * 新手坐标
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * 航线id
     */
    public String getSailLineDataId() {
        return sailLineDataId;
    }

    /**
     * 场景使用逻辑(程序自己填写)
     */
    public int[][] getLogicType() {
        return logicType;
    }

    /**
     * 环形地图
     */
    public boolean isRing() {
        return ring;
    }

    /**
     * 销毁方式（程序填写）
     */
    public int[] getDestroy() {
        return destroy;
    }

    /**
     * 出生区人数
     */
    public int[] getNumOfBirth() {
        return numOfBirth;
    }

    /**
     * 可出生商圈
     */
    public int[] getBirthArea() {
        return birthArea;
    }

    /**
     * 商圈数
     */
    public int[][] getNumOfArea() {
        return numOfArea;
    }

    /**
     * 速度因子
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * 地图镜头高度
     */
    public int getZoom() {
        return zoom;
    }

    //#endregion

    //#region 构造函数

    public SceneConfig(int id, String name, int[] size, String relevanceMap, int mapRecurrence, int cameraLock, int cameraLockBoat, String mapDataId, int[] block, int[] position, String sailLineDataId, int[][] logicType, boolean ring, int[] destroy, int[] numOfBirth, int[] birthArea, int[][] numOfArea, float speed, int zoom){
        this.id = id;
        this.name = name;
        this.size = size;
        this.relevanceMap = relevanceMap;
        this.mapRecurrence = mapRecurrence;
        this.cameraLock = cameraLock;
        this.cameraLockBoat = cameraLockBoat;
        this.mapDataId = mapDataId;
        this.block = block;
        this.position = position;
        this.sailLineDataId = sailLineDataId;
        this.logicType = logicType;
        this.ring = ring;
        this.destroy = destroy;
        this.numOfBirth = numOfBirth;
        this.birthArea = birthArea;
        this.numOfArea = numOfArea;
        this.speed = speed;
        this.zoom = zoom;
    }

    //#endregion
}
