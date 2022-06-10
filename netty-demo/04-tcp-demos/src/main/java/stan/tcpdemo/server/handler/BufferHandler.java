package stan.tcpdemo.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class BufferHandler extends SimpleChannelInboundHandler<ByteBuf> {

    //业务逻辑处理
    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

        int length = in.readableBytes();
        //分配一个新的数组来保存具有该长度的字节数据
        byte[] array = new byte[length];
        // 将字节复制到该数组
        in.getBytes(in.readerIndex(), array);
        String reqString = new String(array);
        System.out.println("reqString= " + reqString);

//        in.retain();
        ctx.fireChannelRead(reqString);
    }

    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}