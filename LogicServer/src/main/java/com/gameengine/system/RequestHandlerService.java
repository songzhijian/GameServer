package com.gameengine.system;

import com.dreamfun.opg.GameServer;
import com.gameengine.system.execution.ActionQueue;
import com.gameengine.system.execution.Executor;
import com.gameengine.system.execution.GameRequestAction;
import com.gameengine.system.execution.Request;
import com.gameengine.system.net.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestHandlerService extends AbstractGameCoreService {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandlerService.class);
    private final int commandThreadSize = GameServer.getInstance().getConfiguration().getInt("threadPool.command.size", 32);
    private final int slowRequestTimedOutMilli = GameServer.getInstance().getConfiguration().getInt("request.slow.millis", 500);
    private static final RequestHandlerService instance = new RequestHandlerService();
    private Executor cmdExecutor;
    public static RequestHandlerService getInstance() {
        return instance;
    }

    public static final AtomicInteger queueActionNumber = new AtomicInteger(0);

    public static int warningNumber = 200;

    public RequestHandlerService() {
        super(GameCoreServiceType.REQUEST_HANDLER);
    }

    protected void initService() throws Exception {
        int maxPoolSize = Math.max(this.commandThreadSize, 64);
        byte keepAliveTime = 5;
        int cacheSize = Math.max(this.commandThreadSize, 64);
        this.cmdExecutor = new Executor(this.commandThreadSize, maxPoolSize, keepAliveTime, cacheSize, "GameRequestHandler");
    }

    protected void startService() throws Exception {

    }

    protected void stopService() throws Exception {
        this.cmdExecutor.stop();
    }

    public void enqueueRequest(Request request) {
        ActionQueue queue = SessionService.getInstance().getQueue(request.getSession(), this.cmdExecutor);
        (new GameRequestAction(queue, request, this.slowRequestTimedOutMilli)).enqueue();
        int n = queueActionNumber.incrementAndGet();
        if(n>warningNumber){
            logger.info("Request action too many {}", new Object[]{n});
        }
    }

    public int getUserQueueSize() {
        return SessionService.getInstance().getUserQueueSize();
    }

    public int getActiveCommandThreadCount() {
        return this.cmdExecutor == null?-1:this.cmdExecutor.getPoolThreadCount();
    }

    public int getCommandQueueSize() {
        return this.cmdExecutor == null?-1:this.cmdExecutor.getQueueSize();
    }
}
