package com.jx.config.model;

import com.jx.config.loader.FunctionUnlockConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Function_Unlock.xml
*/
public class FunctionUnlockConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**解锁条件，可配多个*/
    private final long[][] unlockCondition;

    /**
     * 获取所有配置
     */
    public static List<FunctionUnlockConfig> findAll(){
        return FunctionUnlockConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static FunctionUnlockConfig getByKey(int key){
        return FunctionUnlockConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 解锁条件，可配多个
     */
    public long[][] getUnlockCondition() {
        return unlockCondition;
    }

    //#endregion

    //#region 构造函数

    public FunctionUnlockConfig(int id, long[][] unlockCondition){
        this.id = id;
        this.unlockCondition = unlockCondition;
    }

    //#endregion
}
