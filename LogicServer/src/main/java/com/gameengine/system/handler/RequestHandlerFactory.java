package com.gameengine.system.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestHandlerFactory {
    private final Map<Integer, Class<?>> handlers = new ConcurrentHashMap<>();

    public void addHandler(Integer messageId, Class<?> handlerClass) {
        this.handlers.put(messageId, handlerClass);
    }

    public synchronized void clearAll() {
        this.handlers.clear();
    }

    public synchronized void removeHandler(Integer messageId) {
        this.handlers.remove(messageId);
    }

    public Object findHandler(Integer messageId) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> handlerClass = this.handlers.get(messageId);
        if (handlerClass == null) {
            return null;
        }
        return handlerClass.getDeclaredConstructor().newInstance();
    }
}
