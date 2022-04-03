package com.jason.basejava.others;

import java.math.BigDecimal;

/**
 * Java 8种原始数据类型
 */
public class PrimitiveTypeTest {

    static boolean bool;
    static byte by;
    static char ch;
    static double d;
    static float f;
    static int i;
    static long l;
    static short sh;
    static String str;

    /**
     *  浮点型测试
     *  不能用于存储货币等精度要求高的数据
     */
    public static void test1(){
        System.out.println();
        double a = 0.03d;
        float b = 0.02f;
        double c = a- b;
        System.out.println("c = 0.03 - 0.02 = " + c);
        // output:  0.010000000447034835

        // 使用 BigDecimal
        BigDecimal b1 = new BigDecimal(0.03);
        BigDecimal b2 = new BigDecimal(0.02);
        b1 = b1.add(b2);
        BigDecimal b3 = new BigDecimal(0.01);
        System.out.println("减法结果: "  + b1.subtract(b3).doubleValue());
        // output: 减法结果: 0.04
    }

    /**
     * 各种数据类型的默认值
     */
    public static void printDefaultValues() {
        System.out.println("Bool :" + bool); // false
        System.out.println("Byte :" + by); // 0
        System.out.println("Character:" + ch); // ""
        System.out.println("Double :" + d); // 0.0d
        System.out.println("Float :" + f); // 0.0f
        System.out.println("Integer :" + i); // 0
        System.out.println("Long :" + l); // 0
        System.out.println("Short :" + sh); // 0
        System.out.println("String :" + str); // null
    }

    public static void main(String[] args) {
        // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);

        printDefaultValues();
        test1();
    }
}