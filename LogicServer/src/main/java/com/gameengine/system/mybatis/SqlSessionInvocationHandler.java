package com.gameengine.system.mybatis;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlSessionInvocationHandler implements InvocationHandler {

    private SqlSession session;

    private long startTime = System.currentTimeMillis();
    private static Map<SqlSession, List<String>>  notCloseSessionMap = new ConcurrentHashMap<>();

    public SqlSessionInvocationHandler(SqlSession session) {
        this.session = session;

        List<String> sessionStack = getStack(15,2);
        notCloseSessionMap.put(session,sessionStack);
    }

    public static List<String> getStack(int maxNumber,int startNumber){
        startNumber = startNumber < 1 ? 1:startNumber;
        Exception stack = new Exception();
        StackTraceElement[] list = stack.getStackTrace();
        List<String> stackStrList = new LinkedList<>();
        for(int i=startNumber;i<list.length;i++){
            stackStrList.add(list[i].toString());
            if(i==maxNumber){
                break;
            }
        }
        return stackStrList;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object invokeRet = null;
        try{
            invokeRet = method.invoke(session, args);
        }finally {
            if("close".equals(methodName)){
                List<String> recordStack  = notCloseSessionMap.remove(session);
                if(System.currentTimeMillis()-startTime>1000){
                    StringBuilder stringBuilder = new StringBuilder("has SqlSession time ");
                    stringBuilder.append(System.currentTimeMillis()-startTime).append(" ms ").append("\n");
                    recordStack.forEach(s->{
                        stringBuilder.append(s).append("\n");
                    });
                }

            }
        }

        return invokeRet;
    }


    public static List<String> printAllNotCloseSession(){
        List<String> retList = new LinkedList<>();
        Iterator<Map.Entry<SqlSession, List<String>>> iter = notCloseSessionMap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<SqlSession, List<String>> entry = iter.next();
            StringBuilder stringBuilder = new StringBuilder("------------------------------------------------\n");
            retList.add("------------------------------------------------");
            entry.getValue().forEach(s->{
                retList.add(s);
                stringBuilder.append(s).append("\n");
            });
        }

        return retList;
    }
}
