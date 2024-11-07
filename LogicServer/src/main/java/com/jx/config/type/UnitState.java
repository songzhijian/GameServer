package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成UnitState
 */
public enum UnitState {

    /**
     * 无目的的静止状态
     */
    STOPPING(0),

    /**
     * 移动
     */
    MOVING(1),

    /**
     * 战斗，只有战斗管理器会是这个状态。attUnit、defUnit都只会是FIGHT_LINING,STATIONING,IN_HOME状态，他们的战斗管理器是FIGHTING，自身不会是FIGHTING
     */
    FIGHTING(2),

    /**
     * 采集(只做小船的状态标识，不用来管理产出计算）
     */
    EXPLOITING_MINE(3),

    /**
     * 驻守
     */
    STATIONING(4),

    /**
     * 进攻战斗队列中
     */
    ATTACK_LINING(5),

    /**
     * 在家（母船）
     */
    IN_HOME(6),

    /**
     * 矿产出/被采集（矿作为管理器，方便战斗、产出状态的切换、车轮战的处理；方便后续多人采一个矿的扩展）
     */
    MINE_PRODUCING(7),

    /**
     * 在集结的大船中（主船不是ASSEMBLING状态，而是IN_HOME/MOVING/FIGHTING状态；参与者持续ASSEMBLING状态直到解散）
     */
    ASSEMBLING(8),

    ;
    private int value;

    public static UnitState[] ARRAY = {
            STOPPING,
            MOVING,
            FIGHTING,
            EXPLOITING_MINE,
            STATIONING,
            ATTACK_LINING,
            IN_HOME,
            MINE_PRODUCING,
            ASSEMBLING
    };

    UnitState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UnitState getType(int value) {
        return switch (value) {
            case 0 -> STOPPING;
            case 1 -> MOVING;
            case 2 -> FIGHTING;
            case 3 -> EXPLOITING_MINE;
            case 4 -> STATIONING;
            case 5 -> ATTACK_LINING;
            case 6 -> IN_HOME;
            case 7 -> MINE_PRODUCING;
            case 8 -> ASSEMBLING;
            default -> {
                LogUtils.logger.error("UnitState is not find value:{}",value);
                yield null;
            }
        };
    }
}
