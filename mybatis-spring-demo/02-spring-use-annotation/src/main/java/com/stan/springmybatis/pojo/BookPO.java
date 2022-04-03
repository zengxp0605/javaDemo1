package com.stan.springmybatis.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/20 10:21 下午
 * @Modified By：
 */
@Data
@Accessors(chain = true)
public class BookPO implements Serializable {
    private static final long serialVersionUID = -4413646231192807746L;

    private Long id;
    private String bookName;
    private String author;
    private Date createTime;
}
