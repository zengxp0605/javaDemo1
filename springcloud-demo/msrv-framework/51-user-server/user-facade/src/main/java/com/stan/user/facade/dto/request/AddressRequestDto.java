package com.stan.user.facade.dto.request;

import com.stan.common.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author：zengxp
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto extends BaseDto {
    private Integer addressId;
}
