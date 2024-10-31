package com.dreamfun.opg.manager;

import com.gameengine.system.net.session.GameSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameSessionManager {

    private Map<Integer, GameSession> sessionMap = new ConcurrentHashMap<>();


    private GameSessionManager(){}

    private static  GameSessionManager instance = new GameSessionManager();

    public static GameSessionManager getInstance(){
        return instance;
    }

    public void addSession(GameSession session) {
        sessionMap.put(session.getId(),session);
    }
}
