package com.jason.mybatisxml.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jason.mybatisxml.model.User;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    int insert(User user);

    void update(User user);

    void delete(Long id);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    default Page<User> getUserPage(int currentPage, int pageSize) {
        Page<User> userPage = PageHelper.startPage(currentPage, pageSize).doSelectPage(() -> this.getAll());
        return userPage;
    }
}
