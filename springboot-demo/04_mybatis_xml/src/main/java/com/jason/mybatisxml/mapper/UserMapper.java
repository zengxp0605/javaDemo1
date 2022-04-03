package com.jason.mybatisxml.mapper;

import com.jason.mybatisxml.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    int insert(User user);

    void update(User user);

    void delete(Long id);

    /**
     * 用于多表查询测试
     * @param id
     * @return
     */
    User getAllFamilyByUserId(Long id);
}
