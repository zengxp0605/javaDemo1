package com.stan.swagger.demo.controller;

import com.stan.swagger.demo.dto.OrderDTO;
import com.stan.swagger.demo.entity.ConvertBasic;
import com.stan.swagger.demo.entity.OrderPO;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @GetMapping(value = "/test")
    public OrderDTO test(Integer id) {
        OrderPO orderPO = new OrderPO();
        orderPO.setId(id + "");
        orderPO.setName("Eechoz");
        return ConvertBasic.INSTANCE.orderPo2OrderDto(orderPO);
    }

}