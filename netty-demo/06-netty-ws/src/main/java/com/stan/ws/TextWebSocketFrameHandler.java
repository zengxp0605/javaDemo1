package com.stan.ws;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @Author: zengxp
 * @Date: 2021/12/1 16:34
 * @Desc:
 */
@ChannelHandler.Sharable
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //读到客户端的内容并且向客户端去写内容
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息：" + msg.text());

        /**
         * writeAndFlush接收的参数类型是Object类型，但是一般我们都是要传入管道中传输数据的类型，比如我们当前的demo
         * 传输的就是TextWebSocketFrame类型的数据
         */
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务时间：" + LocalDateTime.now()));
    }

    //每个channel都有一个唯一的id值
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //打印出channel唯一值，asLongText方法是channel的id的全名
        System.out.println("handlerAdded：" + ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved：" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生");
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 处理接收参数
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (null != msg && msg instanceof FullHttpRequest) {
            System.out.println("准备提取token");
            //转化为http请求
            FullHttpRequest request = (FullHttpRequest) msg;
            //拿到请求地址
            String uri = request.uri();
            //判断是不是websocket请求，如果是拿出我们传递的参数（我的是token）
            String origin = request.headers().get("Origin");
            if (null == origin) {
                ctx.close();
            } else {
                if (null != uri && uri.contains("/ws") && uri.contains("?")) {
                    String[] uriArray = uri.split("\\?");
                    if (null != uriArray && uriArray.length > 1) {
                        String[] paramsArray = uriArray[1].split("=");
                        if (null != paramsArray && paramsArray.length > 1) {
                            String token = paramsArray[1];
                            System.out.println("提取token成功,token：" + token);
                        }
                    }
                    //重新设置请求地址
                    request.setUri("/ws");
                }
            }
        }
        //接着建立请求
        super.channelRead(ctx, msg);
    }

}