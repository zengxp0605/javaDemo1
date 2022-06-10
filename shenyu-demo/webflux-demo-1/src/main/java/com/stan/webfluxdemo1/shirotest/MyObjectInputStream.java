package com.stan.webfluxdemo1.shirotest;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * @author zengxp
 * @date 2022/1/28 16:26
 */
@Slf4j
public class MyObjectInputStream extends ObjectInputStream {
    public MyObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        String name = desc.getName();
//        log.info("解析类名：{}", name);

        if ("org.apache.shiro.session.mgt.SimpleSession".equals(name)) {
            return Class.forName("com.stan.webfluxdemo1.shirotest.SimpleSession");
        } else if (name.contains("UserInfoDTO")) {
            return Class.forName("com.stan.webfluxdemo1.shirotest.UserInfoDTO");
        } else if (name.equals("com.fosun.fosunwearcenter.common.BaseDTO")) {
            return Class.forName("com.stan.webfluxdemo1.shirotest.BaseDTO");
        } else if (name.equals("org.apache.shiro.subject.SimplePrincipalCollection")) {
            return Class.forName("com.stan.webfluxdemo1.shirotest.SimplePrincipalCollection");
        } else if (name.startsWith("java.lang")) {
            // 不处理
        } else if (name.startsWith("java.util")) {
            // 不处理
        } else {
            log.error("无法处理的session序列化类: {}", name);
        }

//        else {
//            try {
//                Class.forName(name);
//            } catch (ClassNotFoundException ex) {
//                System.out.println(ex.getMessage());
//                return null;
//            }
//        }

        return super.resolveClass(desc);
    }

    /**
     * 忽略 serialVersionUID校验
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
   /* @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass objectStreamClass = super.readClassDescriptor();
        try {
            Class<?> localClass = Class.forName(objectStreamClass.getName());
            ObjectStreamClass localObjectStreamClass = ObjectStreamClass.lookup(localClass);
            if (null != localObjectStreamClass) {
                long localSerialVersionUID = localObjectStreamClass.getSerialVersionUID();
                long objSerialVersionUID = objectStreamClass.getSerialVersionUID();
                System.out.println("localSerialVersionUID: " + localSerialVersionUID);
                System.out.println("objSerialVersionUID: " + objSerialVersionUID);
                if (localSerialVersionUID != objSerialVersionUID) {
                    return localObjectStreamClass;
                }
            }
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        return objectStreamClass;
    }*/
}
