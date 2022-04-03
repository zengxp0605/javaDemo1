package com.jason.basejava.stringTest;


public class string1 {

    public static void main(String[] args) {
        System.out.println("Math.round(-1.5) = " + Math.round(-1.5));
        System.out.println("Math.round(-1.6) = " + Math.round(-1.6));
        System.out.println("Math.round(1.5) = " + Math.round(1.5));

        // 字符串反转
        reverseString();

        System.out.println("========================");

        /**  String 类的常用方法 */
        // 构造方法
        stringConstructor();

    }

    /**
     * String类构造方法
     */
    public static void stringConstructor(){
        // 用已知的字符串value创建一个String对象
        String str1 = new String("test-str");
        String str2 = new String(str1);
        System.out.println("str2: " + str2);

        // 用字符数组value创建一个String对象。
        char c = 'c';
        char[] arr = {'a', 'b', c, 'd'};
        String str3 = new String(arr);
        System.out.println("str3: " + str3); // str3: abcd

        // 用字符数组chars的startIndex开始的numChars个字符创建一个String对象。
        String str4 = new String(arr, 1, 2); //
        System.out.println("str4: " + str4);

        // 用比特数组values创建一个String对象。
        byte[] bytes = new byte[]{65, 66, 97, 98}; // ASCII码 ABab
        String str5 = new String(bytes);
        System.out.println("str5: " + str5);

    }

    /**
     * 字符串反转
     */
    public static void reverseString(){
        String str = "zouzou-lover";
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("字符串反转前: " + str);
        System.out.println("字符串反转后: " + reverseStr);

        // StringBuilder reverse
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdefg");
        System.out.println(stringBuilder.reverse());

    }
}
