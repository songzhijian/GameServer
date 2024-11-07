package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成GuideActionType
 */
public enum GuideActionType {

    /**
     * 发物品（arg1：reward结构）
     */
    REWARD(0),

    /**
     * 扣除（arg1：cost结构)
     */
    COST(1),

    /**
     * 完成任务条件（arg1：条件ID）
     */
    CONDITION(2),

    ;
    private int value;

    public static GuideActionType[] ARRAY = {
            REWARD,
            COST,
            CONDITION
    };

    GuideActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GuideActionType getType(int value) {
        return switch (value) {
            case 0 -> REWARD;
            case 1 -> COST;
            case 2 -> CONDITION;
            default -> {
                LogUtils.logger.error("GuideActionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
