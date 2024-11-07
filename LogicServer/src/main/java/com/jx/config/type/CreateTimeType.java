package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成CreateTimeType
 */
public enum CreateTimeType {

    /**
     * 和活动时间一致
     */
    BP_ACTIVITY(1),

    /**
     * 永久开放，完成结束
     */
    BP_FOREVER(2),

    ;
    private int value;

    public static CreateTimeType[] ARRAY = {
            BP_ACTIVITY,
            BP_FOREVER
    };

    CreateTimeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CreateTimeType getType(int value) {
        return switch (value) {
            case 1 -> BP_ACTIVITY;
            case 2 -> BP_FOREVER;
            default -> {
                LogUtils.logger.error("CreateTimeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
