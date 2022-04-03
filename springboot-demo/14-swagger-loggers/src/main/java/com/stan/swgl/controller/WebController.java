package com.stan.swgl.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String index() {
        logger.debug("Logger Level :DEBUG");
        logger.info("Logger Level :INFO");
        logger.error("Logger Level :ERROR");
        return "index";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ApiOperation("test")
    public Object test(){
        JSONObject object = new JSONObject();
        return "test";
    }

}
