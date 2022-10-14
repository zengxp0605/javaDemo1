package com.stan.multiImpl.test.intf;

public interface UserService {
    default String getName(){
        return "Default-name";
    }
}
