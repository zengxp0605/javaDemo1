package stan.tcpdemo.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import stan.tcpdemo.server.handler.BufferHandler;
import stan.tcpdemo.server.handler.SimpleStringHandler;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 添加帧限定符来防止粘包现象
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        //debug Buffer
        pipeline.addLast(new BufferHandler());

        // 解码和编码，应和客户端一致
        pipeline.addLast(new StringDecoder());
        pipeline.addLast(new StringEncoder());

        // 业务逻辑实现类
        pipeline.addLast(new SimpleStringHandler());


    }
}