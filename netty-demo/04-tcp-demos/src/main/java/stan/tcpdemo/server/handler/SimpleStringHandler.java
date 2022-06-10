package stan.tcpdemo.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Date;

@ChannelHandler.Sharable
public class SimpleStringHandler extends SimpleChannelInboundHandler<String> {
    private static final int _1K = 1024;

    /**
     * 建立连接时，发送一条庆祝消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 为新连接发送庆祝
        String welcomeStr = "Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n";
        ctx.write(welcomeStr);
        ctx.write("It is " + new Date() + " now.\r\n");

//        ctx.channel().write(welcomeStr);
        ctx.flush();
    }

    //业务逻辑处理
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String request) throws Exception {
        // Generate and write a response.
        System.out.println("request= " + request);
        String response;
        boolean close = false;
        if (request.isEmpty()) {
            response = "Please type something.\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Have a good day!\r\n";
            close = true;
        } else {
            response = "Did you say '" + request + "'?\r\n";
        }

        if (request.equals("byte")) {
            byte[] a = new byte[20 * _1K * _1K];
            System.out.println("申请20M byte");
        } else if (request.equals("direct_buffer")) {
            ByteBuffer directBf = ByteBuffer.allocateDirect(20 * _1K * _1K);
            System.out.println("申请20M directBf");
        } else if(request.equals("ByteBuf")){
            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer(100 * _1K * _1K);
            System.out.println("申请20M byteBuf,并release");
            ReferenceCountUtil.release(byteBuf);
        }

//        ChannelFuture channelFuture = ctx.channel().write(response);
        ChannelFuture channelFuture = ctx.write(response);

        if (close) {
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}