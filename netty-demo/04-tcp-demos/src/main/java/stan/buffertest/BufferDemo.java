package stan.buffertest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author：zengxp
 * @date：2022/5/8 上午11:50
 */
public class BufferDemo {
    public static void main(String[] args) {
        testBufferRW();
    }

    public static void testBufferRW(){
        ByteBuf byteBufMaxCap = PooledByteBufAllocator.DEFAULT.heapBuffer(1,4);

        System.out.println("初始化前----------");
        print(byteBufMaxCap);

        byteBufMaxCap.writeBytes(new byte[]{1});
        System.out.println("写入一个字节：1");
        print(byteBufMaxCap);

        byteBufMaxCap.writeBytes(new byte[]{2});
        System.out.println("写入一个字节：2");
        print(byteBufMaxCap);

        byte b1 = byteBufMaxCap.readByte();
        System.out.println("读取一个字节：" + b1);
        print(byteBufMaxCap);

        byte b2 = byteBufMaxCap.readByte();
        System.out.println("读取一个字节：" + b2);
        print(byteBufMaxCap);
        //数据读过以后，下标并没有变化，只能再写入两个字节。

        byteBufMaxCap.writeBytes(new byte[]{3});
        System.out.println("写入一个字节：3");
        print(byteBufMaxCap);

        byteBufMaxCap.writeBytes(new byte[]{4});
        System.out.println("写入一个字节：4");
        print(byteBufMaxCap);

        //此时如果不清空，再写入的话就会报错。
        byteBufMaxCap.clear();
        System.out.println("调用clear方法之后---");
        print(byteBufMaxCap);

        byteBufMaxCap.writeBytes(new byte[]{5});
        System.out.println("写入一个字节：5");
        print(byteBufMaxCap);
    }


    //观察读写后属性变化。
    private static void print(ByteBuf buf) {
        System.out.println("buf.isReadable()：" + buf.isReadable());
        System.out.println("buf.readerIndex()：" + buf.readerIndex());
        System.out.println("buf.readableBytes()：" + buf.readableBytes());
        System.out.println("buf.isWritable()：" + buf.isWritable());
        System.out.println("buf.writerIndex()：" + buf.writerIndex());
        System.out.println("buf.writableBytes()：" + buf.writableBytes());
        System.out.println("buf.capacity()：" + buf.capacity());
        System.out.println("buf.maxCapacity()：" + buf.maxCapacity());
        System.out.println("----------分隔符----------");
    }

}
