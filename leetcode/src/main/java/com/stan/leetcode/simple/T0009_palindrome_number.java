package com.stan.leetcode.simple;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 9. 回文数 <https://leetcode.cn/problems/palindrome-number/description>
 * - 不要转换为字符串
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class T0009_palindrome_number {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x; // -2^31 <= x <= 2^31 - 1
        boolean res;

        x = 123321;
        res = solution.isPalindrome(x);
        assert res == true;

        x = 12321;
        res = solution.isPalindrome(x);
        assert res == true;

//        示例 1：
//        输入：x = 121
//        输出：true
        x = 121;
        res = solution.isPalindrome(x);
        assert res == true;

//        示例 2：
//        输入：x = -121
//        输出：false
//        解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        x = -121;
        res = solution.isPalindrome(x);
        assert res == false;

//        示例 3：
//        输入：x = 10
//        输出：false
//        解释：从右向左读, 为 01 。因此它不是一个回文数。
        x = 10;
        res = solution.isPalindrome(x);
        assert res == false;

        x = 103;
        res = solution.isPalindrome(x);
        assert res == false;

    }

    static class Solution {
        public boolean isPalindrome(int x) {
            // 负数，以0结尾的数字不是回文
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }

            /**
             * x=123321 (偶数位)
             * revertNum: 取值变化 0    ->1     ->12  ->123
             * x=123321: x的取变化 123321->12332->1233->123
             *
             * 奇数位时：
             * x=12321
             * revertNum: 取值变化 0    ->1   ->12->123
             * x=12321: x的取变化 12321->1232->123->12
             */
            int revertNum = 0;
            while (x > revertNum) {
                revertNum = revertNum * 10 + x % 10;
                x = x / 10; // 整除
//                System.out.println("x=" + x + " ,revertNum=" + revertNum);
            }

            return x == revertNum || // 偶数位时
                    x == revertNum / 10; // 奇数位时，通过revertNum/10去除处于中间的位
        }
    }
}
