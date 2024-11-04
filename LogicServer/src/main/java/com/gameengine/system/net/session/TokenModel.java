package com.gameengine.system.net.session;

public class TokenModel {

    public static final int INIT_STATE = 0;
    public static final int VALID_STATE = 1;
    public static final int INVALID_STATE = -1;

    private final String token;
    private final long uid;
    private long expireTime;
    private int gameServerId;
    private int validState;
    private String secretKey;
    private int serverId;
    private int sessionId;

    public TokenModel(String token, long uid) {
        this.token = token;
        this.uid = uid;
    }

    public void setGameServerAndSessionId(int gameServerId, int sessionId) {
        this.gameServerId = gameServerId;
        this.sessionId = sessionId;
    }

    public long getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }


    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public int getValidState() {
        return validState;
    }

    public void setValidState(int validState) {
        this.validState = validState;
    }

    public boolean isInvalid() {
        return validState != VALID_STATE || getExpireTime() < System.currentTimeMillis();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    public int getGameServerId() {
        return gameServerId;
    }

    public void setGameServerId(int gameServerId) {
        this.gameServerId = gameServerId;
    }


    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}