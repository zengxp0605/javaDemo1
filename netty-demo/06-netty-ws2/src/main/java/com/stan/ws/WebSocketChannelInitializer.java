package com.stan.ws;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/30 下午11:00
 * @Modified By：
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //websocket协议本身是基于http协议的，所以这边也要使用http解编码器
        pipeline.addLast("http-codec", new HttpServerCodec());//将请求和应答消息编码或者解码为HTTP消息

        //netty是基于分段请求的，HttpObjectAggregator的作用是将请求分段再聚合,参数是聚合字节的最大长度
        pipeline.addLast("aggergator", new HttpObjectAggregator(65536));//将HTTP消息的多个部分组成为u一个消息

        //以块的方式来写的处理器
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());//来向客户端发送HTML5文件 主要支持浏览器端和服务端进行通信

        //websocket定义了传递数据的6中frame类型
        pipeline.addLast("my-handler", new TextWebSocketFrameHandler());//

        //ws://localhost:9999/ws
        //参数指的是contex_path
        pipeline.addLast("websocket-handler", new WebSocketServerProtocolHandler("/ws"));//

    }
}
