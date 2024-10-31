package com.dreamfun.opg.Player.TaskManager;
import org.slf4j.Logger;
import com.dreamfun.opg.Common.ActionType;
import com.dreamfun.opg.Common.Event.EventService;
import com.dreamfun.opg.Player.IPlayerModelManager;
import com.dreamfun.opg.Player.TaskService;
import com.dreamfun.opg.Player.UserProfile;
import com.dreamfun.opg.utils.GameLoggerFactory;

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
