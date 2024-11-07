package com.jx.config.model;

import com.jx.config.loader.TutorialStoryConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tutorial_Story.xml
*/
public class TutorialStoryConfig extends AbstractConfig implements IConfig {

    /**标记索引*/
    private final int id;
    /**是否记录*/
    private final int record;
    /**下一项*/
    private final int next;

    /**
     * 获取所有配置
     */
    public static List<TutorialStoryConfig> findAll(){
        return TutorialStoryConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TutorialStoryConfig getByKey(int key){
        return TutorialStoryConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 标记索引
     */
    public int getId() {
        return id;
    }

    /**
     * 是否记录
     */
    public int getRecord() {
        return record;
    }

    /**
     * 下一项
     */
    public int getNext() {
        return next;
    }

    //#endregion

    //#region 构造函数

    public TutorialStoryConfig(int id, int record, int next){
        this.id = id;
        this.record = record;
        this.next = next;
    }

    //#endregion
}
