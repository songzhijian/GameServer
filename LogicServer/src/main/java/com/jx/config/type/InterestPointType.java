package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成InterestPointType
 */
public enum InterestPointType {

    /**
     * 宝藏
     */
    TREASURE(0),

    /**
     * 怪物
     */
    MONSTER(1),

    /**
     * BOSS
     */
    BOSS(2),

    /**
     * 营救
     */
    RESCUE(3),

    /**
     * 捡垃圾
     */
    RAFT(4),

    ;
    private int value;

    public static InterestPointType[] ARRAY = {
            TREASURE,
            MONSTER,
            BOSS,
            RESCUE,
            RAFT
    };

    InterestPointType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static InterestPointType getType(int value) {
        return switch (value) {
            case 0 -> TREASURE;
            case 1 -> MONSTER;
            case 2 -> BOSS;
            case 3 -> RESCUE;
            case 4 -> RAFT;
            default -> {
                LogUtils.logger.error("InterestPointType is not find value:{}",value);
                yield null;
            }
        };
    }
}
