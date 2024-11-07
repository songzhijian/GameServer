package com.jx.config.model;

import com.jx.config.loader.CharacterShowInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Character_Show_Info.xml
*/
public class CharacterShowInfoConfig extends AbstractConfig implements IConfig {

    /**英雄展示模型*/
    public static String hero_srcShow;
    /**英雄兵人资源*/
    public static String hero_src;
    /**英雄城建资源*/
    public static String hero_srcCity;
    /**专属装备图标*/
    public static String hero_exclusive_icon;

}