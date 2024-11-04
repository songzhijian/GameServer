package com.gameengine.system;

import com.gameengine.system.net.server.ServerNettyService;
import com.gameengine.system.net.session.SessionService;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.util.Iterator;

public class GameCoreServiceManager {
    private ImmutableMap<Object, Object> coreServiceMap;

    public void init() throws Exception {
        this.coreServiceMap = ImmutableMap.builder()
                .put(SessionService.getInstance().getServiceType(), SessionService.getInstance())
                .put(RequestHandlerService.getInstance().getServiceType(), RequestHandlerService.getInstance())
                .put(ServerNettyService.getInstance().getServiceType(), ServerNettyService.getInstance()).build();

        for (Object o : this.coreServiceMap.values()) {
            AbstractGameCoreService coreService = (AbstractGameCoreService) o;
            coreService.init();
        }
    }

    public void start() throws Exception {
        for (Object o : this.coreServiceMap.values()) {
            AbstractGameCoreService coreService = (AbstractGameCoreService) o;
            coreService.start();
        }
    }

    public void stop() throws Exception {
        if(this.coreServiceMap != null) {
            for (Object o : this.coreServiceMap.values()) {
                AbstractGameCoreService coreService = (AbstractGameCoreService) o;
                coreService.stop();
            }
        }
    }

    public Optional getGameCoreService(GameCoreServiceType serviceType) {
        return Optional.fromNullable(this.coreServiceMap.get(serviceType));
    }
}

