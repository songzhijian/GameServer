package com.jx.exception;

import com.gameengine.system.utils.GameLoggerFactory;
import com.gameengine.system.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.util.Arrays;

public class GameException extends Exception {

    private static final Logger logger = GameLoggerFactory.getLogger(GameException.class);

    @Serial
    private static final long serialVersionUID = 460936103643450438L;
    private int errorCode;

    private String[] params;

    public GameException(int errorCode) {
        super(String.format("errorCode : %d", errorCode));
        this.errorCode = errorCode;
    }

    public GameException(int errorCode, String message, Object... args) {
        super(String.format("errorCode : %d, message : %s", errorCode, LogUtils.formatDialogString(message, args)));
        this.errorCode = errorCode;
    }

    public GameException(int errorCode, String[] params, String message, Object... args) {
        super(String.format("errorCode : %d, param : " + Arrays.toString(params) + ", message : %s", errorCode,
                LogUtils.formatDialogString(message, args)));
        this.errorCode = errorCode;
        this.params = params;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
