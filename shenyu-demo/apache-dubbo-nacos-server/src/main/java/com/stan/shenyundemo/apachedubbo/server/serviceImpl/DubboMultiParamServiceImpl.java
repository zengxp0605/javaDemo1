package com.stan.shenyundemo.apachedubbo.server.serviceImpl;

import com.stan.shenyudemo.dubboapi.entity.ComplexBeanTest;
import com.stan.shenyudemo.dubboapi.entity.DubboTest;
import com.stan.shenyudemo.dubboapi.service.DubboMultiParamService;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;

import java.util.List;

/**
 * @author zengxp
 * @date 2022/1/11 16:16
 */
public class DubboMultiParamServiceImpl implements DubboMultiParamService {

    @ShenyuDubboClient(path = "/multi/findByIdsAndName")
    @Override
    public DubboTest findByIdsAndName(List<Integer> ids, String name) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//findByArrayIdsAndName")
    @Override
    public DubboTest findByArrayIdsAndName(Integer[] ids, String name) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//findByStringArray")
    @Override
    public DubboTest findByStringArray(String[] ids) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//findByListId")
    @Override
    public DubboTest findByListId(List<String> ids) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//batchSave")
    @Override
    public DubboTest batchSave(List<DubboTest> dubboTestList) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//batchSaveAndNameAndId")
    @Override
    public DubboTest batchSaveAndNameAndId(List<DubboTest> dubboTestList, String id, String name) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//saveComplexBeanTest")
    @Override
    public DubboTest saveComplexBeanTest(ComplexBeanTest complexBeanTest) {
        return null;
    }

    @ShenyuDubboClient(path = "/multi//saveComplexBeanTestAndName")
    @Override
    public DubboTest saveComplexBeanTestAndName(ComplexBeanTest complexBeanTest, String name) {
        return null;
    }
}
