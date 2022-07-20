package com.stan.ws;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: zengxp
 * @Date: 2021/12/1 14:54
 * @Desc:
 */
public class NettyServerApplication {
    public static void main(String[] args) {
        NettyServerApplication server = new NettyServerApplication();
        System.out.println("start-->port: " + 9090);
        server.start(9090);
    }

    public void start(Integer port) {
        NioEventLoopGroup boot = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(boot, work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new WebSocketChannelInitializer());

        try {
            Channel channel = b.bind(port).sync().channel();
            channel.closeFuture().sync();
            System.out.println("链接成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boot.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
