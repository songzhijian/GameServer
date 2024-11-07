package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RankSettleType
 */
public enum RankSettleType {

    /**
     * 按周结算
     */
    WEEKLY(1),

    ;
    private int value;

    public static RankSettleType[] ARRAY = {
            WEEKLY
    };

    RankSettleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RankSettleType getType(int value) {
        return switch (value) {
            case 1 -> WEEKLY;
            default -> {
                LogUtils.logger.error("RankSettleType is not find value:{}",value);
                yield null;
            }
        };
    }
}
