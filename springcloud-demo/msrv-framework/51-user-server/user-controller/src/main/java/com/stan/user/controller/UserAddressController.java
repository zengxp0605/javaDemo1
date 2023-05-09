package com.stan.user.controller;

import com.stan.common.model.constant.RestConstant;
import com.stan.common.model.dto.CommonResult;
import com.stan.user.facade.dto.request.AddressRequestDto;
import com.stan.user.facade.dto.response.AddressResponseDto;
import com.stan.user.facade.intf.IUserAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 实现feign接口
 */
@Slf4j
@RestController
@RequestMapping(RestConstant.MODULE_PREFIX_USER + "/v1/address")
public class UserAddressController implements IUserAddress {

    // curl -H "Content-type: application/json" -X POST -d '{"addressId":"123"}' 'http://localhost:8701/user/v1/address/queryDetail'
    @Override
    public CommonResult<AddressResponseDto> queryDetail(AddressRequestDto requestDto) {
        log.info("入参：{}", requestDto);
        AddressResponseDto responseDto = AddressResponseDto.builder()
                .city("Ningbo")
                .detail("Hongtang Road")
                .build();
        return CommonResult.success(responseDto);
    }

    // curl http://localhost:8701/user/v1/address/getAll
    @Override
    public CommonResult<List<AddressResponseDto>> getAll() {
        AddressResponseDto responseDto = AddressResponseDto.builder()
                .city("Ningbo")
                .detail("Hongtang Road")
                .build();
        List<AddressResponseDto> res = Arrays.asList(responseDto);

        log.info("返回结果：{}", res);
        return CommonResult.success(res);
    }
}
