package com.jx.config.model;

import com.jx.config.loader.WordMarqueeConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Word_Marquee.xml
*/
public class WordMarqueeConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**参数 目前 联盟占领参数代表占领城市等级     英雄获取途径代表英雄品质*/
    private final int[] para;
    /**显示范围 1联盟 2全服*/
    private final int displayRange;
    /**是否启用*/
    private final int isUsing;

    /**
     * 获取所有配置
     */
    public static List<WordMarqueeConfig> findAll(){
        return WordMarqueeConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WordMarqueeConfig getByKey(int key){
        return WordMarqueeConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 参数 目前 联盟占领参数代表占领城市等级     英雄获取途径代表英雄品质
     */
    public int[] getPara() {
        return para;
    }

    /**
     * 显示范围 1联盟 2全服
     */
    public int getDisplayRange() {
        return displayRange;
    }

    /**
     * 是否启用
     */
    public int getIsUsing() {
        return isUsing;
    }

    //#endregion

    //#region 构造函数

    public WordMarqueeConfig(int id, int[] para, int displayRange, int isUsing){
        this.id = id;
        this.para = para;
        this.displayRange = displayRange;
        this.isUsing = isUsing;
    }

    //#endregion
}
