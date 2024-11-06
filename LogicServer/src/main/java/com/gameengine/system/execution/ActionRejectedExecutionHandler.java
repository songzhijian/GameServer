package com.gameengine.system.execution;

import com.gameengine.system.utils.GameLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ActionRejectedExecutionHandler implements RejectedExecutionHandler {
    private static final Logger logger = GameLoggerFactory.getLogger(ActionRejectedExecutionHandler.class);
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.info("ThreadPoolExecutor {} rejected action is GameRequestAction {}, actionInfo:{} "
                ,executor,r instanceof GameRequestAction, r.toString() );
    }
}

