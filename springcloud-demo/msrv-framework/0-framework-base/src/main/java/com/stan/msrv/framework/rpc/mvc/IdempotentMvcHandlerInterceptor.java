package com.stan.msrv.framework.rpc.mvc;

import com.stan.msrv.framework.enums.EnumRpcError;
import com.stan.msrv.framework.utils.ThreadContextUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 幂等校验拦截器
 * 依赖 {@link: RequestHeaderMvcHandlerInterceptor} 将MsrvRequest放入到线程上下文
 *
 * @author：zengxp
 */
@Getter
@Setter
@Order(8100)
public class IdempotentMvcHandlerInterceptor implements HandlerInterceptor {

    // 需要配置超时时间，默认120s
    private int expireTime = 120;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 过滤掉非内部请求
        if (!request.getRequestURI().startsWith("/mrsv")) {
            return true;
        }
        // 从全局（ThreadLocal) 中获取 MsrvRequest
        MsrvRequest msrvRequest = (MsrvRequest) ThreadContextUtil.getInstance().get("RPC_REQUEST");
        SomeEnum serviceScene = msrvRequest.getServiceScene();
        if (SomeEnum.QUERY == serviceScene || SomeEnum.ASYNC_TASK == serviceScene) {
            // 查询场景不处理幂等
            return true;
        }

        String idemSerialNo = msrvRequest.getIdemSerialNo();
        String key = Cache.genKey("__IdemSerialNo:" + idemSerialNo);
        if (Cache.get(key).equals("1")) {
            // 校验失败，抛出异常
            throw new Exception(EnumRpcError.IDEMPOTENT_ERROR.getCode());
        }

        // 设置缓存
        Cache.set(key, "1");

        return true;
    }

    // TODO: 需要依赖redis
    private static class Cache {
        public static void set(String key, String val) {

        }

        public static String get(String key) {
            return null;
        }

        public static String genKey(String key) {
            return key;
        }
    }

    /**
     * 请求参数， 前端header中加的参数是base64后的，到达gateway后解析为明文，然后rpc时传递
     */
    @Data
    public static class MsrvRequest {

        private SomeEnum ask; // 请求模块，发送rpc前通过注解构造

        private SomeEnum answer; // 影响模块，发送rpc前通过注解构造

        // 服务场景
        private SomeEnum serviceScene;

        private String channelNo; // 渠道id，等其他参数

        /**
         * 幂等流水号（前端发送请求时uuid生成)
         */
        private String idemSerialNo;

        /**
         * 签名验证
         */
        private String sign;

        /**
         * token
         */
        private String token;
        /**
         * ... 其他相关的用户信息等
         * userId, username
         */
    }

    // TODO: 未定义的枚举
    public enum SomeEnum {
        QUERY,
        ASYNC_TASK,

        OTHER, PAY;
    }
}
