package com.stan.eureka.user;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class TestController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/")
    public String test(){
        return "Resp from port: " + port;
    }

    // apollo配置demo
    @Value("${name}")
    private String name;
    @Value("${demo.env:}")
    private String demoEnv;
    @Value("${demo.tmp:}")
    private String demoTmp;
    @RequestMapping("/getConfig")
    public Object config(){
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("demoEnv", demoEnv);
        map.put("demoTmp", demoTmp);

        Config config = ConfigService.getConfig("application");
        Set<String> propertyNames = config.getPropertyNames();

        map.put("propertyNames", propertyNames);
        return map;
    }
}
