package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成HeroQualityType
 */
public enum HeroQualityType {

    /**
     * 白
     */
    WHITE(1),

    /**
     * 绿
     */
    GREEN(2),

    /**
     * 蓝
     */
    BLUE(3),

    /**
     * 蓝+
     */
    BLUE_1(4),

    /**
     * 紫
     */
    PURPLE(5),

    /**
     * 紫+
     */
    PURPLE_1(6),

    /**
     * 黄
     */
    YELLOW(7),

    /**
     * 黄+
     */
    YELLOW_1(8),

    /**
     * 红
     */
    RED(9),

    /**
     * 红+
     */
    RED_1(10),

    /**
     * 红++
     */
    RED_2(11),

    /**
     * 彩
     */
    PINK(12),

    /**
     * 彩1星
     */
    PINK_1(13),

    /**
     * 彩2星
     */
    PINK_2(14),

    /**
     * 彩3星
     */
    PINK_3(15),

    /**
     * 彩4星
     */
    PINK_4(16),

    /**
     * 彩5星
     */
    PINK_5(17),

    /**
     * 幻白
     */
    COLORS(18),

    /**
     * 幻白1星
     */
    COLORS_1(19),

    /**
     * 幻白2星
     */
    COLORS_2(20),

    /**
     * 幻白3星
     */
    COLORS_3(21),

    /**
     * 幻白4星
     */
    COLORS_4(22),

    /**
     * 幻白5星
     */
    COLORS_5(23),

    ;
    private int value;

    public static HeroQualityType[] ARRAY = {
            WHITE,
            GREEN,
            BLUE,
            BLUE_1,
            PURPLE,
            PURPLE_1,
            YELLOW,
            YELLOW_1,
            RED,
            RED_1,
            RED_2,
            PINK,
            PINK_1,
            PINK_2,
            PINK_3,
            PINK_4,
            PINK_5,
            COLORS,
            COLORS_1,
            COLORS_2,
            COLORS_3,
            COLORS_4,
            COLORS_5
    };

    HeroQualityType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HeroQualityType getType(int value) {
        return switch (value) {
            case 1 -> WHITE;
            case 2 -> GREEN;
            case 3 -> BLUE;
            case 4 -> BLUE_1;
            case 5 -> PURPLE;
            case 6 -> PURPLE_1;
            case 7 -> YELLOW;
            case 8 -> YELLOW_1;
            case 9 -> RED;
            case 10 -> RED_1;
            case 11 -> RED_2;
            case 12 -> PINK;
            case 13 -> PINK_1;
            case 14 -> PINK_2;
            case 15 -> PINK_3;
            case 16 -> PINK_4;
            case 17 -> PINK_5;
            case 18 -> COLORS;
            case 19 -> COLORS_1;
            case 20 -> COLORS_2;
            case 21 -> COLORS_3;
            case 22 -> COLORS_4;
            case 23 -> COLORS_5;
            default -> {
                LogUtils.logger.error("HeroQualityType is not find value:{}",value);
                yield null;
            }
        };
    }
}
