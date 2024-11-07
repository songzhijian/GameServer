package com.jx.config.model;

import com.jx.config.loader.TradeGoodsTagConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Goods_Tag.xml
*/
public class TradeGoodsTagConfig extends AbstractConfig implements IConfig {

    /**序号*/
    private final int id;
    /**标签名*/
    private final String name;
    /**标签背景*/
    private final String img;
    /**标签详情描述*/
    private final String des;

    /**
     * 获取所有配置
     */
    public static List<TradeGoodsTagConfig> findAll(){
        return TradeGoodsTagConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradeGoodsTagConfig getByKey(int key){
        return TradeGoodsTagConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序号
     */
    public int getId() {
        return id;
    }

    /**
     * 标签名
     */
    public String getName() {
        return name;
    }

    /**
     * 标签背景
     */
    public String getImg() {
        return img;
    }

    /**
     * 标签详情描述
     */
    public String getDes() {
        return des;
    }

    //#endregion

    //#region 构造函数

    public TradeGoodsTagConfig(int id, String name, String img, String des){
        this.id = id;
        this.name = name;
        this.img = img;
        this.des = des;
    }

    //#endregion
}
