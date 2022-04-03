package com.jason.basejava.tryCatchTest;

public class ReturnTest {
    public static void main(String[] args) {

        System.out.println("");
        System.out.println("1 =====> try中return的结果: " + test1());
        System.out.println("");

        System.out.println("2 =====> catch中return的结果: " + test2());
        System.out.println("");

        System.out.println("3 =====> finally中return的结果: " + test3());
        System.out.println("");

        System.out.println("4 =====> finally中没有return的结果: " + test4());
    }

    static int test1(){
        int num = 10;
        try{
            System.out.println("try");
            return num += 80;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
        }

        return num;
    }

    static int test2(){
        int num = 10;
        try{
            System.out.println("try");
            throw new Exception("My test error.");
        }catch(Exception e){
            System.out.println("error");
            return num += 80;
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
        }
    }

    static int test3(){
        int num = 10;
        try{
            System.out.println("try");
            return num += 80;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num =100;
            return num;
        }
    }

    static int test4(){
        int num = 10;
        try{
            System.out.println("try");
            return num;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num =30; // 这里的赋值没有作用
        }

        // TODO: 这里返回的是 10
        return num;
    }
}
