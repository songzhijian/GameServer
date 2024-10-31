package com.dreamfun.opg.Common.Event;

import com.dreamfun.opg.Common.ActionType;
import com.dreamfun.opg.Player.UserProfile;

public interface IEventFunction {

    void function(ActionType type, UserProfile userprofile, String para1, String para2 );
}
