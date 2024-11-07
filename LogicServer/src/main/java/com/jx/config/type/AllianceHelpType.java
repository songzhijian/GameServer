package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceHelpType
 */
public enum AllianceHelpType {

    /**
     * 建筑升级帮助
     */
    BUILDING_HELP(1),

    /**
     * 科技的帮助
     */
    SCIENCE_HELP(2),

    ;
    private int value;

    public static AllianceHelpType[] ARRAY = {
            BUILDING_HELP,
            SCIENCE_HELP
    };

    AllianceHelpType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceHelpType getType(int value) {
        return switch (value) {
            case 1 -> BUILDING_HELP;
            case 2 -> SCIENCE_HELP;
            default -> {
                LogUtils.logger.error("AllianceHelpType is not find value:{}",value);
                yield null;
            }
        };
    }
}
