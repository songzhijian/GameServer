package com.jx.config.model;

import com.jx.config.loader.AllianceAuthorityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Authority.xml
*/
public class AllianceAuthorityConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**权限类型*/
    private final int Type;
    /**阶级权限*/
    private final int[] rankAuthority;
    /**官员权限*/
    private final int[] officialAuthority;

    /**
     * 获取所有配置
     */
    public static List<AllianceAuthorityConfig> findAll(){
        return AllianceAuthorityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceAuthorityConfig getByKey(int key){
        return AllianceAuthorityConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 权限类型
     */
    public int getType() {
        return Type;
    }

    /**
     * 阶级权限
     */
    public int[] getRankAuthority() {
        return rankAuthority;
    }

    /**
     * 官员权限
     */
    public int[] getOfficialAuthority() {
        return officialAuthority;
    }

    //#endregion

    //#region 构造函数

    public AllianceAuthorityConfig(int id, int Type, int[] rankAuthority, int[] officialAuthority){
        this.id = id;
        this.Type = Type;
        this.rankAuthority = rankAuthority;
        this.officialAuthority = officialAuthority;
    }

    //#endregion
}
