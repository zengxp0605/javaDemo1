package stan.tcpdemo.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用堆外内存
 */
public class DirectMemoryMaker {
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectMemoryMaker.class);

    private static final int _1K = 1024;

    private static List<ByteBuffer> byteBufferList = new ArrayList<>();

    public void init() {
        try {
            Thread.sleep(10000);
            startReport(111);
            for (int i = 0; i < 100; i++) {
                Thread.sleep(5000);
                startReport(111 * i);
            }

        } catch (Exception e) {
            LOGGER.error("netty_direct_memory error", e);
        }
    }

    public void startReport(int val) {
        nettyBuffer(val);

        Runnable runnable = () -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10000000; i++) {
                String str = "abc";
                stringBuilder.append(str);
            }
            new UserDTO(stringBuilder.toString());
        };
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
//        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);
    }

    private void nettyBuffer(int val) {
        try {

            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer(100 * _1K * _1K);
            LOGGER.info("---->init: {}", byteBuf);
//            byteBuf.writeByte(val);

//            byteBufferList.add(directBf);
            ReferenceCountUtil.release(byteBuf);
            System.out.println(val);
        } catch (Exception e) {
            LOGGER.error("nioBuffer error", e);
        }
    }

    private void nioBuffer() {
        try {
            ByteBuffer directBf = ByteBuffer.allocateDirect(100 * _1K * _1K);
//            Long num = new Random().nextLong();
//            String str = num.toString();
//            directBf.wrap(str.getBytes());
            LOGGER.info("---->init: {}", directBf);

//            byteBufferList.add(directBf);
        } catch (Exception e) {
            LOGGER.error("nioBuffer error", e);
        }
    }

    static class UserDTO {
        private String name;

        UserDTO(String name) {
            this.name = name;
        }
    }
}
