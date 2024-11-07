package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ScoreToLevelType
 */
public enum ScoreToLevelType {

    /**
     * 直接设置 (arg1:condtionType,arg2:根据第一个参数填写)
     */
    SETLEVEL(1),

    /**
     * 经验转换（arg1:多少经验转1级，arg2:开通经验加成万分比）
     */
    EXPTOLEVEL(2),

    ;
    private int value;

    public static ScoreToLevelType[] ARRAY = {
            SETLEVEL,
            EXPTOLEVEL
    };

    ScoreToLevelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ScoreToLevelType getType(int value) {
        return switch (value) {
            case 1 -> SETLEVEL;
            case 2 -> EXPTOLEVEL;
            default -> {
                LogUtils.logger.error("ScoreToLevelType is not find value:{}",value);
                yield null;
            }
        };
    }
}
