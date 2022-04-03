package com.stan.swgl.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/19 4:04 下午
 * @Modified By：
 */
@Data
@AllArgsConstructor
@ApiModel(description = "用户类")
public class User {

    @ApiModelProperty(value = "ID", example = "100")
    private Integer id;

    @ApiModelProperty(value = "姓名", example = "lisi")
    private String name;

    @ApiModelProperty(value = "是否启用", example = "1")
    private Boolean enable;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}