package com.stan.multiImpl.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TestApplication.class, args);

    }

    @RestController
    static class IndexController {

        @GetMapping(path = "/")
        public String index() {
            return "Home";
        }
    }
}
