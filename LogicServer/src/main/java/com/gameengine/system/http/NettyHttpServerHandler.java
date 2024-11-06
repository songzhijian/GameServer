package com.gameengine.system.http;

import com.gameengine.system.utils.GameLoggerFactory;
import com.gameengine.system.utils.GeoIP2Util;
import com.gameengine.system.utils.IPUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.copiedBuffer;

/*
 * 自定义处理的handler
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger logger = GameLoggerFactory.getLogger(NettyHttpServerHandler.class);

    /*
     * 处理请求
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {

        if (fullHttpRequest.method() == HttpMethod.GET) {
            //get方式传递的参数
            System.out.println("" + getGetParamsFromChannel(fullHttpRequest));
            //返回信息
            String data = "GET method over";
            ByteBuf buf = copiedBuffer(data, CharsetUtil.UTF_8);
            FullHttpResponse response = responseOK(HttpResponseStatus.OK, buf);
            channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

        } else if (fullHttpRequest.method() == HttpMethod.POST) {
            String url = fullHttpRequest.uri();
            String data = "这是post返回";
            if (url.endsWith("CXF")) {
                try {
                    //
                    System.out.println("业务逻辑");
                } catch (Exception e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }


            Map<String, Object> postParamsFromChannel = getPostParamsFromChannel(fullHttpRequest);

            try {
                final String IP = IPUtil.getIpAddr(channelHandlerContext, fullHttpRequest);
                postParamsFromChannel.put("ip", IP);
                final String country = GeoIP2Util.getInstance().getCountryISOCode(IP);
                postParamsFromChannel.put("country", country);
//                final String city = Ip2regionService.getInstance().getAddressAndIsp(IP); //TODO
                postParamsFromChannel.put("city", "");
                logger.info("Ip to region success! IP = {}, country = {}, city = {}", IP, country, "");
            } catch (Exception e) {
                logger.error("Ip to region fail!", e);
            }
            String param = ArrayUtils.toString(postParamsFromChannel);
            logger.info("receive request POST : {}", param);
            SocketAddress socketAddress = channelHandlerContext.channel().remoteAddress();
            String s = socketAddress.toString();
            LoginLoginCmd.getInstance().executeCmd(postParamsFromChannel, channelHandlerContext);

        } else {
            String data = "未找到对应的url";
            ByteBuf content = copiedBuffer(data, CharsetUtil.UTF_8);
            FullHttpResponse response = responseOK(HttpResponseStatus.INTERNAL_SERVER_ERROR, content);
            channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * @param fullHttpRequest
     * @return 获取参数
     */
    private String getParam(FullHttpRequest fullHttpRequest) {
        ByteBuf content = fullHttpRequest.content();
        byte[] reqContent = new byte[content.readableBytes()];
        content.readBytes(reqContent);
        String strContent = "";
        try {
            strContent = new String(reqContent, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return strContent;
    }


    /*
     * 获取GET方式传递的参数
     */
    private Map<String, Object> getGetParamsFromChannel(FullHttpRequest fullHttpRequest) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (fullHttpRequest.method() == HttpMethod.GET) {
            // 处理get请求
            QueryStringDecoder decoder = new QueryStringDecoder(fullHttpRequest.uri());
            Map<String, List<String>> paramList = decoder.parameters();
            for (Map.Entry<String, List<String>> entry : paramList.entrySet()) {
                params.put(entry.getKey(), entry.getValue().get(0));
            }
            return params;
        } else {
            return null;
        }

    }

    /*
     * 获取POST方式传递的参数
     */
    private Map<String, Object> getPostParamsFromChannel(FullHttpRequest fullHttpRequest) {

        Map<String, Object> params = new HashMap<>();

        if (fullHttpRequest.method() == HttpMethod.POST) {
            // 处理POST请求
            String strContentType = fullHttpRequest.headers().get("Content-Type").trim();
            if (strContentType.contains("x-www-form-urlencoded")) {
                params = getFormParams(fullHttpRequest);
            } else if (strContentType.contains("application/json")) {
                try {
                    params = getJSONParams(fullHttpRequest);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return params;
    }

    /*
     * 解析from表单数据（Content-Type = x-www-form-urlencoded）
     */
    private Map<String, Object> getFormParams(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = new HashMap<String, Object>();

        HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), fullHttpRequest);
        List<InterfaceHttpData> postData = decoder.getBodyHttpDatas();
        try {
            for (InterfaceHttpData data : postData) {
                if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
                    MemoryAttribute attribute = (MemoryAttribute) data;
                    params.put(attribute.getName(), attribute.getValue());
                }
            }
        } finally {
            decoder.destroy();
        }
        return params;
    }

    /*
     * 解析json数据（Content-Type = application/json）
     */
    private Map<String, Object> getJSONParams(FullHttpRequest fullHttpRequest) throws UnsupportedEncodingException {
        Map<String, Object> params = new HashMap<String, Object>();

        ByteBuf content = fullHttpRequest.content();
        byte[] reqContent = new byte[content.readableBytes()];
        content.readBytes(reqContent);
        return params;
    }

    private FullHttpResponse responseOK(HttpResponseStatus status, ByteBuf content) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, content);
        response.headers().set("Content-Type", "text/plain;charset=UTF-8");
        response.headers().set("Content_Length", response.content().readableBytes());
        return response;
    }

}
