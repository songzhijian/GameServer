package com.gameengine.system.net.session;

import com.gameengine.system.AbstractGameCoreService;
import com.gameengine.system.GameCoreServiceType;
import com.gameengine.system.execution.ActionQueue;
import com.gameengine.system.execution.Executor;
import com.gameengine.system.execution.OrderedActionQueue;
import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SessionService extends AbstractGameCoreService {
    private final Map<Integer, ISession> sessionMap = new ConcurrentHashMap<>();
    private final Map<Integer, ActionQueue> sessionQueueMap = new ConcurrentHashMap<>();
    private final Map<Channel, ISession> sessionChannelMap = new ConcurrentHashMap<>();
    private final AtomicLong totalSessions = new AtomicLong(0L);

    private static final SessionService instance = new SessionService();

    public SessionService() {
        super(GameCoreServiceType.SESSION_MANAGER);
    }

    public static SessionService getInstance() {
        return instance;
    }

    public void addSession(ISession session) {
        this.totalSessions.incrementAndGet();
        this.sessionMap.put(session.getSessionId(), session);
        if(session.getChannel() != null) {
            this.sessionChannelMap.put(session.getChannel(), session);
        }

    }

    public int getCurrentSessions() {
        return this.sessionChannelMap.size();
    }

    public long getTotalSessions() {
        return this.totalSessions.get();
    }

    public ISession removeSession(Channel channel) {
        ISession session = this.sessionChannelMap.get(channel);
        this.removeSession(session);
        return session;
    }

    public void removeSession(ISession session) {
        if(session != null) {
            this.sessionQueueMap.remove(session.getSessionId());
            this.sessionMap.remove(session.getSessionId());
            if(session.getChannel() != null) {
                this.sessionChannelMap.remove(session.getChannel());
            }
        }

    }

    public ISession removeSession(int sessionId) {
        ISession session = this.sessionMap.get(sessionId);
        if(session != null) {
            this.removeSession(session);
        }

        return session;
    }

    protected void initService() throws Exception {
    }

    protected void startService() throws Exception {
//        TaskScheduler taskScheduler = GameServer.getInstance().getTaskScheduler();
//        taskScheduler.scheduleAtFixedRate(new SessionTimeoutTask(), Constants.SESSION_TASK_INTERVAL, Constants.SESSION_TASK_INTERVAL, TimeUnit.SECONDS);
//        taskScheduler.scheduleAtFixedRate(new UserTimeoutTask(), Constants.USER_TASK_INTERVAL, Constants.USER_TASK_INTERVAL, TimeUnit.SECONDS);
    }

    protected void stopService() throws Exception {
    }

    public ISession getSession(Channel channel) {
        return this.sessionChannelMap.get(channel);
    }

//    public List getTimeoutSessions() {
//        UserManager userManager = GameServer.getInstance().getUserManager();
//        ArrayList timeoutSessions = new ArrayList();
//        ArrayList allSessions = new ArrayList(this.sessionChannelMap.values());
//        Iterator i$ = allSessions.iterator();
//
//        while(i$.hasNext()) {
//            ISession session = (ISession)i$.next();
//            if(session.isTimeout() && !userManager.containsSessions(session)) {
//                timeoutSessions.add(session);
//            }
//        }
//
//        return timeoutSessions;
//    }

    public boolean containsSession(ISession session) {
        return this.sessionMap.get(session.getSessionId()) != null;
    }

    public ActionQueue getQueue(ISession session, Executor executor) {
        ActionQueue queue = this.sessionQueueMap.get(session.getSessionId());
        if(queue == null) {
            queue = new OrderedActionQueue(executor);
            ActionQueue eQueue = this.sessionQueueMap.putIfAbsent(session.getSessionId(), queue);
            if(eQueue != null) {
                return eQueue;
            }
        }
        return queue;
    }

    public int getUserQueueSize() {
        int size = 0;
        ActionQueue queue;
        for(Iterator<ActionQueue> i$ = this.sessionQueueMap.values().iterator(); i$.hasNext(); size += queue.getQueue().size()) {
            queue = i$.next();
        }

        return size;
    }

    public ISession reconnectSession(ISession tmpSession, String prevSessionToken) throws Exception {
        Channel channel = tmpSession.getChannel();
        ISession session = this.getSessionByReconnectToken(prevSessionToken);
        if(session == null) {
            throw new Exception("Session Reconnection failure. can not find session by token " + prevSessionToken);
        } else if(!channel.isActive()) {
            throw new Exception("Session Reconnection failure. socket is not active. session: " + tmpSession.toString());
        } else if(session.isTimeout()) {
            throw new Exception("Session Reconnection failure. session is timeout, " + session.toString());
        } else {
            session.setChannel(channel);
            this.removeSession(tmpSession);
            this.sessionChannelMap.put(session.getChannel(), session);
            this.logger.info("Reconnection done. session: {} replace {}", tmpSession.toString(), session.toString());
            return session;
        }
    }

    private ISession getSessionByReconnectToken(String reconnectionToken) {
        ArrayList<ISession> sessions = new ArrayList<>(this.sessionMap.values());
        Iterator<ISession> i$ = sessions.iterator();

        ISession session;
        do {
            if(!i$.hasNext()) {
                return null;
            }
            session = i$.next();
        } while(!session.getReconnectionToken().equals(reconnectionToken));

        return session;
    }
}

