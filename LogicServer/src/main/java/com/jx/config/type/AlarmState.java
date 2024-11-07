package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AlarmState
 */
public enum AlarmState {

    /**
     * 无警报
     */
    NO_ALARM(0),

    /**
     * 攻击警报
     */
    ATTACK(1),

    /**
     * 侦查警报
     */
    SCOUT(2),

    /**
     * 援助警报(驻守+参与集结）
     */
    ASSIST(3),

    ;
    private int value;

    public static AlarmState[] ARRAY = {
            NO_ALARM,
            ATTACK,
            SCOUT,
            ASSIST
    };

    AlarmState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AlarmState getType(int value) {
        return switch (value) {
            case 0 -> NO_ALARM;
            case 1 -> ATTACK;
            case 2 -> SCOUT;
            case 3 -> ASSIST;
            default -> {
                LogUtils.logger.error("AlarmState is not find value:{}",value);
                yield null;
            }
        };
    }
}
