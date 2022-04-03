package com.stan.service;

import com.stan.dao.UserDao;

public class HelloService {
    private String myNickName;
    private UserDao userDao;

    public HelloService(){
        System.out.println("HelloService被创建.");
    }

    public void sayHello(){
        System.out.println("Hello," + myNickName + " ,and name: " + userDao.getName());
    }

    public String getMyNickName() {
        return myNickName;
    }

    public void setMyNickName(String myNickName) {
        System.out.println("HelloService.setMyNickName() 被调用.");
        this.myNickName = myNickName;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
