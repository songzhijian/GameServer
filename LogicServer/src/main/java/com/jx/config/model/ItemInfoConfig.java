package com.jx.config.model;

import com.jx.config.loader.ItemInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Item_Info.xml
*/
public class ItemInfoConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**子类型*/
    private final int type;
    /**品质*/
    private final int color;
    /**堆叠数量*/
    private final int groupNum;
    /**是否可以使用*/
    private final int canUse;
    /**使用后CD*/
    private final int useCD;
    /**使用所需数量*/
    private final int useNeed;
    /**使用数量*/
    private final int useCount;
    /**使用类型*/
    private final int useType;
    /**使用效果*/
    private final int[][] useParam;
    /**使用后处理*/
    private final int useConclusion;
    /**New逻辑*/
    private final int promptNew;
    /**资源重量*/
    private final int weight;
    /**加速逻辑判断值*/
    private final int timeLogic;

    /**
     * 获取所有配置
     */
    public static List<ItemInfoConfig> findAll(){
        return ItemInfoConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ItemInfoConfig getByKey(int key){
        return ItemInfoConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 子类型
     */
    public int getType() {
        return type;
    }

    /**
     * 品质
     */
    public int getColor() {
        return color;
    }

    /**
     * 堆叠数量
     */
    public int getGroupNum() {
        return groupNum;
    }

    /**
     * 是否可以使用
     */
    public int getCanUse() {
        return canUse;
    }

    /**
     * 使用后CD
     */
    public int getUseCD() {
        return useCD;
    }

    /**
     * 使用所需数量
     */
    public int getUseNeed() {
        return useNeed;
    }

    /**
     * 使用数量
     */
    public int getUseCount() {
        return useCount;
    }

    /**
     * 使用类型
     */
    public int getUseType() {
        return useType;
    }

    /**
     * 使用效果
     */
    public int[][] getUseParam() {
        return useParam;
    }

    /**
     * 使用后处理
     */
    public int getUseConclusion() {
        return useConclusion;
    }

    /**
     * New逻辑
     */
    public int getPromptNew() {
        return promptNew;
    }

    /**
     * 资源重量
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 加速逻辑判断值
     */
    public int getTimeLogic() {
        return timeLogic;
    }

    //#endregion

    //#region 构造函数

    public ItemInfoConfig(int id, int type, int color, int groupNum, int canUse, int useCD, int useNeed, int useCount, int useType, int[][] useParam, int useConclusion, int promptNew, int weight, int timeLogic){
        this.id = id;
        this.type = type;
        this.color = color;
        this.groupNum = groupNum;
        this.canUse = canUse;
        this.useCD = useCD;
        this.useNeed = useNeed;
        this.useCount = useCount;
        this.useType = useType;
        this.useParam = useParam;
        this.useConclusion = useConclusion;
        this.promptNew = promptNew;
        this.weight = weight;
        this.timeLogic = timeLogic;
    }

    //#endregion
}
