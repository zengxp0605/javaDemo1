package com.stan.consumerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class TestController {

        @Autowired
        private EchoService echoService;

        @Autowired
        private TempMonitorService tempMonitorService;

        @GetMapping(value = "/")
        public Object home() {
            return "msg from consumer local";
        }

        @GetMapping(value = "/test-feign")
        public Object feign() {
            return echoService.getFromRedis();
        }

        @GetMapping(value = "/monitor-feign")
        public Object monitor() {
            return tempMonitorService.get();
        }
    }

    // 测试https支持情况， 本地调试可以使用
    @FeignClient(name = "nothing", url = "${local.feign.server.wear-center.url:}")
    public interface TempMonitorService {
        @GetMapping(value = "/svr/monitor/live")
        Object get();
    }

    @FeignClient(name = "health-user-center", fallback = EchoServiceFallBack.class)
    public interface EchoService {
        @GetMapping(value = "/getRedis")
        Object getFromRedis();
    }

    @Component
    public class EchoServiceFallBack implements EchoService {
        @Override
        public Object getFromRedis() {
            return "getFromRedis msg from Fallback " + System.currentTimeMillis();
        }
    }
}
