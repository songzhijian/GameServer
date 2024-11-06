package com.gameengine.system.exception;

public enum GameLoginExceptionType {
    DEVICE_UUID_ERROR("E100123"),   // 设备和帐号不对应
    WHITE_LIST_BAN("E100124")   // 登陆白名单开启
    ;

    private String code;

    GameLoginExceptionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
