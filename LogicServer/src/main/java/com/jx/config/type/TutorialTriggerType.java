package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TutorialTriggerType
 */
public enum TutorialTriggerType {

    /**
     * 直接触发引导（arg1：引导ID）
     */
    GUIDE_TRIGGERDIRECTLY(1),

    /**
     * 任务接取时触发（arg1：任务ID）
     */
    TASK_UNFINISHED(2),

    /**
     * 任务完成未领取（arg1：任务ID）
     */
    TASK_FINISHED(3),

    /**
     * 任务完成并领取奖励后触发（arg1：任务ID）
     */
    TASK_GETREWARD(4),

    /**
     * 等待剧情节点触发（arg1：引导ID）
     */
    MOVIE_ACTION(5),

    /**
     * 打开某个界面时触发（arg1：界面名）
     */
    UI_PANEL(6),

    /**
     * 打开某个Widget时触发（arg1：界面名）
     */
    UI_WIDGET(7),

    /**
     * 关闭某个界面时触发（arg1：界面名）
     */
    UI_PANEL_CLOSE(8),

    ;
    private int value;

    public static TutorialTriggerType[] ARRAY = {
            GUIDE_TRIGGERDIRECTLY,
            TASK_UNFINISHED,
            TASK_FINISHED,
            TASK_GETREWARD,
            MOVIE_ACTION,
            UI_PANEL,
            UI_WIDGET,
            UI_PANEL_CLOSE
    };

    TutorialTriggerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TutorialTriggerType getType(int value) {
        return switch (value) {
            case 1 -> GUIDE_TRIGGERDIRECTLY;
            case 2 -> TASK_UNFINISHED;
            case 3 -> TASK_FINISHED;
            case 4 -> TASK_GETREWARD;
            case 5 -> MOVIE_ACTION;
            case 6 -> UI_PANEL;
            case 7 -> UI_WIDGET;
            case 8 -> UI_PANEL_CLOSE;
            default -> {
                LogUtils.logger.error("TutorialTriggerType is not find value:{}",value);
                yield null;
            }
        };
    }
}
