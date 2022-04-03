package com.jason.mybatisxml.mapper;

import com.jason.mybatisxml.model.UserFamily;

import java.util.List;

public interface UserFamilyMapper {

    List<UserFamily> getAll();

    int insert(UserFamily userFamily);
}
