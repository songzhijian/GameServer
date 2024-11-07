package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成SituationType
 */
public enum SituationType {

    /**
     * 随机港口(arg1：临近层数，arg2：是否是新港口 arg3:其他不可重复的索引，可以写多个）-》portId
     */
    RANDOM_PORT(1),

    /**
     * 随机货物(arg1:根据参数第几个索引，必须市港口，arg3：数量）-》goodsId,num
     */
    RANDOM_GOODS(2),

    /**
     * 随机怪物（arg1:数量，arg2：怪物id，可以写多个）-> monsterId,num
     */
    RANDOM_MONSTER(3),

    /**
     * 随机数量（arg1:最小值，arg2：最大值）-> num
     */
    RANDOM_NUM(4),

    ;
    private int value;

    public static SituationType[] ARRAY = {
            RANDOM_PORT,
            RANDOM_GOODS,
            RANDOM_MONSTER,
            RANDOM_NUM
    };

    SituationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SituationType getType(int value) {
        return switch (value) {
            case 1 -> RANDOM_PORT;
            case 2 -> RANDOM_GOODS;
            case 3 -> RANDOM_MONSTER;
            case 4 -> RANDOM_NUM;
            default -> {
                LogUtils.logger.error("SituationType is not find value:{}",value);
                yield null;
            }
        };
    }
}
