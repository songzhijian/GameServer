package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ActiveType
 */
public enum ActiveType {

    /**
     * 任务（类型参数arg1：任务类型）
     */
    TASK(1),

    /**
     * 活动（类型参数arg2：活动id）
     */
    ACTIVITY(2),

    ;
    private int value;

    public static ActiveType[] ARRAY = {
            TASK,
            ACTIVITY
    };

    ActiveType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActiveType getType(int value) {
        return switch (value) {
            case 1 -> TASK;
            case 2 -> ACTIVITY;
            default -> {
                LogUtils.logger.error("ActiveType is not find value:{}",value);
                yield null;
            }
        };
    }
}
