package com.stan.ws;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeauty.annotation.RequestParam;

/**
 * @author zengxp
 * @date 2022/1/21 11:01
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class TestController {
        @RequestMapping("/test")
        public Object test(@RequestParam MultiValueMap reqMap) {
            System.out.println("--->test");
            System.out.println(reqMap);
            return reqMap;
        }
    }
}
