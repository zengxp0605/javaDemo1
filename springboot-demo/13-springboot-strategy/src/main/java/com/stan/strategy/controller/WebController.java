package com.stan.strategy.controller;

import com.alibaba.fastjson.JSONObject;
import com.stan.strategy.service.PriceStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired
    PriceStrategyContext priceStrategyContext;

    /**
     * http://localhost:8080/?type=commonMember
     * http://localhost:8080/?type=vipMember
     * @param type
     * @return
     */
    @RequestMapping("/")
    public JSONObject index(@RequestParam(required = false, defaultValue = "commonMember") String type){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("memberType", type);
        jsonObject.put("price", priceStrategyContext.calculate(type));

        return jsonObject;
    }
}
