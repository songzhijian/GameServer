package com.jx.config.model;

import com.jx.config.loader.PersonalArmamentsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Personal_Armaments.xml
*/
public class PersonalArmamentsConfig extends AbstractConfig implements IConfig {

    /**活动id*/
    private final int id;
    /**舰长室阶段*/
    private final int[][] captainPhase;
    /**阶段事件组*/
    private final int[][] eventGroup;
    /**准备期时长（秒）（暂时废弃）*/
    private final int preparationTime;

    /**
     * 获取所有配置
     */
    public static List<PersonalArmamentsConfig> findAll(){
        return PersonalArmamentsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PersonalArmamentsConfig getByKey(int key){
        return PersonalArmamentsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 活动id
     */
    public int getId() {
        return id;
    }

    /**
     * 舰长室阶段
     */
    public int[][] getCaptainPhase() {
        return captainPhase;
    }

    /**
     * 阶段事件组
     */
    public int[][] getEventGroup() {
        return eventGroup;
    }

    /**
     * 准备期时长（秒）（暂时废弃）
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    //#endregion

    //#region 构造函数

    public PersonalArmamentsConfig(int id, int[][] captainPhase, int[][] eventGroup, int preparationTime){
        this.id = id;
        this.captainPhase = captainPhase;
        this.eventGroup = eventGroup;
        this.preparationTime = preparationTime;
    }

    //#endregion
}
