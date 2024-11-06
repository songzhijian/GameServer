package com.jx.logic.player;

import com.jx.logic.player.TaskManager.UserTaskManager;

public class UserProfile {

    private transient UserTaskManager userTaskManager;

    public UserTaskManager getUserTaskManager() {
        return userTaskManager;
    }

    public void setUserTaskManager(UserTaskManager userTaskManager) {
        this.userTaskManager = userTaskManager;
    }
}
