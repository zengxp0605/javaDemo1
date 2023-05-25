package com.stan.msrv.framework.rpc.config;

import com.stan.msrv.framework.rpc.feign.RequestHeaderInterceptor;
import com.stan.msrv.framework.rpc.mvc.IdempotentMvcHandlerInterceptor;
import com.stan.msrv.framework.rpc.mvc.RequestHeaderMvcHandlerInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author：zengxp
 */
@Configuration
public class FrameworkRpcConfiguration {

    @Configuration
    public static class RpcFeignConfiguration {

        @Bean
        public RequestInterceptor requestInterceptor() {
            return new RequestHeaderInterceptor();
        }
    }


    @Configuration
    public static class RpcMvcConfiguration {

        @Bean
        public HandlerInterceptor idempotentMvcHandlerInterceptor(){
            IdempotentMvcHandlerInterceptor handlerInterceptor = new IdempotentMvcHandlerInterceptor();
            // 注入必要参数
            return handlerInterceptor;
        }

        @Bean
        public HandlerInterceptor requestHeaderMvcHandlerInterceptor(){
            RequestHeaderMvcHandlerInterceptor handlerInterceptor = new RequestHeaderMvcHandlerInterceptor();

            return handlerInterceptor;
        }
    }
}
