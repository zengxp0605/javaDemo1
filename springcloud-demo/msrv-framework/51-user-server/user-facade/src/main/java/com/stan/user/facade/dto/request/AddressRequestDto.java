package com.stan.user.facade.dto.request;

import com.stan.common.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author：zengxp
 * @date：2023/5/8 下午5:30
 */
@Data
@AllArgsConstructor
public class AddressRequestDto extends BaseDto {
    private Integer addressId;
}
