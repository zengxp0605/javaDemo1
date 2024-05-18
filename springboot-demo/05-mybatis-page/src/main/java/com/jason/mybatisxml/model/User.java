package com.jason.mybatisxml.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true) // 链式调用setter 方法
@Data
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long id;

    private String nickName;

}
