package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TaskType
 */
public enum TaskType {

    /**
     * 章节任务（arg1：章节id）
     */
    CHAPTERS_AND_SECTIONS_TASK(1),

    /**
     * 每日任务
     */
    DAILY_TASKS(2),

    /**
     * 新手任务（arg1：BeginnerTaskId）
     */
    NEW_TASKS(3),

    /**
     * 军备任务 （arg1：活动id）(废弃)
     */
    ARMAMENTS_TASK(4),

    /**
     * 活动任务 （arg1：活动id）
     */
    ACTIVITY_TASK(5),

    /**
     * bp任务（arg1：bp编号）
     */
    BATTLEPASS_TASK(6),

    /**
     * 委托任务
     */
    ENTRUST_TASK(7),

    /**
     * 主线任务
     */
    MAIN_TASK(8),

    /**
     * 支线任务
     */
    BRANCH_TASK(9),

    ;
    private int value;

    public static TaskType[] ARRAY = {
            CHAPTERS_AND_SECTIONS_TASK,
            DAILY_TASKS,
            NEW_TASKS,
            ARMAMENTS_TASK,
            ACTIVITY_TASK,
            BATTLEPASS_TASK,
            ENTRUST_TASK,
            MAIN_TASK,
            BRANCH_TASK
    };

    TaskType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TaskType getType(int value) {
        return switch (value) {
            case 1 -> CHAPTERS_AND_SECTIONS_TASK;
            case 2 -> DAILY_TASKS;
            case 3 -> NEW_TASKS;
            case 4 -> ARMAMENTS_TASK;
            case 5 -> ACTIVITY_TASK;
            case 6 -> BATTLEPASS_TASK;
            case 7 -> ENTRUST_TASK;
            case 8 -> MAIN_TASK;
            case 9 -> BRANCH_TASK;
            default -> {
                LogUtils.logger.error("TaskType is not find value:{}",value);
                yield null;
            }
        };
    }
}
