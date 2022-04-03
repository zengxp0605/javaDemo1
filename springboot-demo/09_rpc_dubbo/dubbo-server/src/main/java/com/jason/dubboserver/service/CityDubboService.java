package com.jason.dubboserver.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jason.dubbobaseinterface.entity.City;
import com.jason.dubbobaseinterface.service.CityService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 注册为dubbo服务
 */
@Service(version = "1.0.0")
@Component
public class CityDubboService implements CityService {

    private HashMap<String, City> cities = new HashMap<String, City>(){{
//        put("宁波",JSONObject.parseObject("{\"a\":\"111\"}"));
        put("宁波", new City(1L, 1L, "宁波", "zouzou的城市,向往的地方!"));
        put("北京", new City(2L, 2L, "北京", "北京,北京,北京!"));

    }};

    /**
     * 根据城市名称, 查询城市信息
     *
     * @param cityName
     * @return
     */
    @Override
    public City findCityByName(String cityName) {
        City city = cities.get(cityName);
        System.out.println("服务被调用[CityDubboService.findCityByName] res: " + cityName + " -- " + city);
        if(city == null){
            return new City(0L,0L,"none", "没有记录的城市");
        }

        return city;
    }
}
