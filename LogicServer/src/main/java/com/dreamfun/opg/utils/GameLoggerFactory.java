package com.dreamfun.opg.utils;

import com.dreamfun.opg.exception.ExceptionMonitorType;
import com.dreamfun.opg.exception.GameLoginExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameLoggerFactory {
    //协议日志
//    public static final Logger CMD_LOGGER = LoggerFactory.getLogger("CMD");


    //1为服务器id
    public static Logger getLogger(String name)
    {
        return LoggerFactory.getLogger(String.format("%s-%s", name, Constants.SERVER_ID));
    }
    public static Logger getLogger(Class<?> clazz)
    {
        return LoggerFactory.getLogger(String.format("%s-%s", clazz.getName(), Constants.SERVER_ID));
    }


    public static String formatLog(ExceptionMonitorType type, String user, String desc) {
        return formatLog(type, "", user, "", desc);
    }

    public static String formatLog(ExceptionMonitorType type, String user, String ip, String desc) {
        return formatLog(type, "", user, ip, desc);
    }

    public static String formatLog(ExceptionMonitorType type, GameLoginExceptionType subType, String user, String desc) {
        return formatLog(type, subType, user, "", desc);
    }

    public static String formatLog(ExceptionMonitorType type, GameLoginExceptionType subType, String user, String ip, String desc) {
        return formatLog(type, subType.toString(), user, ip, desc);
    }

    public static String formatLog(ExceptionMonitorType type, String subTypeString, String user, String ip, String desc) {
        StringBuilder log = new StringBuilder(Constants.SERVER_ID)
                .append(Constants.LOG_SEPARATOR).append(type.toString())
                .append(Constants.LOG_SEPARATOR).append(subTypeString)//子类型
                .append(Constants.LOG_SEPARATOR).append(user)
                .append(Constants.LOG_SEPARATOR).append(ip)
                .append(Constants.LOG_SEPARATOR).append(desc);
        return log.toString();
    }

}
