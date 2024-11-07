package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceRankType
 */
public enum AllianceRankType {

    /**
     * 联盟阶级1
     */
    R1(1),

    /**
     * 联盟阶级2
     */
    R2(2),

    /**
     * 联盟阶级3
     */
    R3(3),

    /**
     * 联盟阶级4
     */
    R4(4),

    /**
     * 联盟阶级5
     */
    R5(5),

    ;
    private int value;

    public static AllianceRankType[] ARRAY = {
            R1,
            R2,
            R3,
            R4,
            R5
    };

    AllianceRankType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceRankType getType(int value) {
        return switch (value) {
            case 1 -> R1;
            case 2 -> R2;
            case 3 -> R3;
            case 4 -> R4;
            case 5 -> R5;
            default -> {
                LogUtils.logger.error("AllianceRankType is not find value:{}",value);
                yield null;
            }
        };
    }
}
