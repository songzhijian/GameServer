package com.jx.config.model;

import com.jx.config.loader.AttributeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Attribute.xml
*/
public class AttributeConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**公式*/
    private final int[] formula;
    /**发送给客户端*/
    private final boolean sendToC;
    /**战斗力*/
    private final float bp;

    /**
     * 获取所有配置
     */
    public static List<AttributeConfig> findAll(){
        return AttributeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AttributeConfig getByKey(int key){
        return AttributeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 公式
     */
    public int[] getFormula() {
        return formula;
    }

    /**
     * 发送给客户端
     */
    public boolean isSendToC() {
        return sendToC;
    }

    /**
     * 战斗力
     */
    public float getBp() {
        return bp;
    }

    //#endregion

    //#region 构造函数

    public AttributeConfig(int id, int[] formula, boolean sendToC, float bp){
        this.id = id;
        this.formula = formula;
        this.sendToC = sendToC;
        this.bp = bp;
    }

    //#endregion
}
