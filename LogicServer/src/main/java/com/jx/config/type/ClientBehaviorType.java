package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ClientBehaviorType
 */
public enum ClientBehaviorType {

    /**
     * 关闭某个界面（arg1:界面PanelType，在Client_Resource_Map中配置）
     */
    CLOSE_UI(1),

    /**
     * 打开某个界面（arg1:界面PanelType，在Client_Resource_Map中配置，arg2：界面参数）
     */
    OPEN_UI(2),

    /**
     * 播放剧情（arg1:剧情Id）
     */
    PLAY_MOVIE(3),

    /**
     * 小世界引导小船去到交互点（arg1:交互点Id）
     */
    GUIDE_BOAT_TO_NEWBIES_POINT(4),

    /**
     * 打开场景（arg1：场景枚举，在Client_Resource_Map中配置）
     */
    OPEN_SCENE(5),

    /**
     * 主动完成任务（arg1:任务Id）
     */
    COMPLETE_TASK(7),

    /**
     * 选中房间（arg1：房间组id）
     */
    SELECT_ROOM(8),

    /**
     * 提示框（arg1：提示多语言id）
     */
    SHOW_TIPS(9),

    /**
     * 打开联盟(未加入联盟：打开加入联盟界面，打开加入联盟场景；已加入联盟：打开联盟界面，打开联盟场景)
     */
    OPEN_ALLIANCE(10),

    /**
     * 大世界引导小船去到具体港口（arg1:港口Id）
     */
    GUIDE_BOAT_TO_PORT(11),

    /**
     * 大世界引导小船去到具体坐标（arg1:x，arg2:y）
     */
    GUIDE_BOAT_TO_POSXY(12),

    /**
     * 选中房间（arg1：房间组id）  从当前相机位置选中房间
     */
    SELECT_ROOM_FROM_CUR_CAM_POS(13),

    /**
     * 选中科技  (arg1:tech_node Id)
     */
    SELECT_TECH_NODE(14),

    /**
     * 跳转到房间工作界面（arg1：房间组id）
     */
    JUMP_ROOM_WORK_PAGE(15),

    /**
     * 打开某个界面再引导（arg1:界面PanelType，arg2：引导id，arg3：界面参数）
     */
    OPEN_UI_THEN_GUIDE(16),

    /**
     * 是否有鱼竿，如果没有引导A，有就切为钓鱼状态 ，并引导B（arg1:引导A的id，arg2：引导B的id）
     */
    SELECT_FISH_THEN_GUIDE(17),

    /**
     * 进入内城 选中房间再引导（arg1：房间GroupId,  arg2：引导id）
     */
    SELECT_ROOM_THEN_GUIDE(18),

    /**
     * 直接触发引导（arg1：引导id）
     */
    START_GUIDE(19),

    /**
     * 进入内城or大世界 对主界面的按钮进行引导（arg1：场景枚举,  arg2：引导id）
     */
    CHANGE_SCENE_THEN_GUIDE_IN_MAIN(20),

    /**
     * 大世界搜索资源（arg1：search表id,  arg2：资源id/野怪id）
     */
    SEARCH_BIGWORLD_UNIT(21),

    /**
     * 大世界引导小船去特定港口（arg1:特定港口类型：1-所有港口中最近的港口、2-未解锁港口中最近的港口）
     */
    GUIDE_BOAT_TO_SPECIAL_PORT(22),

    /**
     * 跳转到房间升级界面（arg1：房间组id）
     */
    JUMP_ROOM_UPGRADE_PAGE(23),

    /**
     * 触发客户端行为组（arg1：行为组id）
     */
    CLIENT_BEHAVIOUR_GROUP(24),

    /**
     * 选中roleId相同的最大/最小等级的房间（arg1：Ship_Building_Group表roleid，arg2: 0 最小/1 最大）
     */
    SELECT_ROOM_SORT_LV(25),

    /**
     * 将某个英雄驻扎到某个房间（arg1：英雄id,  arg2：房间id）
     */
    SHIP_ROOM_STATION_HERO(26),

    /**
     * 交互点   整套行为直接完成（arg1：交互点ID，Newbies_Points_Location）
     */
    COMPLETE_NEWBIE_POINT(27),

    /**
     * 客户端主动触发服务器行为，比如奖励  （arg1：guideEvent的Id）
     */
    TRIGGER_GUIDE_EVENT(28),

    /**
     * 显示距离角色最近的垃圾引导，如果没有就出现tips（arg1：提示多语言id）
     */
    SHOW_RAFT_RUBBLISH_GUIDE(29),

    /**
     * 打开队列的战斗准备界面（arg1：第几个队列）
     */
    OPEN_TEAM_VIEW(30),

    /**
     * 打开打击海盗某个关卡的挑战界面（arg1：打击海盗Layer Id  arg2:第几个怪）
     */
    OPEN_STRIKE_PIRATE(31),

    /**
     * 记录<key,value>（arg1：key arg2：value）
     */
    RECORD_KEY_VALUE(32),

    /**
     * 内城建造房间行为组，房间状态的操作集合（arg1:房间组id，arg2：建造中tips1，arg3：普通状态tips2，arg4：储藏中tips3）
     */
    HOMELAND_BUILD_TRIGGER_GROUP(33),

    /**
     * 内城升级房间行为组，房间状态的操作集合（arg1:房间组id，arg2：建造中tips1，arg3：储藏中tips2）
     */
    HOMELAND_UPGRADE_TRIGGER_GROUP(34),

    ;
    private int value;

    public static ClientBehaviorType[] ARRAY = {
            CLOSE_UI,
            OPEN_UI,
            PLAY_MOVIE,
            GUIDE_BOAT_TO_NEWBIES_POINT,
            OPEN_SCENE,
            COMPLETE_TASK,
            SELECT_ROOM,
            SHOW_TIPS,
            OPEN_ALLIANCE,
            GUIDE_BOAT_TO_PORT,
            GUIDE_BOAT_TO_POSXY,
            SELECT_ROOM_FROM_CUR_CAM_POS,
            SELECT_TECH_NODE,
            JUMP_ROOM_WORK_PAGE,
            OPEN_UI_THEN_GUIDE,
            SELECT_FISH_THEN_GUIDE,
            SELECT_ROOM_THEN_GUIDE,
            START_GUIDE,
            CHANGE_SCENE_THEN_GUIDE_IN_MAIN,
            SEARCH_BIGWORLD_UNIT,
            GUIDE_BOAT_TO_SPECIAL_PORT,
            JUMP_ROOM_UPGRADE_PAGE,
            CLIENT_BEHAVIOUR_GROUP,
            SELECT_ROOM_SORT_LV,
            SHIP_ROOM_STATION_HERO,
            COMPLETE_NEWBIE_POINT,
            TRIGGER_GUIDE_EVENT,
            SHOW_RAFT_RUBBLISH_GUIDE,
            OPEN_TEAM_VIEW,
            OPEN_STRIKE_PIRATE,
            RECORD_KEY_VALUE,
            HOMELAND_BUILD_TRIGGER_GROUP,
            HOMELAND_UPGRADE_TRIGGER_GROUP
    };

    ClientBehaviorType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ClientBehaviorType getType(int value) {
        return switch (value) {
            case 1 -> CLOSE_UI;
            case 2 -> OPEN_UI;
            case 3 -> PLAY_MOVIE;
            case 4 -> GUIDE_BOAT_TO_NEWBIES_POINT;
            case 5 -> OPEN_SCENE;
            case 7 -> COMPLETE_TASK;
            case 8 -> SELECT_ROOM;
            case 9 -> SHOW_TIPS;
            case 10 -> OPEN_ALLIANCE;
            case 11 -> GUIDE_BOAT_TO_PORT;
            case 12 -> GUIDE_BOAT_TO_POSXY;
            case 13 -> SELECT_ROOM_FROM_CUR_CAM_POS;
            case 14 -> SELECT_TECH_NODE;
            case 15 -> JUMP_ROOM_WORK_PAGE;
            case 16 -> OPEN_UI_THEN_GUIDE;
            case 17 -> SELECT_FISH_THEN_GUIDE;
            case 18 -> SELECT_ROOM_THEN_GUIDE;
            case 19 -> START_GUIDE;
            case 20 -> CHANGE_SCENE_THEN_GUIDE_IN_MAIN;
            case 21 -> SEARCH_BIGWORLD_UNIT;
            case 22 -> GUIDE_BOAT_TO_SPECIAL_PORT;
            case 23 -> JUMP_ROOM_UPGRADE_PAGE;
            case 24 -> CLIENT_BEHAVIOUR_GROUP;
            case 25 -> SELECT_ROOM_SORT_LV;
            case 26 -> SHIP_ROOM_STATION_HERO;
            case 27 -> COMPLETE_NEWBIE_POINT;
            case 28 -> TRIGGER_GUIDE_EVENT;
            case 29 -> SHOW_RAFT_RUBBLISH_GUIDE;
            case 30 -> OPEN_TEAM_VIEW;
            case 31 -> OPEN_STRIKE_PIRATE;
            case 32 -> RECORD_KEY_VALUE;
            case 33 -> HOMELAND_BUILD_TRIGGER_GROUP;
            case 34 -> HOMELAND_UPGRADE_TRIGGER_GROUP;
            default -> {
                LogUtils.logger.error("ClientBehaviorType is not find value:{}",value);
                yield null;
            }
        };
    }
}
