package com.stan.multiImpl.test.impl;

import com.stan.multiImpl.test.intf.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl implements UserService {
}
