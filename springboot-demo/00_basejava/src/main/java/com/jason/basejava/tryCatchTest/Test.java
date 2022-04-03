package com.jason.basejava.tryCatchTest;

public class Test {

    public static void main(String[] args) {
        int a = 1;
        try {
            a = 2;
            testThrow();
            System.out.println("try的消息: " + a);
        } catch (Exception e){
            System.out.println("catch的消息: " + a);
            System.out.println("错误消息: " + e.getMessage());
            a = 10;
        } finally {
            System.out.println("finally的消息: " + a);
            a = 20;
        }

        System.out.println("a = " + a);
    }

    public static void testThrow() throws Exception1 {
        String msg = "inital string";
        try {
            msg = " `string from try`";
            if(Math.random() < 0.6){
                // TODO: throw 之后 finally 语句块还是会执行
                throw new Exception1("My error message -- " + msg);
            }
        } finally {
            msg = " `string from finally`" + Math.random();
            System.out.println("finally: " + msg);
        }

        System.out.println(msg);
    }

}


class Exception1 extends Exception{
    public Exception1(String msg){
        super(msg);
    }

}