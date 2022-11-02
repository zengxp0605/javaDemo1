package com.stan.nbspring.facade.feign;

import com.stan.nbspring.facade.intf.IUserAccountManage;

/**
 * 模拟 feign 调用
 */
//@FeignClient(value="nb-spring", path="/nb-spring/v1/user")
public interface UserAccountManageFacade extends IUserAccountManage {
}
