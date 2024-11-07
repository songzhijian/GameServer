package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成FunctionUnlockType
 */
public enum FunctionUnlockType {

    /**
     * 养成
     */
    HUDGROWTH(101),

    /**
     * 玩法
     */
    HUDMODES(102),

    /**
     * 邮件
     */
    HUDMAIL(103),

    /**
     * 背包
     */
    HUDINVENTORY(104),

    /**
     * 联盟
     */
    HUDALLIANCE(105),

    /**
     * 英雄
     */
    HUDHEROES(106),

    /**
     * 招募
     */
    HUDRECRUIT(107),

    /**
     * 设施
     */
    FACILITIES(201),

    /**
     * 船舱
     */
    CABIN(202),

    /**
     * 任务
     */
    QUESTS(203),

    /**
     * 瞭望台
     */
    WATCHTOWER(204),

    /**
     * 搜索
     */
    SEARCHRESOUCE(205),

    /**
     * 帮助
     */
    HELP(206),

    /**
     * 建造队列
     */
    CONSTRUCTIONQUEUE(207),

    /**
     * 出征队列
     */
    TROOPSQUEUE(208),

    /**
     * 训练队列
     */
    TRAINQUEUE(209),

    /**
     * 科技队列
     */
    TECHQUEUE(210),

    /**
     * VIP功能
     */
    VIPENTRANCE(213),

    /**
     * 活动中心入口
     */
    ACTIVITYCENTERENTRANCE(214),

    /**
     * 商业化活动入口
     */
    BUSINESSCENTERENTRANCE(215),

    /**
     * 标记
     */
    MARK(216),

    /**
     * 坐标查找
     */
    COORDINATELOOKUP(217),

    /**
     * 世界buff
     */
    WORLDBUFF(218),

    /**
     * 赛季入口
     */
    SEANSONENTRANCE(219),

    /**
     * 公告板
     */
    ANNOUNCEENTRANCE(220),

    /**
     * pve2倍加速
     */
    SPEED2(301),

    /**
     * pve4倍加速
     */
    SPEED4(302),

    /**
     * 竞技场跳过
     */
    ARENASKIP(303),

    /**
     * 大世界一键扫荡
     */
    WORLDONECLICKSWEEP(304),

    /**
     * 瞭望台一键完成
     */
    WATCHTOWERONECLICKCOMPLETE(305),

    /**
     * 自动战斗
     */
    AUTOBATTLE(306),

    /**
     * 日常任务
     */
    DAILYTASK(401),

    /**
     * 委托任务
     */
    ENTRUSTTASK(402),

    /**
     * 支线任务
     */
    MAINTASK(403),

    /**
     * 驻港_商店
     */
    PORTSTORE(501),

    /**
     * 驻港_船坞
     */
    PORTDOCK(502),

    /**
     * 驻港_市场
     */
    PORTMARKET(503),

    /**
     * 驻港_仓库
     */
    PORTWAREHOUSE(504),

    /**
     * 世界/主城切换按钮
     */
    BIGWORLDSWITCH(51),

    /**
     * 聊天
     */
    CHAT(52),

    /**
     * 资源展示功能根节点
     */
    ROOTHUDRESOURCE(10),

    /**
     * 木材
     */
    HUDRESOURCEWOOD(11),

    /**
     * 布料
     */
    HUDRESOURCEFABRIC(12),

    /**
     * 金属
     */
    HUDRESOURCEMETAL(13),

    /**
     * 金币
     */
    HUDRESOURCEGOLD(14),

    /**
     * 宝石
     */
    HUDRESOURCEDIAMONDS(15),

    /**
     * 饥饿度
     */
    HUDRESOURCESATIETY(16),

    /**
     * 战争号角
     */
    HUDRESOURCEWARHORN(17),

    /**
     * 魔力水晶
     */
    HUDRESOURCEMAGICCRYSTAL(18),

    /**
     * 普通招募
     */
    RECRUITNORMAL(1001),

    /**
     * 阵营招募
     */
    RECRUITRACE(1002),

    /**
     * 心愿兑换
     */
    WISHEXCHANGE(1003),

    /**
     * 贤者之石
     */
    PHILOSOPHERSTONE(1011),

    /**
     * 无字之书
     */
    WORDLESSBOOK(1012),

    /**
     * 神器
     */
    ARTIFACT(1013),

    /**
     * 打击海盗
     */
    STRIKEPIRATE(1021),

    /**
     * 探索
     */
    EXPLORE(1022),

    /**
     * 角斗场
     */
    ARENA(1023),

    /**
     * 秘境
     */
    MAZE(1024),

    /**
     * 自动烹饪
     */
    AUTOCOOK(1031),

    /**
     * 世界队列1
     */
    BOAT_1(1041),

    /**
     * 世界队列2
     */
    BOAT_2(1042),

    /**
     * 世界队列3
     */
    BOAT_3(1043),

    /**
     * 世界队列4
     */
    BOAT_4(1044),

    /**
     * 世界队列1-槽位3
     */
    BOAT_1_POS_3(1051),

    /**
     * 世界队列1-槽位4
     */
    BOAT_1_POS_4(1052),

    /**
     * 世界队列1-槽位5
     */
    BOAT_1_POS_5(1053),

    /**
     * 世界队列2-槽位3
     */
    BOAT_2_POS_3(1054),

    /**
     * 世界队列2-槽位4
     */
    BOAT_2_POS_4(1055),

    /**
     * 世界队列2-槽位5
     */
    BOAT_2_POS_5(1056),

    /**
     * 世界队列3-槽位3
     */
    BOAT_3_POS_3(1057),

    /**
     * 世界队列3-槽位4
     */
    BOAT_3_POS_4(1058),

    /**
     * 世界队列3-槽位5
     */
    BOAT_3_POS_5(1059),

    /**
     * 世界队列4-槽位3
     */
    BOAT_4_POS_3(1060),

    /**
     * 世界队列4-槽位4
     */
    BOAT_4_POS_4(1061),

    /**
     * 世界队列4-槽位5
     */
    BOAT_4_POS_5(1062),

    /**
     * 房间升级-立即完成可减少的时间（单位：秒）
     */
    ROOMIMMEDIATELYUPGRADEREDUCESECOND(1101),

    /**
     * 推图-挂机奖励宝箱
     */
    STRIKEPIRATEHANGUPBOX(1102),

    /**
     * 推图-快速挂机
     */
    STRIKEPIRATEQUICKHANGUP(1103),

    /**
     * 扫荡功能
     */
    SWEEPING_MONSTER(3001),

    /**
     * 镜头锁定
     */
    BOAT_CAMERA_LOCK(4001),

    /**
     * 小地图
     */
    SMALL_MAP(4002),

    ;
    private int value;

    public static FunctionUnlockType[] ARRAY = {
            HUDGROWTH,
            HUDMODES,
            HUDMAIL,
            HUDINVENTORY,
            HUDALLIANCE,
            HUDHEROES,
            HUDRECRUIT,
            FACILITIES,
            CABIN,
            QUESTS,
            WATCHTOWER,
            SEARCHRESOUCE,
            HELP,
            CONSTRUCTIONQUEUE,
            TROOPSQUEUE,
            TRAINQUEUE,
            TECHQUEUE,
            VIPENTRANCE,
            ACTIVITYCENTERENTRANCE,
            BUSINESSCENTERENTRANCE,
            MARK,
            COORDINATELOOKUP,
            WORLDBUFF,
            SEANSONENTRANCE,
            ANNOUNCEENTRANCE,
            SPEED2,
            SPEED4,
            ARENASKIP,
            WORLDONECLICKSWEEP,
            WATCHTOWERONECLICKCOMPLETE,
            AUTOBATTLE,
            DAILYTASK,
            ENTRUSTTASK,
            MAINTASK,
            PORTSTORE,
            PORTDOCK,
            PORTMARKET,
            PORTWAREHOUSE,
            BIGWORLDSWITCH,
            CHAT,
            ROOTHUDRESOURCE,
            HUDRESOURCEWOOD,
            HUDRESOURCEFABRIC,
            HUDRESOURCEMETAL,
            HUDRESOURCEGOLD,
            HUDRESOURCEDIAMONDS,
            HUDRESOURCESATIETY,
            HUDRESOURCEWARHORN,
            HUDRESOURCEMAGICCRYSTAL,
            RECRUITNORMAL,
            RECRUITRACE,
            WISHEXCHANGE,
            PHILOSOPHERSTONE,
            WORDLESSBOOK,
            ARTIFACT,
            STRIKEPIRATE,
            EXPLORE,
            ARENA,
            MAZE,
            AUTOCOOK,
            BOAT_1,
            BOAT_2,
            BOAT_3,
            BOAT_4,
            BOAT_1_POS_3,
            BOAT_1_POS_4,
            BOAT_1_POS_5,
            BOAT_2_POS_3,
            BOAT_2_POS_4,
            BOAT_2_POS_5,
            BOAT_3_POS_3,
            BOAT_3_POS_4,
            BOAT_3_POS_5,
            BOAT_4_POS_3,
            BOAT_4_POS_4,
            BOAT_4_POS_5,
            ROOMIMMEDIATELYUPGRADEREDUCESECOND,
            STRIKEPIRATEHANGUPBOX,
            STRIKEPIRATEQUICKHANGUP,
            SWEEPING_MONSTER,
            BOAT_CAMERA_LOCK,
            SMALL_MAP
    };

    FunctionUnlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FunctionUnlockType getType(int value) {
        return switch (value) {
            case 101 -> HUDGROWTH;
            case 102 -> HUDMODES;
            case 103 -> HUDMAIL;
            case 104 -> HUDINVENTORY;
            case 105 -> HUDALLIANCE;
            case 106 -> HUDHEROES;
            case 107 -> HUDRECRUIT;
            case 201 -> FACILITIES;
            case 202 -> CABIN;
            case 203 -> QUESTS;
            case 204 -> WATCHTOWER;
            case 205 -> SEARCHRESOUCE;
            case 206 -> HELP;
            case 207 -> CONSTRUCTIONQUEUE;
            case 208 -> TROOPSQUEUE;
            case 209 -> TRAINQUEUE;
            case 210 -> TECHQUEUE;
            case 213 -> VIPENTRANCE;
            case 214 -> ACTIVITYCENTERENTRANCE;
            case 215 -> BUSINESSCENTERENTRANCE;
            case 216 -> MARK;
            case 217 -> COORDINATELOOKUP;
            case 218 -> WORLDBUFF;
            case 219 -> SEANSONENTRANCE;
            case 220 -> ANNOUNCEENTRANCE;
            case 301 -> SPEED2;
            case 302 -> SPEED4;
            case 303 -> ARENASKIP;
            case 304 -> WORLDONECLICKSWEEP;
            case 305 -> WATCHTOWERONECLICKCOMPLETE;
            case 306 -> AUTOBATTLE;
            case 401 -> DAILYTASK;
            case 402 -> ENTRUSTTASK;
            case 403 -> MAINTASK;
            case 501 -> PORTSTORE;
            case 502 -> PORTDOCK;
            case 503 -> PORTMARKET;
            case 504 -> PORTWAREHOUSE;
            case 51 -> BIGWORLDSWITCH;
            case 52 -> CHAT;
            case 10 -> ROOTHUDRESOURCE;
            case 11 -> HUDRESOURCEWOOD;
            case 12 -> HUDRESOURCEFABRIC;
            case 13 -> HUDRESOURCEMETAL;
            case 14 -> HUDRESOURCEGOLD;
            case 15 -> HUDRESOURCEDIAMONDS;
            case 16 -> HUDRESOURCESATIETY;
            case 17 -> HUDRESOURCEWARHORN;
            case 18 -> HUDRESOURCEMAGICCRYSTAL;
            case 1001 -> RECRUITNORMAL;
            case 1002 -> RECRUITRACE;
            case 1003 -> WISHEXCHANGE;
            case 1011 -> PHILOSOPHERSTONE;
            case 1012 -> WORDLESSBOOK;
            case 1013 -> ARTIFACT;
            case 1021 -> STRIKEPIRATE;
            case 1022 -> EXPLORE;
            case 1023 -> ARENA;
            case 1024 -> MAZE;
            case 1031 -> AUTOCOOK;
            case 1041 -> BOAT_1;
            case 1042 -> BOAT_2;
            case 1043 -> BOAT_3;
            case 1044 -> BOAT_4;
            case 1051 -> BOAT_1_POS_3;
            case 1052 -> BOAT_1_POS_4;
            case 1053 -> BOAT_1_POS_5;
            case 1054 -> BOAT_2_POS_3;
            case 1055 -> BOAT_2_POS_4;
            case 1056 -> BOAT_2_POS_5;
            case 1057 -> BOAT_3_POS_3;
            case 1058 -> BOAT_3_POS_4;
            case 1059 -> BOAT_3_POS_5;
            case 1060 -> BOAT_4_POS_3;
            case 1061 -> BOAT_4_POS_4;
            case 1062 -> BOAT_4_POS_5;
            case 1101 -> ROOMIMMEDIATELYUPGRADEREDUCESECOND;
            case 1102 -> STRIKEPIRATEHANGUPBOX;
            case 1103 -> STRIKEPIRATEQUICKHANGUP;
            case 3001 -> SWEEPING_MONSTER;
            case 4001 -> BOAT_CAMERA_LOCK;
            case 4002 -> SMALL_MAP;
            default -> {
                LogUtils.logger.error("FunctionUnlockType is not find value:{}",value);
                yield null;
            }
        };
    }
}
