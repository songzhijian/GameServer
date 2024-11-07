package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RoomFunctionType
 */
public enum RoomFunctionType {

    /**
     * 升级
     */
    LEVELUP(1),

    /**
     * 工作
     */
    WORK(2),

    /**
     * 管理
     */
    MANAGEMENT(3),

    /**
     * 进阶
     */
    QUALITYUP(4),

    /**
     * 遣散
     */
    LAYOFF(5),

    /**
     * 研究
     */
    RESEARCH(6),

    /**
     * 训练
     */
    TRAINING(7),

    /**
     * 编队
     */
    DEPLOYMENT(8),

    /**
     * 制药
     */
    MEDICINE(9),

    /**
     * 医疗
     */
    TREATMENT(10),

    /**
     * 药品仓库
     */
    MEDICINEWAREHOUSE(11),

    /**
     * 交易品仓库
     */
    GOODSWAREHOUSE(12),

    /**
     * 行情
     */
    MARKET(13),

    /**
     * 饮用水仓库
     */
    WATERWAREHOUSE(14),

    /**
     * 烹饪
     */
    COOK(15),

    /**
     * 食品仓库
     */
    FOODSWAREHOUSE(16),

    /**
     * 派遣
     */
    DISPATCH(17),

    /**
     * 家禽室
     */
    HATCH(18),

    /**
     * 商店
     */
    SHOP(19),

    ;
    private int value;

    public static RoomFunctionType[] ARRAY = {
            LEVELUP,
            WORK,
            MANAGEMENT,
            QUALITYUP,
            LAYOFF,
            RESEARCH,
            TRAINING,
            DEPLOYMENT,
            MEDICINE,
            TREATMENT,
            MEDICINEWAREHOUSE,
            GOODSWAREHOUSE,
            MARKET,
            WATERWAREHOUSE,
            COOK,
            FOODSWAREHOUSE,
            DISPATCH,
            HATCH,
            SHOP
    };

    RoomFunctionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoomFunctionType getType(int value) {
        return switch (value) {
            case 1 -> LEVELUP;
            case 2 -> WORK;
            case 3 -> MANAGEMENT;
            case 4 -> QUALITYUP;
            case 5 -> LAYOFF;
            case 6 -> RESEARCH;
            case 7 -> TRAINING;
            case 8 -> DEPLOYMENT;
            case 9 -> MEDICINE;
            case 10 -> TREATMENT;
            case 11 -> MEDICINEWAREHOUSE;
            case 12 -> GOODSWAREHOUSE;
            case 13 -> MARKET;
            case 14 -> WATERWAREHOUSE;
            case 15 -> COOK;
            case 16 -> FOODSWAREHOUSE;
            case 17 -> DISPATCH;
            case 18 -> HATCH;
            case 19 -> SHOP;
            default -> {
                LogUtils.logger.error("RoomFunctionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
