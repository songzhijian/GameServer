package com.gameengine.system.mybatis;

import com.dreamfun.opg.GameServer;
import org.apache.curator.framework.CuratorFramework;

public class DbInfoRegisterBuilder {
    private CuratorFramework client;

    private String zookeeperNodePath;

    private String user;

    private String password;

    private String jdbcUrl;

    private int serverId;

    private String driver;

    public DbInfoRegisterBuilder setClient(CuratorFramework client) {
        this.client = client;
        return this;
    }

    public DbInfoRegisterBuilder setZookeeperNodePath(String zookeeperNodePath) {
        this.zookeeperNodePath = zookeeperNodePath;
        return this;
    }

    public DbInfoRegisterBuilder setUserKey(String userKey) {
        String realUser = GameServer.getInstance().getConfigProperties().getProperty(userKey);
        this.user = realUser;
        return this;
    }

    public DbInfoRegisterBuilder setPasswordKey(String passwordKey) {
        String realPassWord = GameServer.getInstance().getConfigProperties().getProperty(passwordKey);
        this.password = realPassWord;
        return this;
    }

    public DbInfoRegisterBuilder setJdbcUrlKey(String jdbcUrlKey) {
        String realJdbcUrl = GameServer.getInstance().getConfigProperties().getProperty(jdbcUrlKey);
        this.jdbcUrl = realJdbcUrl;
        return this;
    }

    public DbInfoRegisterBuilder setServerId(int serverId) {
        this.serverId = serverId;
        return this;
    }

    public DbInfoRegister build() {
        DbInfo dbInfo = new DbInfo();
        dbInfo.setServerId(this.serverId);
        dbInfo.setJdbcUrl(this.jdbcUrl);
        dbInfo.setPassworld(this.password);
        dbInfo.setUsername(this.user);
        dbInfo.setDriver(this.driver);
        DbInfoRegister register = new DbInfoRegister(dbInfo, client, zookeeperNodePath);
        return register;
    }

    public String getDriver() {
        return driver;
    }

    public DbInfoRegisterBuilder setDriver(String driverKey) {
        String realDriver = GameServer.getInstance().getConfigProperties().getProperty(driverKey);
        this.driver = realDriver;
        return this;
    }
}
