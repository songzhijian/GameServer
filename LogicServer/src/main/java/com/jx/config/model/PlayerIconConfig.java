package com.jx.config.model;

import com.jx.config.loader.PlayerIconConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Player_Icon.xml
*/
public class PlayerIconConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**头像*/
    private final String icon;
    /**解锁*/
    private final int[][] unlock;

    /**
     * 获取所有配置
     */
    public static List<PlayerIconConfig> findAll(){
        return PlayerIconConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PlayerIconConfig getByKey(int key){
        return PlayerIconConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 解锁
     */
    public int[][] getUnlock() {
        return unlock;
    }

    //#endregion

    //#region 构造函数

    public PlayerIconConfig(int id, String icon, int[][] unlock){
        this.id = id;
        this.icon = icon;
        this.unlock = unlock;
    }

    //#endregion
}
