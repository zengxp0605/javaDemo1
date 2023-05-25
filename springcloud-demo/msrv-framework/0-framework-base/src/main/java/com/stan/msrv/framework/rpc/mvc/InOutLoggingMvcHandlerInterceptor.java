package com.stan.msrv.framework.rpc.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 请求开始/结束日志
 *
 * @author：zengxp
 */
@Slf4j
@Order(1000)
public class InOutLoggingMvcHandlerInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            log.info("============ {}#{}服务请求开始 ============",
                    method.getDeclaringClass().getSimpleName(), method.getName());
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();

            if (ex == null) {
                log.info("============ {}#{}服务请求结束 ============",
                        method.getDeclaringClass().getSimpleName(), method.getName());
            } else {
                log.info("============ {}#{}服务请求异常 ============ ex:{}",
                        method.getDeclaringClass().getSimpleName(), method.getName(), ex);
            }
        }
    }


}
