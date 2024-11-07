package com.jx.config.model;

import com.jx.config.loader.RaftConstructConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Raft_Construct.xml
*/
public class RaftConstructConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**<功能类型>*/
    private final int constructType;
    /**<建筑面积>*/
    private final int[] buildSize;
    /**<阻挡面积>*/
    private final int[] collisionSize;
    /**<建造资源需求>*/
    private final int[][] cost;
    /**<建造时长>*/
    private final int costTime;
    /**<最多建几个>*/
    private final int maxNum;
    /**<互动效果>*/
    private final int funcType;
    /**<互动参数>*/
    private final String funcParam;
    /**<执行角色>*/
    private final String hero;
    /**<互动时长>*/
    private final int interactionTime;
    /**<损坏时间>*/
    private final int[] damageTime;
    /**<修理时间>*/
    private final int repairTime;
    /**<修理资源需求>*/
    private final int[][] repairCost;
    /**健康值*/
    private final int HP;
    /**<损坏健康值>*/
    private final int[] damageHp;
    /**<解锁任务>*/
    private final int taskId;

    /**
     * 获取所有配置
     */
    public static List<RaftConstructConfig> findAll(){
        return RaftConstructConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RaftConstructConfig getByKey(int key){
        return RaftConstructConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * <功能类型>
     */
    public int getConstructType() {
        return constructType;
    }

    /**
     * <建筑面积>
     */
    public int[] getBuildSize() {
        return buildSize;
    }

    /**
     * <阻挡面积>
     */
    public int[] getCollisionSize() {
        return collisionSize;
    }

    /**
     * <建造资源需求>
     */
    public int[][] getCost() {
        return cost;
    }

    /**
     * <建造时长>
     */
    public int getCostTime() {
        return costTime;
    }

    /**
     * <最多建几个>
     */
    public int getMaxNum() {
        return maxNum;
    }

    /**
     * <互动效果>
     */
    public int getFuncType() {
        return funcType;
    }

    /**
     * <互动参数>
     */
    public String getFuncParam() {
        return funcParam;
    }

    /**
     * <执行角色>
     */
    public String getHero() {
        return hero;
    }

    /**
     * <互动时长>
     */
    public int getInteractionTime() {
        return interactionTime;
    }

    /**
     * <损坏时间>
     */
    public int[] getDamageTime() {
        return damageTime;
    }

    /**
     * <修理时间>
     */
    public int getRepairTime() {
        return repairTime;
    }

    /**
     * <修理资源需求>
     */
    public int[][] getRepairCost() {
        return repairCost;
    }

    /**
     * 健康值
     */
    public int getHP() {
        return HP;
    }

    /**
     * <损坏健康值>
     */
    public int[] getDamageHp() {
        return damageHp;
    }

    /**
     * <解锁任务>
     */
    public int getTaskId() {
        return taskId;
    }

    //#endregion

    //#region 构造函数

    public RaftConstructConfig(int id, int constructType, int[] buildSize, int[] collisionSize, int[][] cost, int costTime, int maxNum, int funcType, String funcParam, String hero, int interactionTime, int[] damageTime, int repairTime, int[][] repairCost, int HP, int[] damageHp, int taskId){
        this.id = id;
        this.constructType = constructType;
        this.buildSize = buildSize;
        this.collisionSize = collisionSize;
        this.cost = cost;
        this.costTime = costTime;
        this.maxNum = maxNum;
        this.funcType = funcType;
        this.funcParam = funcParam;
        this.hero = hero;
        this.interactionTime = interactionTime;
        this.damageTime = damageTime;
        this.repairTime = repairTime;
        this.repairCost = repairCost;
        this.HP = HP;
        this.damageHp = damageHp;
        this.taskId = taskId;
    }

    //#endregion
}
