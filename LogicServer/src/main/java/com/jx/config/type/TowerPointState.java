package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TowerPointState
 */
public enum TowerPointState {

    /**
     * 未被选中
     */
    NOT_CHOOSE(0),

    /**
     * 编队前往中
     */
    ON_THE_WAY(1),

    /**
     * 战斗中
     */
    FIGHTING(2),

    /**
     * 编队返回中
     */
    BACKING(3),

    /**
     * 可领奖
     */
    COULD_RECEIVE_REWARD(4),

    /**
     * 清除
     */
    CLEAN(5),

    ;
    private int value;

    public static TowerPointState[] ARRAY = {
            NOT_CHOOSE,
            ON_THE_WAY,
            FIGHTING,
            BACKING,
            COULD_RECEIVE_REWARD,
            CLEAN
    };

    TowerPointState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TowerPointState getType(int value) {
        return switch (value) {
            case 0 -> NOT_CHOOSE;
            case 1 -> ON_THE_WAY;
            case 2 -> FIGHTING;
            case 3 -> BACKING;
            case 4 -> COULD_RECEIVE_REWARD;
            case 5 -> CLEAN;
            default -> {
                LogUtils.logger.error("TowerPointState is not find value:{}",value);
                yield null;
            }
        };
    }
}
