package com.stan.autoproxying;

import com.stan.autoproxying.component.DataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：zengxp
 * @date：2022/4/23 下午3:58
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    static class TestController {

        @Autowired
        private DataCache dataCache;

        @GetMapping("/")
        public Object test() {
            System.out.println("dataCache: " + dataCache);
            return dataCache;
        }
    }
}
