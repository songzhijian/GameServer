package com.gameengine.system.mybatis;

import com.Common.serializable.SerializerUtils;
import org.apache.curator.framework.CuratorFramework;

public class DbInfoRegister {
    private DbInfo newDbInfo;

    private CuratorFramework client;

    private String zookeeperNodePath;

    public DbInfoRegister(DbInfo newDbInfo, CuratorFramework client, String zookeeperNodePath) {
        this.newDbInfo = newDbInfo;
        this.client = client;
        this.zookeeperNodePath = zookeeperNodePath;
    }

    private boolean checkNeedRegister() throws Exception {
        if (client.checkExists().forPath(this.zookeeperNodePath) == null) {
            return true;
        }
        byte[] data = client.getData().forPath(this.zookeeperNodePath);
        if (data == null || data.length < 1) {
            return true;
        }
        DbInfo oldDbInfo = SerializerUtils.deserialize(data, DbInfo.class);
        if (!newDbInfo.equals(oldDbInfo)) {
            return true;
        }
        return false;
    }

    private void registerDbInfo() throws Exception {
        byte[] data = SerializerUtils.serialize(newDbInfo, DbInfo.class);
        client.create().orSetData().creatingParentsIfNeeded().forPath(this.zookeeperNodePath, data);
    }

    public void register() throws Exception {
        if (this.checkNeedRegister()) {
            this.registerDbInfo();
        }
    }
}
