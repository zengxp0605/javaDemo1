package com.stan.user.facade.dto.response;

import com.stan.common.model.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * ResponseDto
 */
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressResponseDto extends BaseDto {
    private String city;
    private String detail;
}
