package com.stan.swgl.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/19 3:52 下午
 * @Modified By：
 */

@Api(tags = "Web首页")
@RestController
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    @Counted(value = "stan.app.counted.index", description = "首页访问次数") // 监控没有起作用
    public String index() {
        logger.debug("Logger Level :DEBUG");
        logger.info("Logger Level :INFO");
        logger.error("Logger Level :ERROR");
        return "index";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ApiOperation("test")
    @Timed(value = "stan.app.timed.test", description = "test访问耗时")
    public Object test(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            logger.error("{}", e);
        }
        return "test";
    }

}
