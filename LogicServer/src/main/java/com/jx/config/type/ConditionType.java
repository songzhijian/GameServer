package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ConditionType
 */
public enum ConditionType {

    /**
     * 建筑等级（arg1:建筑id）
     */
    BUILDING_LEVEL(1),

    /**
     * 英雄职业（arg1:职业类型）
     */
    HERO_ROLE(2),

    /**
     * 英雄阵营（arg1:阵营类型）
     */
    HERO_RACE(3),

    /**
     * 玩法（arg1:TeamGamePlayType）
     */
    TEAM_GAME_PLAY(4),

    /**
     * 玩家注册时间 (arg1:开始时间，arg2:结束时间）
     */
    PLAYER_REGISTER_TIME(5),

    /**
     * 玩家vip等级 (arg1:开始，arg2:结束）
     */
    PLAYER_VIP_LEVEL(6),

    /**
     * 玩家上一次登陆时间 (arg1:开始时间，arg2:结束时间）
     */
    PLAYER_LAST_LOGIN_TIME(7),

    /**
     * 服务器邮件有效时间(arg1:开始时间，arg2:结束时间）
     */
    SERVER_MAIL_TIME(8),

    /**
     * 玩家获取某类道具（arg1:道具子类型）（未实现）
     */
    PLAYER_GET_ITEM(9),

    /**
     * 解锁港口数量(arg1:熟练) 这个只能用于港口商店（因为异步实现）
     */
    UNLOCK_PORTS_NUM(10),

    /**
     * 任务接取和完成(arg1: 任务id, task表id arg2: 任务状态 0=接取 1=完成)
     */
    TASK_STATE(11),

    /**
     * 英雄获取(arg1: 英雄id，关联 hero_detail 表id。 arg2: 英雄品质)
     */
    HERO_GET(12),

    /**
     * 通过关卡(arg1:关卡id，关联Strike_Pirate_Enemy表id)
     */
    PASS_PIRATE(13),

    /**
     * 科技树研究进度(arg1:科技树id,arg2:研究进度)
     */
    TECHTREE_PROGRESS(14),

    /**
     * 完成相应剧情解锁(arg1：剧情id，arg2：任务状态，0=接取 1=完成)
     */
    STORY_STATE(15),

    /**
     * 完成具体科技(arg1:科技id, 关联tech_info表的id)
     */
    COMPLETE_TECH(16),

    /**
     * 联盟等级（arg1:联盟等级）
     */
    ALLIANCE_LEVEL(17),

    /**
     * 内城玩家使用的船限制船长室等级
     */
    SHIP_LIMIT_CAPTAIN_ROOM_LV(18),

    /**
     * 赛季限制船长室等级
     */
    SEASON_LIMIT_CAPTAIN_ROOM_LV(19),

    /**
     * 购买礼包的次数大于等于x次（arg1:礼包id，arg2:次数，arg3：（0或不填=大于等于 1=小于））
     */
    PACKAGE_PURCHASES_MIN_NUM(20),

    /**
     * 英雄品阶（arg1：0=大于等于 1=小于     arg2：Hero_Detail.id    arg3：Hero_Quality.id）
     */
    HERO_MAX_QUALITY(21),

    /**
     * 判断总重伤兵数量或比例(arg1：判断的类型（1=总伤兵数量；2=总伤兵比例）     arg2：0=大于等于，1=小于    arg3：判断值（{参数1} =1时，此处填绝对值，{参数1}=2时，此处填万分比）
     */
    HURT_NAVY_NUM(22),

    /**
     * 判断今日死兵数量或比例(arg1:判断的类型（1=今日死兵总数；2=今日死兵比例）  arg2:判断用（0=大于等于，1=小于）  arg3:判断值（{参数1} =1时，此处填绝对值，{参数1}=2时，此处填万分比）)
     */
    TODAY_DEATH_NAVY_NUM(23),

    /**
     * 总付费额度(arg1=付费计算天数 arg2:判断用（0=大于等于，1=小于）   arg3:判断值，付费数额；单位：美元 )
     */
    RECENTLY_PAY_DOLLAR_PRICE(24),

    /**
     * 玩家注册时间 (arg1:开始时间，arg2:结束时间，-1=没有结束时间），左右闭区间，单位：天。玩家注册当天为第1天
     */
    REGISTER_DAYS(25),

    /**
     * 玩家平台（arg1：0 全平台 1 ios  2 google  )
     */
    PLAYER_PLATFORM(26),

    /**
     * 通过新手关卡(arg1:关卡id，关联Newbies_Points_Enemy表id)
     */
    PASS_NEWBIES_PIRATE(27),

    /**
     * 玩家平台和时间限制 用于全服邮件（arg1：0 全平台 1 ios  2 google ，arg2 开始时间戳 arg3：结束时间戳  )
     */
    PLAYER_PLATFORM_AND_TIME(28),

    /**
     * 玩家拥有的船id（arg1：船id，关联ship表id)
     */
    PLAYER_OWN_SHIP(29),

    /**
     * 冒险等级达到X级（arg1：冒险等级）
     */
    ADVENTURE_LEVEL(30),

    /**
     * 玩家拥有某个道具（arg1：itemId，关联item_info表的id   arg2：打击海盗Layer Id  arg3:第几个怪）(arg2,arg3后续优化干掉,现在在ship Building表中的preconditions字段使用 )
     */
    PLAYER_OWN_ITEM(31),

    /**
     * 商圈信用等级（arg1：商圈，arg2：信用等级)
     */
    BUSINESS_AREA_CREDIBILITY_LV(32),

    /**
     * 建筑等级小于参数（arg1:建筑id）(目前只在Purchase表生效，程序可扩展其他模块)
     */
    BUILDING_LESS_LEVEL(33),

    /**
     * 无条件执行（无参数）
     */
    NO_CONDITION(499),

    /**
     * 某个UI界面是否已经打开（arg1:界面PanelType）
     */
    UIPANEL_IS_OPENED(500),

    /**
     * 是否处于某个场景之中（arg1:场景枚举SceneStateType）
     */
    SCENE_STATE_TYPE(501),

    /**
     * 角色是否创建（无参数）
     */
    CHECK_ROLE_CREATED(502),

    /**
     * 当前主船是否到达某个QR坐标（arg1:主船的QR坐标）
     */
    IS_BOAT_ARRIVED_QR(503),

    /**
     * 是否勾中物体（无参数）
     */
    IS_GET_OBJECT_BY_HOOK(504),

    /**
     * 某个任务是处于未完成状态（arg1:任务id）
     */
    IS_TASK_UNFINISHED(505),

    /**
     * 某个任务是处于完成状态（arg1:任务id）
     */
    IS_TASK_FINISHED(506),

    /**
     * 某个任务是否完成并领奖了（arg1:任务id）
     */
    IS_TASK_GETREWARD(507),

    /**
     * 木筏阶段AI是否被勾起到木筏边（arg1:角色Id）
     */
    IS_AI_HOOKED_TO_SIDE_OF_RAFT(508),

    /**
     * 木筏阶段AI是否已经被救起（arg1:角色Id）
     */
    IS_AI_SAVED(509),

    /**
     * 小船是否碰撞到海盗船（arg1:海盗船Id）
     */
    IS_CRASH_PIRATE(510),

    /**
     * 船只是否泊口（arg1:港口id）
     */
    IS_BOAT_ARRIVED_PORT(511),

    /**
     * 战斗是否放大招了（无参数）
     */
    IS_BATTLE_SKILL(512),

    /**
     * 当前战斗结束结果（arg1:战斗是否胜利，1为胜利，2为失败）
     */
    IS_BATTLE_END(513),

    /**
     * 宝箱是否全都喷完（无参数）
     */
    ALL_TREASURE_EJECTED(514),

    /**
     * 当前主船是否到达某个XY坐标（arg1:世界XY坐标）
     */
    IS_BOAT_ARRIVED_XY(515),

    /**
     * 某个UIWidget是否处于打开状态（arg1:自定义字符串）      （剧情独用，一次性只能有一个UIWidget处于判断状态）
     */
    UIWIDGET_IS_OPEN(516),

    /**
     * 内城场景选中房间后，镜头是否移动完毕（arg1:选中的房间groupId）
     */
    HOMELAND_CAM_MOVE_COMPLETED(517),

    /**
     * 某个场景的内容是否加完（arg1:场景枚举SceneStateType） （剧情独用，要和切场景节点连用！判断场景是否跳转成功。其他情况直接判断此条件我不能保证没问题）
     */
    SCENE_CONTENT_COMPLETED_TYPE(518),

    /**
     * 某个UI界面是否完全显示出来（arg1:界面PanelType）  （剧情独用， 不同界面判断条件不一样，比如主界面是通过CanvasGroup的透明度是否为1来判断界面动画是否完成）
     */
    UIPANEL_SHOW_COMPLETED(519),

    /**
     * 是否处于大世界中（非新手小世界，大世界加载完后置为true）
     */
    IS_BIG_WORLD_MAP(520),

    /**
     * 木筏阶段某个功能是否开启（arg1:功能枚举）
     */
    RAFT_FUNCTION_ON(521),

    /**
     * 木筏阶段AI是否处于某个状态（arg1:角色id，arg2:状态id）
     */
    RAFT_AI_STATE(522),

    /**
     * 木筏阶段是否处于某个漂垃圾阶段（arg1:阶段id）
     */
    RAFT_GARBAGE_STAGE(523),

    /**
     * 布阵战斗前，某个英雄是否未上阵（arg1:英雄id）  （数据在UITeamView中，使用前要保证该界面打开）
     */
    BATTLE_IS_HERO_DOWN(525),

    /**
     * 某个UI界面是否已经打开or某个UI界面是否正在打开（arg1:界面PanelType）
     */
    UIPANEL_IS_OPENING_OR_OPENED(526),

    /**
     * 房间是处于等待点击升级状态（arg1:房间groupId）
     */
    HOMELAND_ROOM_WAIT_CLICK(527),

    /**
     * 房间是否没有建造（arg1:房间groupId）
     */
    HOMELAND_ROOM_NOT_BUILD(528),

    /**
     * 主界面某个功能是否已经开启（arg1:功能枚举Enum）
     */
    IS_FUNCTION_UNLOCK(529),

    /**
     * 特定id的多个英雄中 等级最大的那个是否小于等于特定等级（arg1:英雄id，arg2:等级）
     */
    MULTIPLE_SAME_HERO_MAX_LEVEL_LESS_EQUAL(530),

    /**
     * 房间是处于普通状态（arg1:房间groupId）  啥也不干的状态
     */
    HOMELAND_ROOM_NORMAL(532),

    /**
     * 房间是处于升级状态（arg1:房间groupId）   角色跑过去 + 正在建造的状态
     */
    HOMELAND_ROOM_UPGRADE(533),

    /**
     * 房间是否已经驻扎了某英雄（arg1:房间groupId）
     */
    IS_ROOM_STATIONED(535),

    /**
     * 任何条件的取非（arg1:条件种类，arg2:条件参数，arg3:条件参数，arg4:条件参数）
     */
    NOT_CONDITION(536),

    /**
     * 新手宝箱金币是否激活（arg1:金币index）
     */
    NOVICE_COIN_BOX_ACTIVATED(537),

    /**
     * 是否拥有某个装备（arg1:装备Id   Equip_Detail）
     */
    IS_ALREADY_HAVE_EQUIP(538),

    /**
     * 大世界缩放地图下，点击的物体是否为特定类型（arg1:点击SceneUnitTypeEnum类型）
     */
    BIG_WORLD_CLICK_SCENE_UNIT_TYPE(539),

    /**
     * 鲨鱼轮回是否结束（木筏阶段）
     */
    IS_SHARK_ROUND_OVER(540),

    /**
     * 当前获取装备的总数是否和arg1相等（arg1:装备总数，木筏阶段判断是否获取了章鱼宝箱）
     */
    RAFT_GOT_EQUIP_COUNT(541),

    /**
     * 是否拥有主船数据（如果拥有，大世界一定已经加载完毕）
     */
    BIG_WORLD_IS_SHIP_GO_LOADED(542),

    /**
     * 玩家当前木材是否足够建造木板
     */
    RAFT_CHECK_RES_ENOUGH_BUILD(543),

    /**
     * 当前<key,value>是否与记录在服务器的<key,value>相等（对于节点，直接使用节点Id）
     */
    KEY_VALUE_HAS_RECORDED(544),

    /**
     * 当前客户端版本（arg1: 0-A包，1-B包）
     */
    CLIENT_EDITION(545),

    /**
     * 击杀血帆海盗获取的最新的宝箱的GameObject是否生成完毕（多次击杀会判断最新的宝箱）
     */
    IS_PIRATE_BOX_CREATED(546),

    /**
     * 是否没有可出售的货物了（无参数）
     */
    IS_DOCK_GOODS_EMPTY(547),

    /**
     * 当前泊港的港口是否加载完了气泡节点（无参数）
     */
    IS_ARRIVED_PORT_BUBBLE_LOADED(548),

    /**
     * 是否有足够的资源购买某条船（arg1：船的Id）
     */
    CAN_BUY_SPECIAL_SHIP(549),

    /**
     * 当前船只的船长室等级是否小于等于特定值（arg1：比较的特定等级）
     */
    SHIP_CAPTAIN_ROOM_LEVEL_LESS_EQUAL(550),

    /**
     * 当前船只是否为给定的船只（arg1：船只ConfigId）
     */
    CHECK_SPECIAL_SHIP_BY_ID(551),

    /**
     * 当前任务是否为为显示状态（arg1:任务id）
     */
    IS_TASK_VISIBLE(552),

    /**
     * 距离当前船只附近的若干格内是否存在血帆海盗打死的宝箱（arg1：大世界上的格子数）
     */
    BIG_WORLD_BOX_WHETHER_IN_QR_RANGE(553),

    ;
    private int value;

    public static ConditionType[] ARRAY = {
            BUILDING_LEVEL,
            HERO_ROLE,
            HERO_RACE,
            TEAM_GAME_PLAY,
            PLAYER_REGISTER_TIME,
            PLAYER_VIP_LEVEL,
            PLAYER_LAST_LOGIN_TIME,
            SERVER_MAIL_TIME,
            PLAYER_GET_ITEM,
            UNLOCK_PORTS_NUM,
            TASK_STATE,
            HERO_GET,
            PASS_PIRATE,
            TECHTREE_PROGRESS,
            STORY_STATE,
            COMPLETE_TECH,
            ALLIANCE_LEVEL,
            SHIP_LIMIT_CAPTAIN_ROOM_LV,
            SEASON_LIMIT_CAPTAIN_ROOM_LV,
            PACKAGE_PURCHASES_MIN_NUM,
            HERO_MAX_QUALITY,
            HURT_NAVY_NUM,
            TODAY_DEATH_NAVY_NUM,
            RECENTLY_PAY_DOLLAR_PRICE,
            REGISTER_DAYS,
            PLAYER_PLATFORM,
            PASS_NEWBIES_PIRATE,
            PLAYER_PLATFORM_AND_TIME,
            PLAYER_OWN_SHIP,
            ADVENTURE_LEVEL,
            PLAYER_OWN_ITEM,
            BUSINESS_AREA_CREDIBILITY_LV,
            BUILDING_LESS_LEVEL,
            NO_CONDITION,
            UIPANEL_IS_OPENED,
            SCENE_STATE_TYPE,
            CHECK_ROLE_CREATED,
            IS_BOAT_ARRIVED_QR,
            IS_GET_OBJECT_BY_HOOK,
            IS_TASK_UNFINISHED,
            IS_TASK_FINISHED,
            IS_TASK_GETREWARD,
            IS_AI_HOOKED_TO_SIDE_OF_RAFT,
            IS_AI_SAVED,
            IS_CRASH_PIRATE,
            IS_BOAT_ARRIVED_PORT,
            IS_BATTLE_SKILL,
            IS_BATTLE_END,
            ALL_TREASURE_EJECTED,
            IS_BOAT_ARRIVED_XY,
            UIWIDGET_IS_OPEN,
            HOMELAND_CAM_MOVE_COMPLETED,
            SCENE_CONTENT_COMPLETED_TYPE,
            UIPANEL_SHOW_COMPLETED,
            IS_BIG_WORLD_MAP,
            RAFT_FUNCTION_ON,
            RAFT_AI_STATE,
            RAFT_GARBAGE_STAGE,
            BATTLE_IS_HERO_DOWN,
            UIPANEL_IS_OPENING_OR_OPENED,
            HOMELAND_ROOM_WAIT_CLICK,
            HOMELAND_ROOM_NOT_BUILD,
            IS_FUNCTION_UNLOCK,
            MULTIPLE_SAME_HERO_MAX_LEVEL_LESS_EQUAL,
            HOMELAND_ROOM_NORMAL,
            HOMELAND_ROOM_UPGRADE,
            IS_ROOM_STATIONED,
            NOT_CONDITION,
            NOVICE_COIN_BOX_ACTIVATED,
            IS_ALREADY_HAVE_EQUIP,
            BIG_WORLD_CLICK_SCENE_UNIT_TYPE,
            IS_SHARK_ROUND_OVER,
            RAFT_GOT_EQUIP_COUNT,
            BIG_WORLD_IS_SHIP_GO_LOADED,
            RAFT_CHECK_RES_ENOUGH_BUILD,
            KEY_VALUE_HAS_RECORDED,
            CLIENT_EDITION,
            IS_PIRATE_BOX_CREATED,
            IS_DOCK_GOODS_EMPTY,
            IS_ARRIVED_PORT_BUBBLE_LOADED,
            CAN_BUY_SPECIAL_SHIP,
            SHIP_CAPTAIN_ROOM_LEVEL_LESS_EQUAL,
            CHECK_SPECIAL_SHIP_BY_ID,
            IS_TASK_VISIBLE,
            BIG_WORLD_BOX_WHETHER_IN_QR_RANGE
    };

    ConditionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ConditionType getType(int value) {
        return switch (value) {
            case 1 -> BUILDING_LEVEL;
            case 2 -> HERO_ROLE;
            case 3 -> HERO_RACE;
            case 4 -> TEAM_GAME_PLAY;
            case 5 -> PLAYER_REGISTER_TIME;
            case 6 -> PLAYER_VIP_LEVEL;
            case 7 -> PLAYER_LAST_LOGIN_TIME;
            case 8 -> SERVER_MAIL_TIME;
            case 9 -> PLAYER_GET_ITEM;
            case 10 -> UNLOCK_PORTS_NUM;
            case 11 -> TASK_STATE;
            case 12 -> HERO_GET;
            case 13 -> PASS_PIRATE;
            case 14 -> TECHTREE_PROGRESS;
            case 15 -> STORY_STATE;
            case 16 -> COMPLETE_TECH;
            case 17 -> ALLIANCE_LEVEL;
            case 18 -> SHIP_LIMIT_CAPTAIN_ROOM_LV;
            case 19 -> SEASON_LIMIT_CAPTAIN_ROOM_LV;
            case 20 -> PACKAGE_PURCHASES_MIN_NUM;
            case 21 -> HERO_MAX_QUALITY;
            case 22 -> HURT_NAVY_NUM;
            case 23 -> TODAY_DEATH_NAVY_NUM;
            case 24 -> RECENTLY_PAY_DOLLAR_PRICE;
            case 25 -> REGISTER_DAYS;
            case 26 -> PLAYER_PLATFORM;
            case 27 -> PASS_NEWBIES_PIRATE;
            case 28 -> PLAYER_PLATFORM_AND_TIME;
            case 29 -> PLAYER_OWN_SHIP;
            case 30 -> ADVENTURE_LEVEL;
            case 31 -> PLAYER_OWN_ITEM;
            case 32 -> BUSINESS_AREA_CREDIBILITY_LV;
            case 33 -> BUILDING_LESS_LEVEL;
            case 499 -> NO_CONDITION;
            case 500 -> UIPANEL_IS_OPENED;
            case 501 -> SCENE_STATE_TYPE;
            case 502 -> CHECK_ROLE_CREATED;
            case 503 -> IS_BOAT_ARRIVED_QR;
            case 504 -> IS_GET_OBJECT_BY_HOOK;
            case 505 -> IS_TASK_UNFINISHED;
            case 506 -> IS_TASK_FINISHED;
            case 507 -> IS_TASK_GETREWARD;
            case 508 -> IS_AI_HOOKED_TO_SIDE_OF_RAFT;
            case 509 -> IS_AI_SAVED;
            case 510 -> IS_CRASH_PIRATE;
            case 511 -> IS_BOAT_ARRIVED_PORT;
            case 512 -> IS_BATTLE_SKILL;
            case 513 -> IS_BATTLE_END;
            case 514 -> ALL_TREASURE_EJECTED;
            case 515 -> IS_BOAT_ARRIVED_XY;
            case 516 -> UIWIDGET_IS_OPEN;
            case 517 -> HOMELAND_CAM_MOVE_COMPLETED;
            case 518 -> SCENE_CONTENT_COMPLETED_TYPE;
            case 519 -> UIPANEL_SHOW_COMPLETED;
            case 520 -> IS_BIG_WORLD_MAP;
            case 521 -> RAFT_FUNCTION_ON;
            case 522 -> RAFT_AI_STATE;
            case 523 -> RAFT_GARBAGE_STAGE;
            case 525 -> BATTLE_IS_HERO_DOWN;
            case 526 -> UIPANEL_IS_OPENING_OR_OPENED;
            case 527 -> HOMELAND_ROOM_WAIT_CLICK;
            case 528 -> HOMELAND_ROOM_NOT_BUILD;
            case 529 -> IS_FUNCTION_UNLOCK;
            case 530 -> MULTIPLE_SAME_HERO_MAX_LEVEL_LESS_EQUAL;
            case 532 -> HOMELAND_ROOM_NORMAL;
            case 533 -> HOMELAND_ROOM_UPGRADE;
            case 535 -> IS_ROOM_STATIONED;
            case 536 -> NOT_CONDITION;
            case 537 -> NOVICE_COIN_BOX_ACTIVATED;
            case 538 -> IS_ALREADY_HAVE_EQUIP;
            case 539 -> BIG_WORLD_CLICK_SCENE_UNIT_TYPE;
            case 540 -> IS_SHARK_ROUND_OVER;
            case 541 -> RAFT_GOT_EQUIP_COUNT;
            case 542 -> BIG_WORLD_IS_SHIP_GO_LOADED;
            case 543 -> RAFT_CHECK_RES_ENOUGH_BUILD;
            case 544 -> KEY_VALUE_HAS_RECORDED;
            case 545 -> CLIENT_EDITION;
            case 546 -> IS_PIRATE_BOX_CREATED;
            case 547 -> IS_DOCK_GOODS_EMPTY;
            case 548 -> IS_ARRIVED_PORT_BUBBLE_LOADED;
            case 549 -> CAN_BUY_SPECIAL_SHIP;
            case 550 -> SHIP_CAPTAIN_ROOM_LEVEL_LESS_EQUAL;
            case 551 -> CHECK_SPECIAL_SHIP_BY_ID;
            case 552 -> IS_TASK_VISIBLE;
            case 553 -> BIG_WORLD_BOX_WHETHER_IN_QR_RANGE;
            default -> {
                LogUtils.logger.error("ConditionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
