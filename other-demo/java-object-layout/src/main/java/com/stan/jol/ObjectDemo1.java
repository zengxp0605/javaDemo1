package com.stan.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author zengxp
 */
public class ObjectDemo1 {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        // 类结构
        System.out.println(ClassLayout.parseClass(ObjectDemo1.class).toPrintable());

        // 对象实例
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
