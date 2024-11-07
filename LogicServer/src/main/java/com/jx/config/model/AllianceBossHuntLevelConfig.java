package com.jx.config.model;

import com.jx.config.loader.AllianceBossHuntLevelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Boss_Hunt_Level.xml
*/
public class AllianceBossHuntLevelConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**等级*/
    private final int level;
    /**BOSSID*/
    private final int bossId;
    /**BOSS讨伐次数*/
    private final int bossAtkNum;
    /**伤害积分比*/
    private final int damToScore;
    /**小怪ID*/
    private final int monsterId;
    /**小怪讨伐次数*/
    private final int monsterAtkNum;
    /**联盟奖励*/
    private final int[] allianceReward;
    /**个人进度奖励*/
    private final int[] perReward;
    /**排行榜*/
    private final int rank;
    /**排行榜领奖条件*/
    private final int rankCondition;
    /**初始赛季天数*/
    private final int[] initialStage;

    /**
     * 获取所有配置
     */
    public static List<AllianceBossHuntLevelConfig> findAll(){
        return AllianceBossHuntLevelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceBossHuntLevelConfig getByKey(int key){
        return AllianceBossHuntLevelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * BOSSID
     */
    public int getBossId() {
        return bossId;
    }

    /**
     * BOSS讨伐次数
     */
    public int getBossAtkNum() {
        return bossAtkNum;
    }

    /**
     * 伤害积分比
     */
    public int getDamToScore() {
        return damToScore;
    }

    /**
     * 小怪ID
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * 小怪讨伐次数
     */
    public int getMonsterAtkNum() {
        return monsterAtkNum;
    }

    /**
     * 联盟奖励
     */
    public int[] getAllianceReward() {
        return allianceReward;
    }

    /**
     * 个人进度奖励
     */
    public int[] getPerReward() {
        return perReward;
    }

    /**
     * 排行榜
     */
    public int getRank() {
        return rank;
    }

    /**
     * 排行榜领奖条件
     */
    public int getRankCondition() {
        return rankCondition;
    }

    /**
     * 初始赛季天数
     */
    public int[] getInitialStage() {
        return initialStage;
    }

    //#endregion

    //#region 构造函数

    public AllianceBossHuntLevelConfig(int id, int level, int bossId, int bossAtkNum, int damToScore, int monsterId, int monsterAtkNum, int[] allianceReward, int[] perReward, int rank, int rankCondition, int[] initialStage){
        this.id = id;
        this.level = level;
        this.bossId = bossId;
        this.bossAtkNum = bossAtkNum;
        this.damToScore = damToScore;
        this.monsterId = monsterId;
        this.monsterAtkNum = monsterAtkNum;
        this.allianceReward = allianceReward;
        this.perReward = perReward;
        this.rank = rank;
        this.rankCondition = rankCondition;
        this.initialStage = initialStage;
    }

    //#endregion
}
