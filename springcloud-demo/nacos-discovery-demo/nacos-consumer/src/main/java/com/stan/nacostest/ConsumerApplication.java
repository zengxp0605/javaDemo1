package com.stan.nacostest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @RestController
    public class TestController {

        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private EchoService echoService;

        @GetMapping("/echo-rest/{str}")
        public String echo(@PathVariable String str) {
            return restTemplate.getForObject("http://nacos-provider/echo/" + str, String.class);
        }

        @GetMapping(value = "/echo-feign/{str}")
        public String feign(@PathVariable String str) {
            return echoService.echo(str);
        }
    }

    @FeignClient(name = "nacos-provider")
    public interface EchoService {
        @GetMapping(value = "/echo/{str}")
        String echo(@PathVariable("str") String str);
    }

    @Configuration
    class Configure {

        @LoadBalanced
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}

