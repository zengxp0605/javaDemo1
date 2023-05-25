package com.stan.msrv.framework.rpc.mvc;

import com.stan.msrv.framework.enums.EnumRpcError;
import com.stan.msrv.framework.utils.ThreadContextUtil;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：zengxp
 */
@Order(8000)
public class RequestHeaderMvcHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String rpcRequest = request.getHeader("RPC_REQUEST");
        if (StringUtils.isEmpty(rpcRequest)) {
            throw new Exception(EnumRpcError.RPC_REQUEST_NULL.getCode());
        }

        // 解析参数("token=xxxx&uid=123")为对象
        IdempotentMvcHandlerInterceptor.MsrvRequest msrvRequest = decodeRcpRequest(rpcRequest);
        ThreadContextUtil.getInstance().set("RPC_REQUEST", msrvRequest);

        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadContextUtil.getInstance().remove("RPC_REQUEST");
    }


    private IdempotentMvcHandlerInterceptor.MsrvRequest decodeRcpRequest(String rpcRequest) {

        return new IdempotentMvcHandlerInterceptor.MsrvRequest();
    }
}
