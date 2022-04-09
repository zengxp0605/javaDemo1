package com.stan.webfluxdemo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: zengxp
 * @Date: 2022/1/7 10:44
 * @Desc:
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MonoDeferTest {

    private int a = 5;

    @Test
    public void deferTest1() {
        Mono<Integer> monoJust = Mono.just(a);
        Mono<Integer> monoDefer = Mono.defer(() -> {
            log.info("-----gen value----");
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Mono.just(a);
        });
        monoJust.subscribe(integer1 -> log.info("-->{}", integer1));
        monoDefer.subscribe(integer1 -> log.info("-->{}", integer1));
        a = 7;
        monoJust.subscribe(integer1 -> log.info("-->{}", integer1));
        monoDefer.subscribe(integer1 -> log.info("-->{}", integer1));
        /**
         * output:
         * 5
         * 5
         * 5
         * 7
         */
    }

    @Test
    public void deferTest2() {
        //声明阶段创建DeferClass对象
        Mono<Date> m1 = Mono.just(new Date());
        Mono<Date> m2 = Mono.defer(() -> {
            Date date = new Date();
            log.info("gen-date-->{}", date);
            return Mono.just(date);
        });
        m1.subscribe(date -> log.info("-->{}", date));
        m2.subscribe(date -> log.info("-->{}", date));
        //延迟5秒钟
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m1.subscribe(date -> log.info("-->{}", date));
        // 10:50:11.545 [main] INFO  c.s.w.f.TestFilter2Test - -->Fri Jan 07 10:50:06 CST 2022
        m2.subscribe(date -> log.info("-->{}", date));
    }

    @Test
    public void justTest() throws Exception {
        Mono<Long> clock = Mono.just(System.currentTimeMillis());
        //time == t0
        System.out.println(clock.block());

        Thread.sleep(10_000);
        //time == t10
        System.out.println(clock.block()); //we use block for demonstration purposes, returns t0

        Thread.sleep(7_000);
        //time == t17
        System.out.println(clock.block()); //we re-subscribe to clock, still returns t0
    }

    @Test
    public void defer1() throws Exception {
        Mono<Long> clock = Mono.defer(() -> Mono.just(System.currentTimeMillis()));
        System.out.println(clock.block());
        //time == t0

        Thread.sleep(10_000);
        //time == t10
        System.out.println(clock.block()); //invoked currentTimeMillis() here and returns t10

        Thread.sleep(7_000);
        //time == t17
        System.out.println(clock.block()); //invoke currentTimeMillis() once again here and returns t17
    }
}