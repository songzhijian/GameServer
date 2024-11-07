package com.jx.config.model;

import com.jx.config.loader.PersonalArmamentsEventConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Personal_Armaments_Event.xml
*/
public class PersonalArmamentsEventConfig extends AbstractConfig implements IConfig {

    /**军备事件id*/
    private final int id;
    /**活动事件*/
    private final int[] event;
    /**活跃值奖励*/
    private final int score;

    /**
     * 获取所有配置
     */
    public static List<PersonalArmamentsEventConfig> findAll(){
        return PersonalArmamentsEventConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PersonalArmamentsEventConfig getByKey(int key){
        return PersonalArmamentsEventConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 军备事件id
     */
    public int getId() {
        return id;
    }

    /**
     * 活动事件
     */
    public int[] getEvent() {
        return event;
    }

    /**
     * 活跃值奖励
     */
    public int getScore() {
        return score;
    }

    //#endregion

    //#region 构造函数

    public PersonalArmamentsEventConfig(int id, int[] event, int score){
        this.id = id;
        this.event = event;
        this.score = score;
    }

    //#endregion
}
