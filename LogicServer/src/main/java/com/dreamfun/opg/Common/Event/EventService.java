package com.dreamfun.opg.Common.Event;

import com.dreamfun.opg.Common.ActionType;
import com.dreamfun.opg.Player.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
/*
 事件注册触发
 */
public  class EventService {


    static private Map<ActionType, List<IEventFunction>>  mapEvent = new HashMap<>();
    /*
    注册事件
     */
    static public synchronized void subscribe( ActionType type,  IEventFunction function ){
        List<IEventFunction> list = mapEvent.computeIfAbsent(type,  k -> new ArrayList<>());
        list.add(function);
    }
    /*
    触发事件
     */
    void fire(ActionType type, UserProfile userProfile, String para1, String para2 ){

        List<IEventFunction> list = mapEvent.get(type);
        if( list == null )
            return;

        for( IEventFunction event:list ){
            event.function( type, userProfile, para1, para2 );
        }
    }
}
