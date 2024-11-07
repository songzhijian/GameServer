package com.jx.config.model;

import com.jx.config.loader.HeroTalentConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Talent.xml
*/
public class HeroTalentConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**效果*/
    private final int[] eff;

    /**
     * 获取所有配置
     */
    public static List<HeroTalentConfig> findAll(){
        return HeroTalentConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroTalentConfig getByKey(int key){
        return HeroTalentConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 效果
     */
    public int[] getEff() {
        return eff;
    }

    //#endregion

    //#region 构造函数

    public HeroTalentConfig(int id, int[] eff){
        this.id = id;
        this.eff = eff;
    }

    //#endregion
}
