package com.jx.config.model;

import com.jx.config.loader.BusinessTypeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 BusinessType.xml
*/
public class BusinessTypeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**资源奖励上限控制类型, 0=可超上限，1=可超1次，2=不可超，多余舍去*/
    private final int resCapControlType;

    /**
     * 获取所有配置
     */
    public static List<BusinessTypeConfig> findAll(){
        return BusinessTypeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BusinessTypeConfig getByKey(int key){
        return BusinessTypeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 资源奖励上限控制类型, 0=可超上限，1=可超1次，2=不可超，多余舍去
     */
    public int getResCapControlType() {
        return resCapControlType;
    }

    //#endregion

    //#region 构造函数

    public BusinessTypeConfig(int id, int resCapControlType){
        this.id = id;
        this.resCapControlType = resCapControlType;
    }

    //#endregion
}
