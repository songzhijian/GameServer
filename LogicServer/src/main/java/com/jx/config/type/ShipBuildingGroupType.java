package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ShipBuildingGroupType
 */
public enum ShipBuildingGroupType {

    /**
     * 毛坯房
     */
    BLANK_ROOM(1),

    /**
     * 空气毛坯房
     */
    AIR_BLANK_ROOM(2),

    /**
     * 梯子
     */
    LADDER_GROUP(3),

    /**
     * 梯子上方空毛坯房
     */
    LADDER_GROUP_2(4),

    /**
     * 杂物[疑似废弃]
     */
    SUNDRIES(5),

    /**
     * 平行船舱入口
     */
    PARALLEL_CABIN_ENTRANCE(6),

    /**
     * 垂直船舱入口
     */
    VERTICAL_CABIN_ENTRANCE(7),

    /**
     * 船长室_Lv0[0级房间程序有用]
     */
    MAIN_BUILDING(1100),

    /**
     * 工具间1_Lv0
     */
    TOOL_ROOM_1(2100),

    /**
     * 工具间2_Lv0
     */
    TOOL_ROOM_2(2200),

    /**
     * 工具间3_Lv0
     */
    TOOL_ROOM_3(2300),

    /**
     * 工具间4_Lv0
     */
    TOOL_ROOM_4(2400),

    /**
     * 工具间5_Lv0
     */
    TOOL_ROOM_5(2500),

    /**
     * 研究室_Lv0
     */
    RESEARCH_ROOM(3100),

    /**
     * 水兵室1_Lv0
     */
    NAVY_ROOM_1(4100),

    /**
     * 水兵室2_Lv0
     */
    NAVY_ROOM_2(4200),

    /**
     * 水兵室3_Lv0
     */
    NAVY_ROOM_3(4300),

    /**
     * 水兵室4_Lv0
     */
    NAVY_ROOM_4(4400),

    /**
     * 训练室1_Lv0
     */
    TRAIN_ROOM_1(5100),

    /**
     * 训练室2_Lv0
     */
    TRAIN_ROOM_2(5200),

    /**
     * 训练室3_Lv0
     */
    TRAIN_ROOM_3(5300),

    /**
     * 准备室1_Lv0
     */
    PREPARE_ROOM_1(6100),

    /**
     * 准备室2_Lv0
     */
    PREPARE_ROOM_2(6200),

    /**
     * 准备室3_Lv0
     */
    PREPARE_ROOM_3(6300),

    /**
     * 准备室4_Lv0
     */
    PREPARE_ROOM_4(6400),

    /**
     * 医疗室_Lv0
     */
    HOSPITAL(7100),

    /**
     * 货舱1_Lv0
     */
    HOLD_1(8100),

    /**
     * 货舱2_Lv0
     */
    HOLD_2(8200),

    /**
     * 货舱3_Lv0
     */
    HOLD_3(8300),

    /**
     * 货舱4_Lv0
     */
    HOLD_4(8400),

    /**
     * 会计室_Lv0
     */
    ACCOUNTING_ROOM(9100),

    /**
     * 家禽室_Lv0
     */
    POULTRY_ROOM(10100),

    /**
     * 净水室_Lv0
     */
    WATER_ROOM(11100),

    /**
     * 厨房_Lv0
     */
    KITCHEN(12100),

    /**
     * 搜寻室_Lv0
     */
    SEARCH_ROOM(13100),

    /**
     * 资源仓库_Lv0
     */
    RESOURCE_WAREHOUSE(14100),

    /**
     * 联盟大厅_Lv0
     */
    ALLIANCE_HALL(15100),

    /**
     * 草药室lv0
     */
    MEDICINE_MATERIAL_ROOM(16100),

    /**
     * 瞭望塔_Lv0
     */
    WATCHTOWER(20100),

    /**
     * 主帆_Lv0
     */
    MAINSAIL(20200),

    /**
     * 操舵_Lv0
     */
    STEERING(20300),

    /**
     * 甲板火炮_Lv0
     */
    DECK_GUN(20400),

    ;
    private int value;

    public static ShipBuildingGroupType[] ARRAY = {
            BLANK_ROOM,
            AIR_BLANK_ROOM,
            LADDER_GROUP,
            LADDER_GROUP_2,
            SUNDRIES,
            PARALLEL_CABIN_ENTRANCE,
            VERTICAL_CABIN_ENTRANCE,
            MAIN_BUILDING,
            TOOL_ROOM_1,
            TOOL_ROOM_2,
            TOOL_ROOM_3,
            TOOL_ROOM_4,
            TOOL_ROOM_5,
            RESEARCH_ROOM,
            NAVY_ROOM_1,
            NAVY_ROOM_2,
            NAVY_ROOM_3,
            NAVY_ROOM_4,
            TRAIN_ROOM_1,
            TRAIN_ROOM_2,
            TRAIN_ROOM_3,
            PREPARE_ROOM_1,
            PREPARE_ROOM_2,
            PREPARE_ROOM_3,
            PREPARE_ROOM_4,
            HOSPITAL,
            HOLD_1,
            HOLD_2,
            HOLD_3,
            HOLD_4,
            ACCOUNTING_ROOM,
            POULTRY_ROOM,
            WATER_ROOM,
            KITCHEN,
            SEARCH_ROOM,
            RESOURCE_WAREHOUSE,
            ALLIANCE_HALL,
            MEDICINE_MATERIAL_ROOM,
            WATCHTOWER,
            MAINSAIL,
            STEERING,
            DECK_GUN
    };

    ShipBuildingGroupType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShipBuildingGroupType getType(int value) {
        return switch (value) {
            case 1 -> BLANK_ROOM;
            case 2 -> AIR_BLANK_ROOM;
            case 3 -> LADDER_GROUP;
            case 4 -> LADDER_GROUP_2;
            case 5 -> SUNDRIES;
            case 6 -> PARALLEL_CABIN_ENTRANCE;
            case 7 -> VERTICAL_CABIN_ENTRANCE;
            case 1100 -> MAIN_BUILDING;
            case 2100 -> TOOL_ROOM_1;
            case 2200 -> TOOL_ROOM_2;
            case 2300 -> TOOL_ROOM_3;
            case 2400 -> TOOL_ROOM_4;
            case 2500 -> TOOL_ROOM_5;
            case 3100 -> RESEARCH_ROOM;
            case 4100 -> NAVY_ROOM_1;
            case 4200 -> NAVY_ROOM_2;
            case 4300 -> NAVY_ROOM_3;
            case 4400 -> NAVY_ROOM_4;
            case 5100 -> TRAIN_ROOM_1;
            case 5200 -> TRAIN_ROOM_2;
            case 5300 -> TRAIN_ROOM_3;
            case 6100 -> PREPARE_ROOM_1;
            case 6200 -> PREPARE_ROOM_2;
            case 6300 -> PREPARE_ROOM_3;
            case 6400 -> PREPARE_ROOM_4;
            case 7100 -> HOSPITAL;
            case 8100 -> HOLD_1;
            case 8200 -> HOLD_2;
            case 8300 -> HOLD_3;
            case 8400 -> HOLD_4;
            case 9100 -> ACCOUNTING_ROOM;
            case 10100 -> POULTRY_ROOM;
            case 11100 -> WATER_ROOM;
            case 12100 -> KITCHEN;
            case 13100 -> SEARCH_ROOM;
            case 14100 -> RESOURCE_WAREHOUSE;
            case 15100 -> ALLIANCE_HALL;
            case 16100 -> MEDICINE_MATERIAL_ROOM;
            case 20100 -> WATCHTOWER;
            case 20200 -> MAINSAIL;
            case 20300 -> STEERING;
            case 20400 -> DECK_GUN;
            default -> {
                LogUtils.logger.error("ShipBuildingGroupType is not find value:{}",value);
                yield null;
            }
        };
    }
}
