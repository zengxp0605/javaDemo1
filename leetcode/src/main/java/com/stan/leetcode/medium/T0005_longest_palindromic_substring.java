package com.stan.leetcode.medium;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

/**
 * 5. 最长回文子串
 * <https://leetcode.cn/problems/longest-palindromic-substring/>
 * TODO： 没有找到最优解
 */
public class T0005_longest_palindromic_substring {

    public static boolean isPalindromic(String fullStr, int start, int end) {
        try {
            Solution1 solution1 = new Solution1();
            Method isPalindromic = solution1.getClass().getDeclaredMethod("isPalindromic", String.class, int.class, int.class);
            isPalindromic.setAccessible(true);
            Object o = isPalindromic.invoke(solution1, fullStr, start, end);
            return (boolean) o;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void palindrominTest() {
        String s;
        s = "abcababade";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");

        s = "abba";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");

        s = "abcba";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");

        s = "aba";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");

        s = "aa";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");

        s = "a";
        System.out.println(isPalindromic(s, 0, s.length()));
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "", res = "";

        s = "abcababade";
        res = solution.longestPalindrome(s);
        System.out.println(res);
        assert res.equals("ababa");

        // 没有回文的情况
        s = "abc";
        res = solution.longestPalindrome(s);
        System.out.println(res);
        assert res.equals("a");

        s = "babad";
        res = solution.longestPalindrome(s);
        System.out.println(res);
        assert res.equals("bab");
    }


    static class Solution1 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len <= 1) {
                return s;
            }

            // 判断一次全文是否为回文
            if (isPalindromic(s, 0, len)) {
                return s;
            }

            int start, end;
            int maxStart = 0, maxEnd = 0, max = 0;

            // 最少2个字符开始判断
            for (int i = 0; i < len; i++) {
                for (int j = len; j >= i + 2; j--) {
                    start = i;
                    end = j;

                    // 当前长度已经比max短，则停止本次遍历
                    if (end - start <= max) {
//                        System.out.println(max + "=max, " + (end - start));
                        break;
                    }
//                    System.out.println("i: " + i + ",j: " + j + " ,substr: " + s.substring(start, end));

                    if (isPalindromic(s, start, end)
                            && (end - start > max)
                    ) {
                        maxStart = start;
                        maxEnd = end;
                        max = end - start;
                    }
                }
            }

            if (max == 0) { // 不存在回文的情况
                return String.valueOf(s.charAt(0));
            }

            String res = s.substring(maxStart, maxEnd);
            System.out.println("======" + maxStart + "," + maxEnd + ",res: " + res);

            return res;
        }

        private boolean isPalindromic(String fullStr, int start, int end) {
            int len = end - start;
            int middle = len / 2;
            int prev, next; // 两个指针从中间分别向两端移动
            if (len % 2 == 0) {
                // 偶数位：abba 4%2==0 middle=2
                prev = middle - 1;
                next = middle;
            } else {
                // 奇数位 abcba 5%2==1 middle=2
                prev = middle - 1;
                next = middle + 1;
            }

            for (int i = 0; i < middle; i++) {
                char c1 = fullStr.charAt(start + prev);
                char c2 = fullStr.charAt(start + next);
//                System.out.println(c1 + "-" + c2);
                if (c1 != c2) {
                    return false;
                }
                prev--;
                next++;
            }

            return true;
        }

        private boolean isPalindromic1(String fullStr, int start, int end) {
            String substr = fullStr.substring(start, end);
            String reverse = StringUtils.reverse(substr);
            return substr.equals(reverse);
        }
    }
}
