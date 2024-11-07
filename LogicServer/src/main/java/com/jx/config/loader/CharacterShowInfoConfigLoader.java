package com.jx.config.loader;

import com.jx.config.ConfigGlobalManager;
import com.gameengine.system.utils.LogUtils;
import com.gameengine.system.utils.XmlUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.model.CharacterShowInfoConfig;
import com.jx.config.util.gen.support.IConfigLoader;
import com.tool.config.type.primitive.*;
import com.tool.config.type.struct.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* 工具生成 配置文件 Character_Show_Info.xml
*/
@ConfigLoader
public class CharacterShowInfoConfigLoader implements IConfigLoader{

    /**配置文件名*/
    public static final String CONFIG_NAME = "Character_Show_Info";

    /**
     * 加载配置
     */
    private static void load(){
        List<Map<String, String>>all=XmlUtils.getXMLFile(CONFIG_NAME);
        if(all.size()<=0){
            return;
        }
        Map<String, String> data=all.get(0);

        // 各个字段
        String fieldName = null;
        try{
            fieldName = "hero_srcShow";
            CharacterShowInfoConfig.hero_srcShow=StringParse.parse(data.get("hero_srcShow"));
            fieldName = "hero_src";
            CharacterShowInfoConfig.hero_src=StringParse.parse(data.get("hero_src"));
            fieldName = "hero_srcCity";
            CharacterShowInfoConfig.hero_srcCity=StringParse.parse(data.get("hero_srcCity"));
            fieldName = "hero_exclusive_icon";
            CharacterShowInfoConfig.hero_exclusive_icon=StringParse.parse(data.get("hero_exclusive_icon"));
        }catch(Exception e){
            ConfigGlobalManager.error = String.format("[ConfigLoader] load config %s error, fieldName = %s message = %s", CONFIG_NAME, fieldName, e.getMessage());
            LogUtils.logger.warn(ConfigGlobalManager.error,e);
            throw e;
        }

        LogUtils.logger.info("[ConfigLoader] load config {} finish",CONFIG_NAME);

    }
}
