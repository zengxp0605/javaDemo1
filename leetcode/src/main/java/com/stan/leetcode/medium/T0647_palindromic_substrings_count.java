package com.stan.leetcode.medium;

import sun.misc.Unsafe;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * - TODO: 动态规划解法
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 */
public class T0647_palindromic_substrings_count {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        Solution2 solution = new Solution2();
        String s;
        int res;


        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            long i = unsafe.objectFieldOffset(Solution.class.getDeclaredField("i"));
            boolean b = unsafe.compareAndSwapInt(solution, i, 1, 2);
            System.out.println(b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

//        示例 1：
//        输入：s = "abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
        s = "abc";
        res = solution.countSubstrings(s);
        assert res == 3;

//        示例 2：
//        输入：s = "aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
        s = "aaa";
        res = solution.countSubstrings(s);
        assert res == 6;
    }

    static class Solution {
        private static final int i = 1;

        public int countSubstrings(String s) {
            return 0;
        }
    }

    /**
     * ChatGPT 重构的代码
     */
    static class Solution2 {
        public int countSubstrings(String s) {
            int len = s.length();
            if (len <= 1) {
                return len;
            }
            int sum = 0;

            for (int i = 0; i < len; i++) {
                sum++; // 以单个字符为中心的回文串
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < len) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    sum++;
                    left--;
                    right++;
                }

                if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    sum++; // 以相邻两个字符为中心的回文串
                    left = i - 1;
                    right = i + 2;
                    while (left >= 0 && right < len) {
                        if (s.charAt(left) != s.charAt(right)) {
                            break;
                        }
                        sum++;
                        left--;
                        right++;
                    }
                }
            }

            return sum;
        }
    }

    /**
     * 中心扩展写法，代码太丑
     * - 自己初次写的方法
     */
    static class Solution1 {
        public int countSubstrings(String s) {
            int len = s.length();
            if (len <= 1) {
                return len;
            }
            int sum = 0;
//            List<String> list = new ArrayList<>();
            // 找到2位/3位的回文，然后向两端扩展，遇到非回文则停止扩展
            for (int i = 2; i <= 3; i++) {
                int start = 0;
                int end = start + i;
                while (end <= s.length()) {
//                System.out.println(s.substring(start, end) + ",start: " + start + " ,end: " + end);
                    if (this.isPalindrome(s, start, end)) {
//                        list.add(s.substring(start, end));
//                    System.out.println(s.substring(start, end));
                        sum++;
                        // 开始扩展
                        int left = start - 1;
                        int right = end + 1;
                        while (left >= 0 && right <= s.length()) {
//                            if (this.isPalindrome(s, left, right)) {
                            if (s.charAt(left) != s.charAt(right - 1)) {
                                // 这里只需要判断两端新加入的字符是否一致即可（中间位置已经是回文）
                                // 扩展不成功直接退出
                                break;
                            }
//                            System.out.println(s.substring(left, right) + " ,left: " + left + ",right: " + right);
//                            list.add(s.substring(left, right));
                            sum++;
                            left--;
                            right++;
                        }
//                        System.out.println("----");
                    }
                    start++;
                    end = start + i;
                }
//                System.out.println("====================");
            }
//            System.out.println(list);

            return sum + len;
        }

        public boolean isPalindrome(String s, int start, int end) {
            int left = start;
            int right = end - 1; // s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }
    }
}
