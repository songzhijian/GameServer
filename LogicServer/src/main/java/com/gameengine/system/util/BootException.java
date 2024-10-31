package com.gameengine.system.util;

public class BootException extends RuntimeException{
    public BootException() {
    }

    public BootException(String message) {
        super(message);
    }

    public BootException(String message, Throwable cause) {
        super(message, cause);
    }

    public BootException(Throwable cause) {
        super(cause);
    }
}
