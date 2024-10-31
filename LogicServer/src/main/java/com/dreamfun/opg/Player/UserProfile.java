package com.dreamfun.opg.Player;

import com.dreamfun.opg.Player.TaskManager.UserTaskManager;

public class UserProfile {

    private transient UserTaskManager userTaskManager;

    public UserTaskManager getUserTaskManager() {
        return userTaskManager;
    }

    public void setUserTaskManager(UserTaskManager userTaskManager) {
        this.userTaskManager = userTaskManager;
    }
}
