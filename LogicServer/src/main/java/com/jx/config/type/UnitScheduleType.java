package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成UnitScheduleType
 */
public enum UnitScheduleType {

    /**
     * 集结结束定时器
     */
    ASSEMBLE_FINISH(0),

    /**
     * 矿生产结束
     */
    MINE_PRODUCT_FINISH(1),

    /**
     * 检测港口npc、城防值刷新的定时器
     */
    PORT_NPC_DEF_REFRESH(2),

    /**
     * 行为状态、生命周期检测
     */
    STATE_AND_LIFE_CHECK(3),

    /**
     * 怪物宝箱过期检测
     */
    MONSTER_BOX_DISAPPEAR(4),

    /**
     * 驻港超时
     */
    STATIONED_IN_PORT(5),

    ;
    private int value;

    public static UnitScheduleType[] ARRAY = {
            ASSEMBLE_FINISH,
            MINE_PRODUCT_FINISH,
            PORT_NPC_DEF_REFRESH,
            STATE_AND_LIFE_CHECK,
            MONSTER_BOX_DISAPPEAR,
            STATIONED_IN_PORT
    };

    UnitScheduleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UnitScheduleType getType(int value) {
        return switch (value) {
            case 0 -> ASSEMBLE_FINISH;
            case 1 -> MINE_PRODUCT_FINISH;
            case 2 -> PORT_NPC_DEF_REFRESH;
            case 3 -> STATE_AND_LIFE_CHECK;
            case 4 -> MONSTER_BOX_DISAPPEAR;
            case 5 -> STATIONED_IN_PORT;
            default -> {
                LogUtils.logger.error("UnitScheduleType is not find value:{}",value);
                yield null;
            }
        };
    }
}
