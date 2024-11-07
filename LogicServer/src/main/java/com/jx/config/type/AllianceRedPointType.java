package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceRedPointType
 */
public enum AllianceRedPointType {

    /**
     * 联盟成员管理
     */
    MEMBER_MANAGE(1),

    ;
    private int value;

    public static AllianceRedPointType[] ARRAY = {
            MEMBER_MANAGE
    };

    AllianceRedPointType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceRedPointType getType(int value) {
        return switch (value) {
            case 1 -> MEMBER_MANAGE;
            default -> {
                LogUtils.logger.error("AllianceRedPointType is not find value:{}",value);
                yield null;
            }
        };
    }
}
