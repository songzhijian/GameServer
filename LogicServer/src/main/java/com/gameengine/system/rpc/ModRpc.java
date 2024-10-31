package com.gameengine.system.rpc;

/**
 * TODO://需要调用初始化
 */
public class ModRpc {

    //@Override
    public int onServerStartPre() {

        IRpc.regService(IDefaultService.class, new DefaultServiceImpl());

        return 0;
    }

    //@Override
    public int onServerStartOkPre() {

        ManagerRpc.startServiceAll();

        return 0;
    }
}
