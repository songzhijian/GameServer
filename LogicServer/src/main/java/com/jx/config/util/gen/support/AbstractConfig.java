package com.jx.config.util.gen.support;

public abstract class AbstractConfig implements IConfig {
    private boolean timeout;

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }
}
