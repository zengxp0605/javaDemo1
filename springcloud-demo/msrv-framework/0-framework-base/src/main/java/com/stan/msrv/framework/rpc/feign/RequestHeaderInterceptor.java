package com.stan.msrv.framework.rpc.feign;

import com.stan.msrv.framework.utils.ThreadContextUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.core.annotation.Order;

/**
 * feign调用时添加公共请求头
 *
 * @author：zengxp
 */
@Order(1000)
public class RequestHeaderInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate requestTemplate) {

        Object rpcRequest = ThreadContextUtil.getInstance().get("RPC_REQUEST");
        String encodeRequestDtoString = "token=xxxx&uid=123"; // 从 rpcRequest 对象解析
        requestTemplate.header("RPC_REQUEST", encodeRequestDtoString);
    }

}
