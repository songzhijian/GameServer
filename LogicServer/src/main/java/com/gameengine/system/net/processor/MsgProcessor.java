package com.gameengine.system.net.processor;

import com.google.protobuf.MessageLite;
import com.gameengine.system.net.session.GameSession;

public abstract class MsgProcessor<T extends MessageLite> {


    private short msgType;
    private boolean enableProcess = true;
    private boolean battleServerLimit = true;
    public void setMsgType(short msgType) {
        this.msgType = msgType;
    }
    public short getMsgType() {
        return msgType;
    }
    public abstract void process(GameSession session, T msg)
            throws Exception;
    /**
     * 消息间隔,特别processor的可以重载
     * @return
     */
    public short getInterval() {
        return 100;
    }

    public boolean isEnableProcess() {
        return enableProcess;
    }

    public void setEnableProcess(boolean enableProcess) {
        this.enableProcess = enableProcess;
    }
    public boolean isBattleServerLimit() {
        return battleServerLimit;
    }
    public void setBattleServerLimit(boolean battleServerLimit) {
        this.battleServerLimit = battleServerLimit;
    }
    public boolean needSendBattleMsg(){
        return false;
    }
}
