package com.stan.event.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/4/9 2:50 下午
 * @Modified By：
 */
@Data
@ToString
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    private String email;
}
