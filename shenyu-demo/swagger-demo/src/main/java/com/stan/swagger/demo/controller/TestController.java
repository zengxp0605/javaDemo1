package com.stan.swagger.demo.controller;

import com.stan.swagger.demo.dto.OrderDTO;
import io.swagger.annotations.ApiOperation;
import org.apache.shenyu.client.springmvc.annotation.ShenyuSpringMvcClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShenyuSpringMvcClient(path = "/user")
@RequestMapping("/user")
@RestController
public class TestController {

    @ShenyuSpringMvcClient(path = "/test1", desc = "test1")
    @ApiOperation(value = "接口1-test1")
    @GetMapping(value = "/test1")
    public List<String> test1(Integer num) {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("123");
            add(num + "");
        }};
        return strings;
    }

    @ShenyuSpringMvcClient(path = "/test2", desc = "test1")
    @ApiOperation(value = "接口2-test2")
    @PostMapping(value = "/test2")
    public Map<String, Object> test2(@ModelAttribute OrderDTO orderDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("test", 123);
        map.put("orderDTO", orderDTO);
        return map;
    }

    @PostMapping(value = "/test3")
    public OrderDTO test3(@RequestBody OrderDTO orderDTO) {
        return orderDTO;
    }
}