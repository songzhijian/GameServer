package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成CareerType
 */
public enum CareerType {

    /**
     * 首次获得某道具（道具表的promptNew字段为1的）
     */
    PROMPT_NEW_ITEM_ID(1),

    /**
     * 前端主动完成的任务标识号记到生涯中
     */
    CLIENT_COMPLETE_CODE(2),

    /**
     * 生涯击杀士兵数量
     */
    KILL_NUM(3),

    /**
     * 生涯击杀海盗数量
     */
    KILL_PIRATE_NUM(4),

    /**
     * 港口贸易统计
     */
    PORT_TRADE(5),

    /**
     * 训练士兵数量
     */
    TRAIN_SOLDIERS(6),

    /**
     * 累计加速
     */
    SPEED_TIME(7),

    /**
     * 分解英雄
     */
    RESOLVE_HERO(8),

    ;
    private int value;

    public static CareerType[] ARRAY = {
            PROMPT_NEW_ITEM_ID,
            CLIENT_COMPLETE_CODE,
            KILL_NUM,
            KILL_PIRATE_NUM,
            PORT_TRADE,
            TRAIN_SOLDIERS,
            SPEED_TIME,
            RESOLVE_HERO
    };

    CareerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CareerType getType(int value) {
        return switch (value) {
            case 1 -> PROMPT_NEW_ITEM_ID;
            case 2 -> CLIENT_COMPLETE_CODE;
            case 3 -> KILL_NUM;
            case 4 -> KILL_PIRATE_NUM;
            case 5 -> PORT_TRADE;
            case 6 -> TRAIN_SOLDIERS;
            case 7 -> SPEED_TIME;
            case 8 -> RESOLVE_HERO;
            default -> {
                LogUtils.logger.error("CareerType is not find value:{}",value);
                yield null;
            }
        };
    }
}
