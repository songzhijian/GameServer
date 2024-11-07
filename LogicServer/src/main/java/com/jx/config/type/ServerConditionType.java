package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ServerConditionType
 */
public enum ServerConditionType {

    /**
     * 某赛季一个时间之后开启（arg1:seasonId【-1不限制】，arg2:时间类型【-1 不限 1天 2 周(自然周)】arg3：时间数量），时间数量都是从0开始，大于等于配置
     */
    SEASON(1),

    /**
     * 天下大势阶段（arg1:阶段id arg2:该阶段状态【1=进行中，2=已结束，3=进行中或已结束】）
     */
    TREND(2),

    ;
    private int value;

    public static ServerConditionType[] ARRAY = {
            SEASON,
            TREND
    };

    ServerConditionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ServerConditionType getType(int value) {
        return switch (value) {
            case 1 -> SEASON;
            case 2 -> TREND;
            default -> {
                LogUtils.logger.error("ServerConditionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
