package com.jx.logic.player.TaskManager;
import com.gameengine.system.common.ActionType;
import com.jx.logic.player.IPlayerModelManager;
import com.jx.logic.player.TaskService;
import com.jx.logic.player.UserProfile;
import com.gameengine.system.utils.GameLoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  *  任务管理
  *  进度初始化去TaskService::initProgress取
 */
public  class UserTaskManager implements IPlayerModelManager {

    private static final Logger logger = GameLoggerFactory.getLogger(UserTaskManager.class);

    private Map<ActionType, List<UserTask>> taskListMap = new HashMap();
    

//    static {
//        EventService.subscribe(ActionType.Build_Update,UserTaskManager::triggerTask);
//    }

    synchronized public void triggerTask(ActionType actionType, UserProfile userProfile, String s, String s1) {

        List<UserTask> taskList =  userProfile.getUserTaskManager().getTaskListMap().get(actionType);
        if(taskList==null)return;

        for (UserTask task:taskList){
            if(task.state!=AbstractTask.TaskState.ACCEPT.ordinal())continue;

            try {
                //最新进度
                long newProgress = TaskService.updateProgress(userProfile,actionType,0,task.getNum(),null);
            }catch (Exception e) {
                e.printStackTrace();
            }

            // task.handleTask(actionType,...)
            // task.isCompleted()

        }
    }


    public Map<ActionType, List<UserTask>> getTaskListMap() {
        return taskListMap;
    }

    public void setTaskListMap(Map<ActionType, List<UserTask>> taskListMap) {
        this.taskListMap = taskListMap;
    }
}
