package com.stan.common.model.enums;

import com.stan.common.model.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author：zengxp
 */
@Getter
@AllArgsConstructor
public enum  EnumBizType implements IEnum {
    DEMO("DEMO", "DEMO"),

    ;

    private String code;

    private String description;
}
