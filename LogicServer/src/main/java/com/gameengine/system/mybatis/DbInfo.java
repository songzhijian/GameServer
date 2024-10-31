package com.gameengine.system.mybatis;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

import java.util.Objects;

@ProtobufClass
public class DbInfo {

    @Protobuf(fieldType = FieldType.INT32,order = 1, required = false)
    private int serverId;

    @Protobuf(fieldType = FieldType.STRING,order = 2, required = false)
    private String username;

    @Protobuf(fieldType = FieldType.STRING,order = 3, required = false)
    private String passworld;

    @Protobuf(fieldType = FieldType.STRING,order = 4, required = false)
    private String jdbcUrl;

    @Protobuf(fieldType = FieldType.STRING,order = 5, required = false)
    private String driver;


    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DbInfo dbInfo = (DbInfo) o;
        return serverId == dbInfo.serverId && Objects.equals(username, dbInfo.username) && Objects.equals(passworld, dbInfo.passworld) && Objects.equals(jdbcUrl, dbInfo.jdbcUrl) && Objects.equals(driver, dbInfo.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverId, username, passworld, jdbcUrl);
    }

    @Override
    public String toString() {
        return "DbInfo{" +
                "serverId=" + serverId +
                ", username='" + username + '\'' +
                ", passworld='" + passworld + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", driver='" + jdbcUrl + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}

