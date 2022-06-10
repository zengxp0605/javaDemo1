package stan.tcpdemo.server;

import io.netty.util.internal.PlatformDependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 监控堆外内存
 */
public class DirectMemoryReporter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectMemoryReporter.class);

    private static final int _1K = 1024;

    private static final String BUSINESS_KEY = "netty_direct_memory";

    private AtomicLong directMemory;

    public void init() {
        try {
            Thread.sleep(5000);
            Field field = PlatformDependent.class.getDeclaredField("DIRECT_MEMORY_COUNTER");
            field.setAccessible(true);
            directMemory = ((AtomicLong) field.get(PlatformDependent.class));
            startReport();

            Field field2 = PlatformDependent.class.getDeclaredField("MAX_DIRECT_MEMORY");
            field2.setAccessible(true);
            LOGGER.info("MAX_DIRECT_MEMORY: {}", ((long) field2.get(PlatformDependent.class) / _1K));
        } catch (Exception e) {
            LOGGER.error("netty_direct_memory error", e);
        }
    }

    public void startReport() {
        Runnable runnable = () -> {
            doReport();
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);
    }

    /**
     * TODO: ---->netty_direct_memory:384MB 每个连接16M增长，到384之后不再涨了？？ 《--现象？ why
     */
    private void doReport() {
        try {
            int memoryInKB = (int) (directMemory.get());
            LOGGER.info("---->{}:{}KB", BUSINESS_KEY, memoryInKB / _1K );
        } catch (Exception e) {
            LOGGER.error("netty_direct_memory error", e);
        }
    }
}
