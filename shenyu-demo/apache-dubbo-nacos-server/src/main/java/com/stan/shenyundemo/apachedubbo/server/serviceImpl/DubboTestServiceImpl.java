/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.stan.shenyundemo.apachedubbo.server.serviceImpl;

import com.fosun.user.api.http.LoginDubbo;
import com.stan.shenyudemo.dubboapi.entity.DubboTest;
import com.stan.shenyudemo.dubboapi.entity.ListResp;
import com.stan.shenyudemo.dubboapi.service.DubboTestService;
import com.stan.shenyundemo.apachedubbo.server.dubboclient.OpenApiTest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.Random;

/**
 * The type Dubbo service.
 */
@DubboService
public class DubboTestServiceImpl implements DubboTestService {

    @Value("${public.env}")
    private String env;

    @DubboReference
    public LoginDubbo loginDubbo;

    @Override
    @ShenyuDubboClient(path = "/findById", desc = "Query by Id")
    public DubboTest findById(final String id) {
        return new DubboTest(id, "hello findById");
    }

    @Override
    @ShenyuDubboClient(path = "/findByIdName", desc = "Query by Id")
    public DubboTest findById(String id, String name) {
        System.out.println("参数列表：id=" + id + " ,name=" + name);
        return new DubboTest(id, "hello,findById + name=" + name);
    }

    @Override
    @ShenyuDubboClient(path = "/findAll", desc = "Get all data")
//    @OpenApiTest(path = "/findAll2", desc = "Get all data")
    public DubboTest findAll() {
        System.out.println("--->findAll,env: " + env);
        loginDubbo.login();

        try {
            String attachment = RpcContext.getContext().getAttachment("add-value");
            System.out.println("attachment `add-value`: " + attachment);

            System.out.println("userId=" + RpcContext.getContext().getAttachment("userId"));
            System.out.println(RpcContext.getContext().getAttachments());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DubboTest(String.valueOf(new Random().nextInt()), "hello world shenyu Alibaba Dubbo , findAll ----> from env: " + env);
    }

    @Override
    @ShenyuDubboClient(path = "/insert", desc = "Insert a row of data")
    public DubboTest insert(final DubboTest dubboTest) {
        dubboTest.setName("hello world shenyu Alibaba Dubbo: " + dubboTest.getName());
        return dubboTest;
    }

    @Override
    @ShenyuDubboClient(path = "/findList", desc = "Find list")
    public ListResp findList() {
        return new ListResp(1, Collections.singletonList(new DubboTest("1", "test")));
    }
}
