package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceOfficialType
 */
public enum AllianceOfficialType {

    /**
     * 
     */
    NONE(0),

    /**
     * 外交官状态
     */
    DIPLOMAT(1),

    /**
     * 战神状态
     */
    BATTLEMASTER(2),

    /**
     * 招募官状态
     */
    RECRUITER(3),

    /**
     * 督军状态
     */
    WARLORD(4),

    ;
    private int value;

    public static AllianceOfficialType[] ARRAY = {
            NONE,
            DIPLOMAT,
            BATTLEMASTER,
            RECRUITER,
            WARLORD
    };

    AllianceOfficialType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceOfficialType getType(int value) {
        return switch (value) {
            case 0 -> NONE;
            case 1 -> DIPLOMAT;
            case 2 -> BATTLEMASTER;
            case 3 -> RECRUITER;
            case 4 -> WARLORD;
            default -> {
                LogUtils.logger.error("AllianceOfficialType is not find value:{}",value);
                yield null;
            }
        };
    }
}
