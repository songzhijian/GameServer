package com.gameengine.system.common.event;

import com.gameengine.system.common.ActionType;
import com.jx.logic.player.UserProfile;

public interface IEventFunction {

    void function(ActionType type, UserProfile userprofile, String para1, String para2 );
}
