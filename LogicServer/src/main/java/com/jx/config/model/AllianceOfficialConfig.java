package com.jx.config.model;

import com.jx.config.loader.AllianceOfficialConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Official.xml
*/
public class AllianceOfficialConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**官职加成*/
    private final int buffID;

    /**
     * 获取所有配置
     */
    public static List<AllianceOfficialConfig> findAll(){
        return AllianceOfficialConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceOfficialConfig getByKey(int key){
        return AllianceOfficialConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 官职加成
     */
    public int getBuffID() {
        return buffID;
    }

    //#endregion

    //#region 构造函数

    public AllianceOfficialConfig(int id, int buffID){
        this.id = id;
        this.buffID = buffID;
    }

    //#endregion
}
