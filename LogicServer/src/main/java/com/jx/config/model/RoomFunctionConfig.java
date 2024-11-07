package com.jx.config.model;

import com.jx.config.loader.RoomFunctionConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Room_Function.xml
*/
public class RoomFunctionConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**可用条件[空=无条件]*/
    private final int[] unlock;

    /**
     * 获取所有配置
     */
    public static List<RoomFunctionConfig> findAll(){
        return RoomFunctionConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RoomFunctionConfig getByKey(int key){
        return RoomFunctionConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 可用条件[空=无条件]
     */
    public int[] getUnlock() {
        return unlock;
    }

    //#endregion

    //#region 构造函数

    public RoomFunctionConfig(int id, int[] unlock){
        this.id = id;
        this.unlock = unlock;
    }

    //#endregion
}
