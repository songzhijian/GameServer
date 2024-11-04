package com.gameengine.system.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ActionRejectedExecutionHandler implements RejectedExecutionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ActionRejectedExecutionHandler.class);
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.info("ThreadPoolExecutor {} rejected action is GameRequestAction {}, actionInfo:{} "
                ,executor,r instanceof GameRequestAction, r.toString() );
    }
}

