package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TaskStatus
 */
public enum TaskStatus {

    /**
     * 未解锁
     */
    UNLOCK(-1),

    /**
     * 未完成
     */
    UNFINISHED(0),

    /**
     * 完成
     */
    FINISHED(1),

    /**
     * 已领奖
     */
    GET_REWARD(2),

    ;
    private int value;

    public static TaskStatus[] ARRAY = {
            UNLOCK,
            UNFINISHED,
            FINISHED,
            GET_REWARD
    };

    TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskStatus getType(int value) {
        return switch (value) {
            case -1 -> UNLOCK;
            case 0 -> UNFINISHED;
            case 1 -> FINISHED;
            case 2 -> GET_REWARD;
            default -> {
                LogUtils.logger.error("TaskStatus is not find value:{}",value);
                yield null;
            }
        };
    }
}
