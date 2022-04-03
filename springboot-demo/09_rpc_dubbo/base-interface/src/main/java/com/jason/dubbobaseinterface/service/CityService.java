package com.jason.dubbobaseinterface.service;

import com.jason.dubbobaseinterface.entity.City;

public interface CityService {
    City findCityByName(String cityName);
}
