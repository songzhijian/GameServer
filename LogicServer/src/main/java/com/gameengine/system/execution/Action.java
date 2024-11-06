package com.gameengine.system.execution;

import com.gameengine.system.utils.GameLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public abstract class Action implements Runnable {
    private static final Logger logger = GameLoggerFactory.getLogger(Action.class);
    private ActionQueue queue;
    protected long createTime;
    private long slowRequestMilliSecond = 1000L;

    private long handleTimeOut = 200;//200 ms

    public static long waitTimeOut = 10000l; //10秒

    public static boolean useAsync = false;

    public Action(ActionQueue queue) {
        this.queue = queue;
        this.createTime = System.currentTimeMillis();
    }

    public long getSlowRequestMilliSecond() {
        return this.slowRequestMilliSecond;
    }

    public void setSlowRequestMilliSecond(long slowRequestMilliSecond) {
        this.slowRequestMilliSecond = slowRequestMilliSecond;
    }

    public void enqueue() {
        this.queue.enqueue(this);
    }

    public void run() {

        if(this.queue != null) {
            try{
                if(useAsync){
                    try {
                        boolean over = processAsyn().get(handleTimeOut, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        logger.error(getClass().getSimpleName(),e);
                    } catch (ExecutionException e) {
                        logger.error(getClass().getSimpleName(),e);
                    } catch (TimeoutException e) { //Timeou 不打印
                        e.printStackTrace();
                    }
                }else {
                    process();
                }
            }finally {
                this.queue.dequeue(this);
                RequestHandlerService.queueActionNumber.decrementAndGet();
            }
        }

    }

    private Future<Boolean> processAsyn() {
        return CompletableFuture.supplyAsync(()->{
            process();
            return true;
        });
    }

    private void process() {
        long start = System.currentTimeMillis();
        try {
            long waitTime = start - createTime;
            if(waitTime>waitTimeOut){
                logger.info("[WAIT_TIME_OUT] WaitTime: {} REQ: {}", new Object[]{Long.valueOf( waitTime),this.toString()});
            }else {
                this.execute();
                long e = System.currentTimeMillis();
                long handleTime = e - start;
                long totalTime = e - this.createTime;

                if(totalTime >= this.slowRequestMilliSecond) {
                    if (handleTime >= 1000) {
                        logger.info("[SLOW_REQ_HANDLE] WaitTime: {} HandleTime: {} TotalTime: {} REQ: {}",
                                new Object[]{Long.valueOf(totalTime - handleTime), Long.valueOf(handleTime), Long.valueOf(totalTime), this.toString()});
                    }
                    else {
                        logger.info("[SLOW_REQ] WaitTime: {} HandleTime: {} TotalTime: {} REQ: {}",
                                new Object[]{Long.valueOf(totalTime - handleTime), Long.valueOf(handleTime), Long.valueOf(totalTime), this.toString()});
                    }
                }
            }
        } catch (Throwable var12) {
            logger.error("run action execute exception. action : " + this.toString(), var12);
        }
    }

    public abstract void execute() throws Throwable;





}
