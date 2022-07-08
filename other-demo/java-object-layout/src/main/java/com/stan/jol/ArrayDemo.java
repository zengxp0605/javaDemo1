package com.stan.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zengxp
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }
}
