package com.gameengine.system.net.handler;

import com.gameengine.system.net.codec.ClientReq;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import com.google.protobuf.Message;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.commons.lang3.StringUtils;

public class ServerHandler extends ChannelDuplexHandler {

    public static final ServerHandler INSTANCE = new ServerHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
//        SocketChannel channel = (SocketChannel) ctx.channel();
//        Session session = new Session(channel);
//        SessionGateManager.INSTANCE.addSession(session);
//        LogUtils.logger.info("session created, id:{}, ip:{}, type: SOCKET", session.getSessionId(), channel.remoteAddress().toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        ISession session = SessionGateManager.INSTANCE.removeSession(ctx.channel());
//        if (session == null) {
//            return;
//        }
//
//        // 断网，不需要移除token，以便前端使用token重连
//        LogUtils.logger.info("session destroyed, id:{}, ip:{}, reads:{}, sends:{}, type: SOCKET", session.getSessionId(), session.getChannel().remoteAddress().toString(), session.getReadBytes(), session.getSendBytes());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ClientReq clientReq = (ClientReq) msg;
//        ISession session = SessionGateManager.INSTANCE.getSessionByChannel(ctx.channel());
//        final int messageId = clientReq.getMessageId();
//        // 正在绑定中，不能接收请求，以免避免客户端拼命发登录请求，造成发出多次token获取、绑定请求
//        if (session.getTokenBindState() == ISession.BINDING_TOKEN) {
//            return;
//        }
//        // 未绑定，尝试绑定
//        if (session.getTokenBindState() == ISession.NOT_BIND_TOKEN) {
//            String token;
//            switch (messageId) {
//                case MessageList.LoginReq -> {
//                    Message message = MessageList.parse(messageId, clientReq.getBytes());
//                    LoginMsg.LoginReq loginReq = (LoginMsg.LoginReq) message;
//                    token = loginReq.getToken();
//                    LogUtils.logger.info("loginLog:client check login sessionId = {}, token = {}", session.getSessionId(), token);
//                }
//                case MessageList.ReconnectReq -> {
//                    Message message = MessageList.parse(messageId, clientReq.getBytes());
//                    LoginMsg.ReconnectReq reconnectReq = (LoginMsg.ReconnectReq) message;
//                    token = reconnectReq.getToken();
//                    LogUtils.logger.info("loginLog:client check reconnect sessionId = {}, token = {}", session.getSessionId(), token);
//                }
//                default -> {
//                    LogUtils.logger.warn("ERROR first messageId = {}, sessionId = {}", messageId, session.getSessionId());
//                    return;
//                }
//            }
//
//            if (StringUtils.isBlank(token)) {
//                LogUtils.logger.warn("loginLog:SessionBindToken fail token empty = {}", token);
//                return;
//            }
//
//            String[] tokenArray = TokenUtil.getTokenSplit(token);
//            final int gameServerId = Integer.parseInt(tokenArray[1]);
//            session.setTokenBindState(ISession.BINDING_TOKEN);
//            // 无token，异步获取token
//            GateApp gateApp = SessionGateManager.INSTANCE.getApp();
//            // session还没有自己的业务线程，先用次此请求发的token寻找业务线程
//            LogUtils.logger.info("loginLog:before async rpc chehck = {}", token);
//            SessionGateManager.INSTANCE.getApp().getThreadControl().getBusinessThread(token)
//                    .addTask(() -> {
//                        LogUtils.logger.info("loginLog:send token check rpc token = {}", token);
//                        TokenGameRpcProxy.gateSessionBindToken(gameServerId, gateApp.getAppData().getAppId(), token
//                                , session.getSessionId(), gameTokenModel -> {
//                                    if (gameTokenModel == null || gameTokenModel.isInvalid()) {
//                                        // todo push客户端，token无效
//                                        // 绑定失败，再次变为未绑定状态
//                                        LogUtils.logger.warn("loginLog:SessionBindToken fail token = {}", token);
//                                        session.setTokenBindState(ISession.NOT_BIND_TOKEN);
//                                        return;
//                                    }
//                                    LogUtils.logger.info("loginLog:SessionBindToken success token = {}", token);
//                                    session.addReqOnly(clientReq);
//                                    session.bindTokenModel(gameTokenModel);
//                                    session.setCouldForwardReq(true);
//                                    // 触发、执行队列。发送在队首的登录请求
//                                    session.forwardAllReq();
//                                });
//                    });
//            return;
//        }
//        // 已经绑定完tokenModel、业务线程
//        // session.getTokenBindState() == ISession.BIND_FINISH
//        //暂时定位15s内，平均每秒10次消息将被定为被攻击。 by yusheng
//        if (!session.addReqAndTrigger(clientReq)) {
//            //被攻击，暂时打印日志，不做任何处理
//            LogUtils.logger.error("network is attacked by address:{} token:{} messageId:{}", session.getAddress(), session.getTokenModel().getToken(), messageId);
//        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        try {
//            LogUtils.logger.warn(cause.getMessage(), cause);
//            LogUtils.logger.warn("channel handler, chanel {}", ctx.channel());
        } finally {
            ctx.close();
        }

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
//        if (evt instanceof IdleStateEvent e) {
//            if (e.state() == IdleState.READER_IDLE) {
//                ctx.close();
//            } else if (e.state() == IdleState.WRITER_IDLE) {
//                ctx.close();
//            }
//        }
    }
}
