package com.jx.config.model;

import com.jx.config.loader.WorldPortConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Port.xml
*/
public class WorldPortConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**所属地图*/
    private final int scendId;
    /**坐标*/
    private final int[] position;
    /**属于商圈*/
    private final int portCulturaCircle;
    /**是否可出生*/
    private final int isBirthCity;
    /**等级*/
    private final int lv;
    /**港口名称*/
    private final int name;
    /**首次攻占奖励*/
    private final int[][] firstReward;
    /**参与奖励*/
    private final int[][] joinReward;
    /**势力值*/
    private final int force;
    /**港口头像*/
    private final String iconHead;
    /**相连港口*/
    private final int[] nearByPort;
    /**占地圈数*/
    private final int circles;
    /**最大驻守数量*/
    private final int maxGarrisonNum;
    /**解锁巡航点*/
    private final int[] unlockPoint;
    /**怪物刷新*/
    private final int[][] monster;
    /**怪物数量*/
    private final int monsterNum;
    /**boss刷新*/
    private final int[][] boss;
    /**boss数量*/
    private final int bossNum;
    /**资源刷新*/
    private final int[][] resource;
    /**资源数量*/
    private final int resourceNum;
    /**精英怪物*/
    private final int[] eliteArmy;
    /**城防怪物*/
    private final int weakArmy;
    /**精英怪物恢复时间s*/
    private final int eliteRecoveryTime;
    /**连战数*/
    private final int attackLimit;
    /**城防值*/
    private final int defence;
    /**城防值恢复CD，恢复1点城防值所需时间s*/
    private final int defenceRecoveryTime;
    /**保护罩时间s，易主后开启*/
    private final int shieldTime;
    /**联盟领地增益*/
    private final int[] allianceBuff;
    /**重伤兵转阵亡*/
    private final int hurtToDeath;
    /**首次发现奖励*/
    private final int[][] firstDiscoveryReward;
    /**迷雾解除半径*/
    private final int mistReleaseRadius;
    /**是否是王座*/
    private final int isTheThrone;
    /**海德拉幼体数量*/
    private final int hydraLarvaeNum;

    /**
     * 获取所有配置
     */
    public static List<WorldPortConfig> findAll(){
        return WorldPortConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldPortConfig getByKey(int key){
        return WorldPortConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 所属地图
     */
    public int getScendId() {
        return scendId;
    }

    /**
     * 坐标
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * 属于商圈
     */
    public int getPortCulturaCircle() {
        return portCulturaCircle;
    }

    /**
     * 是否可出生
     */
    public int getIsBirthCity() {
        return isBirthCity;
    }

    /**
     * 等级
     */
    public int getLv() {
        return lv;
    }

    /**
     * 港口名称
     */
    public int getName() {
        return name;
    }

    /**
     * 首次攻占奖励
     */
    public int[][] getFirstReward() {
        return firstReward;
    }

    /**
     * 参与奖励
     */
    public int[][] getJoinReward() {
        return joinReward;
    }

    /**
     * 势力值
     */
    public int getForce() {
        return force;
    }

    /**
     * 港口头像
     */
    public String getIconHead() {
        return iconHead;
    }

    /**
     * 相连港口
     */
    public int[] getNearByPort() {
        return nearByPort;
    }

    /**
     * 占地圈数
     */
    public int getCircles() {
        return circles;
    }

    /**
     * 最大驻守数量
     */
    public int getMaxGarrisonNum() {
        return maxGarrisonNum;
    }

    /**
     * 解锁巡航点
     */
    public int[] getUnlockPoint() {
        return unlockPoint;
    }

    /**
     * 怪物刷新
     */
    public int[][] getMonster() {
        return monster;
    }

    /**
     * 怪物数量
     */
    public int getMonsterNum() {
        return monsterNum;
    }

    /**
     * boss刷新
     */
    public int[][] getBoss() {
        return boss;
    }

    /**
     * boss数量
     */
    public int getBossNum() {
        return bossNum;
    }

    /**
     * 资源刷新
     */
    public int[][] getResource() {
        return resource;
    }

    /**
     * 资源数量
     */
    public int getResourceNum() {
        return resourceNum;
    }

    /**
     * 精英怪物
     */
    public int[] getEliteArmy() {
        return eliteArmy;
    }

    /**
     * 城防怪物
     */
    public int getWeakArmy() {
        return weakArmy;
    }

    /**
     * 精英怪物恢复时间s
     */
    public int getEliteRecoveryTime() {
        return eliteRecoveryTime;
    }

    /**
     * 连战数
     */
    public int getAttackLimit() {
        return attackLimit;
    }

    /**
     * 城防值
     */
    public int getDefence() {
        return defence;
    }

    /**
     * 城防值恢复CD，恢复1点城防值所需时间s
     */
    public int getDefenceRecoveryTime() {
        return defenceRecoveryTime;
    }

    /**
     * 保护罩时间s，易主后开启
     */
    public int getShieldTime() {
        return shieldTime;
    }

    /**
     * 联盟领地增益
     */
    public int[] getAllianceBuff() {
        return allianceBuff;
    }

    /**
     * 重伤兵转阵亡
     */
    public int getHurtToDeath() {
        return hurtToDeath;
    }

    /**
     * 首次发现奖励
     */
    public int[][] getFirstDiscoveryReward() {
        return firstDiscoveryReward;
    }

    /**
     * 迷雾解除半径
     */
    public int getMistReleaseRadius() {
        return mistReleaseRadius;
    }

    /**
     * 是否是王座
     */
    public int getIsTheThrone() {
        return isTheThrone;
    }

    /**
     * 海德拉幼体数量
     */
    public int getHydraLarvaeNum() {
        return hydraLarvaeNum;
    }

    //#endregion

    //#region 构造函数

    public WorldPortConfig(int id, int scendId, int[] position, int portCulturaCircle, int isBirthCity, int lv, int name, int[][] firstReward, int[][] joinReward, int force, String iconHead, int[] nearByPort, int circles, int maxGarrisonNum, int[] unlockPoint, int[][] monster, int monsterNum, int[][] boss, int bossNum, int[][] resource, int resourceNum, int[] eliteArmy, int weakArmy, int eliteRecoveryTime, int attackLimit, int defence, int defenceRecoveryTime, int shieldTime, int[] allianceBuff, int hurtToDeath, int[][] firstDiscoveryReward, int mistReleaseRadius, int isTheThrone, int hydraLarvaeNum){
        this.id = id;
        this.scendId = scendId;
        this.position = position;
        this.portCulturaCircle = portCulturaCircle;
        this.isBirthCity = isBirthCity;
        this.lv = lv;
        this.name = name;
        this.firstReward = firstReward;
        this.joinReward = joinReward;
        this.force = force;
        this.iconHead = iconHead;
        this.nearByPort = nearByPort;
        this.circles = circles;
        this.maxGarrisonNum = maxGarrisonNum;
        this.unlockPoint = unlockPoint;
        this.monster = monster;
        this.monsterNum = monsterNum;
        this.boss = boss;
        this.bossNum = bossNum;
        this.resource = resource;
        this.resourceNum = resourceNum;
        this.eliteArmy = eliteArmy;
        this.weakArmy = weakArmy;
        this.eliteRecoveryTime = eliteRecoveryTime;
        this.attackLimit = attackLimit;
        this.defence = defence;
        this.defenceRecoveryTime = defenceRecoveryTime;
        this.shieldTime = shieldTime;
        this.allianceBuff = allianceBuff;
        this.hurtToDeath = hurtToDeath;
        this.firstDiscoveryReward = firstDiscoveryReward;
        this.mistReleaseRadius = mistReleaseRadius;
        this.isTheThrone = isTheThrone;
        this.hydraLarvaeNum = hydraLarvaeNum;
    }

    //#endregion
}
