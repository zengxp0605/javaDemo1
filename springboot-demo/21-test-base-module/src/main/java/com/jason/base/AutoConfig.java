package com.jason.base;

import com.jason.base.config.MyProperties1;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2021/11/11 下午11:51
 * @Modified By：
 */
@EnableConfigurationProperties({MyProperties1.class})
@ComponentScan({"com.jason.base.**"})
public class AutoConfig {
}
