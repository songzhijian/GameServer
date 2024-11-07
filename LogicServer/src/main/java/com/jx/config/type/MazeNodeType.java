package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成MazeNodeType
 */
public enum MazeNodeType {

    /**
     * 空节点
     */
    EMPTY(0),

    /**
     * 战斗
     */
    FIGHT(1),

    /**
     * BOSS战斗
     */
    BOSS_FIGHT(2),

    /**
     * 遗物
     */
    RELIC(3),

    /**
     * 战斗+遗物
     */
    FIGHT_RELIC(4),

    /**
     * 恢复
     */
    RECOVER(5),

    /**
     * 招募
     */
    RECRUIT(6),

    /**
     * 交易
     */
    EXCHANGE(7),

    ;
    private int value;

    public static MazeNodeType[] ARRAY = {
            EMPTY,
            FIGHT,
            BOSS_FIGHT,
            RELIC,
            FIGHT_RELIC,
            RECOVER,
            RECRUIT,
            EXCHANGE
    };

    MazeNodeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MazeNodeType getType(int value) {
        return switch (value) {
            case 0 -> EMPTY;
            case 1 -> FIGHT;
            case 2 -> BOSS_FIGHT;
            case 3 -> RELIC;
            case 4 -> FIGHT_RELIC;
            case 5 -> RECOVER;
            case 6 -> RECRUIT;
            case 7 -> EXCHANGE;
            default -> {
                LogUtils.logger.error("MazeNodeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
