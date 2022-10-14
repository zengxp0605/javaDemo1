package com.stan.multiImpl.test.impl;

import com.stan.multiImpl.test.intf.AccountCore;
import org.springframework.stereotype.Component;

@Component
public class AccountWXCoreImpl implements AccountCore {
    @Override
    public String getChannelNo() {
        return "Wx-channel";
    }
}
