package org.apache.tmptest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/22 12:41 下午
 * @Modified By：
 */
@Service
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @PostConstruct
    public void init(){
        logger.error("test PostConstruct");
    }
}
