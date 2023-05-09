package com.stan.user.facade.feign;

import com.stan.common.model.constant.RestConstant;
import com.stan.user.facade.intf.IUserAddress;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 暴露接口给其他服务调用
 */
@FeignClient(value = RestConstant.APPLIACTION_NAME_USER,
        path = RestConstant.MODULE_PREFIX_USER + "/v1/address")
public interface UserAddressFacade extends IUserAddress {
}
