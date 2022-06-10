package com.stan.autoproxying.component;

import com.stan.autoproxying.annotation.RandomInt;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author：zengxp
 * @date：2022/4/23 下午4:04
 */
@Getter
@Setter
@ToString
@Component
public class DataCache {
    @RandomInt(min=2, max=10)
    private Integer group;

    private String name;

    private String data = "default-data";
}
