package com.stan.multiImpl.test.impl;

import com.stan.multiImpl.test.intf.AccountCore;

//@Component
public class AccountWXCoreImpl implements AccountCore {
    @Override
    public String getChannelNo() {
        return "Wx-channel";
    }
}
