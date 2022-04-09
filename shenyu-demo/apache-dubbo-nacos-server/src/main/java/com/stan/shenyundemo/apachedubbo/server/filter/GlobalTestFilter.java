package com.stan.shenyundemo.apachedubbo.server.filter;

import com.stan.shenyudemo.dubboapi.annotation.Pid;
import com.stan.shenyudemo.dubboapi.annotation.Uid;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * @Author: zengxp
 * @Date: 2022/1/6 11:20
 * @Desc:
 */
@Activate(group = CommonConstants.PROVIDER, order = -9999)
public class GlobalTestFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Map<String, String> attachments = invocation.getAttachments();
        System.out.println("--->attachments: " + attachments);

        Class<?> invokerInterface = invoker.getInterface();
        System.out.println("--->anInterface: " + invokerInterface);

        Annotation[] interfaceAnnotations = invokerInterface.getAnnotations();
        for (Annotation interfaceAnnotation : interfaceAnnotations) {
            System.out.println("interface Annotation= " + interfaceAnnotation);
        }

        Object[] arguments = invocation.getArguments();

        try {
            Method method = invokerInterface.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation[] parameterAnnotation = parameterAnnotations[i];
                for (Annotation annotation : parameterAnnotation) {
                    System.out.println("------->parameterAnnotation= " + annotation);
                    if (annotation instanceof Uid) {
                        arguments[i] = "over-uid";
                    } else if (annotation instanceof Pid) {
                        arguments[i] = invocation.getAttachment("add-value");
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Result result = invoker.invoke(invocation);

        return result;
    }
}
