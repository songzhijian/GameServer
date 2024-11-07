package com.jx.config.model;

import com.jx.config.loader.AllianceFlagConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Flag.xml
*/
public class AllianceFlagConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**类型，1=形状，2=徽记，3=底纹，4=形状颜色，5=徽记颜色，6=底纹颜色*/
    private final int type;
    /**解锁条件*/
    private final int[] unlockCondition;

    /**
     * 获取所有配置
     */
    public static List<AllianceFlagConfig> findAll(){
        return AllianceFlagConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceFlagConfig getByKey(int key){
        return AllianceFlagConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 类型，1=形状，2=徽记，3=底纹，4=形状颜色，5=徽记颜色，6=底纹颜色
     */
    public int getType() {
        return type;
    }

    /**
     * 解锁条件
     */
    public int[] getUnlockCondition() {
        return unlockCondition;
    }

    //#endregion

    //#region 构造函数

    public AllianceFlagConfig(int id, int type, int[] unlockCondition){
        this.id = id;
        this.type = type;
        this.unlockCondition = unlockCondition;
    }

    //#endregion
}
