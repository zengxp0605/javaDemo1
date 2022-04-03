package com.stan.mp.generator.service.impl;

import com.stan.mp.generator.entity.ChannelDetail;
import com.stan.mp.generator.mapper.ChannelDetailMapper;
import com.stan.mp.generator.service.IChannelDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/10 下午11:56
 * @Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailServiceImplTest {

    @Autowired
    private ChannelDetailMapper mapper;

    @Test
    public void test() {

        List<ChannelDetail> channelDetails = mapper.selectList(null);
        System.out.println(channelDetails);

    }
}