package com.gameengine.system.mybatis;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SqlSessionOnlyReadInvocationHandler implements InvocationHandler {

    private SqlSession session;

    public SqlSessionOnlyReadInvocationHandler(SqlSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if("commit".equals(methodName)){
            throw new RuntimeException("this session only readData");
        }

        return method.invoke(session, args);
    }
}