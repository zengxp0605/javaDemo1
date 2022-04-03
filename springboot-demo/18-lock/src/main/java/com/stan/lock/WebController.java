package com.stan.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/2/25 3:07 下午
 * @Modified By：
 */
@RestController
public class WebController {

    @Autowired
    private Counter counter;

    private int intVal = 0;

    @RequestMapping("/")
    public String test1() {

        return "test-" + (++intVal);
    }

    @RequestMapping("/counter")
    public String testCounter(
            @RequestParam(name = "n", required = false, defaultValue = "1") int n
    ) throws InterruptedException {

//        counter.add(n);
        counter.addWithLock(n);


//        ReentrantReadWriteLock

        return "count: " + counter.get();
    }
}
