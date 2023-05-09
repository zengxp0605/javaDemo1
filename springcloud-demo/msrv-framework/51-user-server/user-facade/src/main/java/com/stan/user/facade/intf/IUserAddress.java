package com.stan.user.facade.intf;

import com.stan.common.model.dto.CommonResult;
import com.stan.user.facade.dto.request.AddressRequestDto;
import com.stan.user.facade.dto.response.AddressResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author：zengxp
 */
public interface IUserAddress {
    /**
     * 获取地址详情
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/queryDetail")
    CommonResult<AddressResponseDto> queryDetail(@RequestBody AddressRequestDto requestDto);

    @GetMapping("/getAll")
    CommonResult<List<AddressResponseDto>> getAll();
}
