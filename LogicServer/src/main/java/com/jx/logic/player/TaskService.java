package com.jx.logic.player;

import com.gameengine.system.common.ActionType;
import com.gameengine.system.common.event.EventService;

/**
 * 统一验证处理
 */
public class TaskService {


    static {
        EventService.subscribe(ActionType.Build_Update, TaskService::triggerTask);
    }


    private static void triggerTask(ActionType actionType, UserProfile userProfile, String s, String s1) {

        userProfile.getUserTaskManager().triggerTask(actionType, userProfile, s, s1);


    }
    /*
     *初始化进度
     */
    public static long initProgress(UserProfile userProfile, ActionType actionType, int eventParam) throws Exception {
        switch (actionType){
            case Build_Update:{
                return 0l;
            }
            default: {
                return 0l;
            }
        }
    }

    /*
     *更新进度
     */
    public static long updateProgress(UserProfile userProfile, ActionType actionType, int eventParam,long oldProgress, Object param) throws Exception {
        switch (actionType){
            case Build_Update:{
                return oldProgress + 1;
            }
            default: {
                return oldProgress + 1;
            }
        }
    }
}
