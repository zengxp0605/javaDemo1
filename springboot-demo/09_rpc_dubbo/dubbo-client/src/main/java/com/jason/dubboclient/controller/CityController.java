package com.jason.dubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jason.dubbobaseinterface.entity.City;
import com.jason.dubbobaseinterface.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Reference(version = "1.0.0")
    CityService cityService;

    @GetMapping("/")
    public String index(){
        return "Dubbo demo";
    }

    /**
     * 访问地址:
     * http://localhost:8080/getCity?cityName=宁波
     * http://localhost:8080/getCity?cityName=aaa
     * @param cityName
     * @return
     */
    @GetMapping("/getCity")
    public City getCity(@RequestParam(name = "cityName", required = false, defaultValue = "宁波") String cityName){
        System.out.println("[CityController.getCity]获取城市: " + cityName);
        return cityService.findCityByName(cityName);
    }
}
