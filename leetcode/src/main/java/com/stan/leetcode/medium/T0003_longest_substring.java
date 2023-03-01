package com.stan.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class T0003_longest_substring {
    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        String s;
        int c;


//        示例 1:
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        s = "abcabcbb";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 3;

//        示例 2:
//        输入: s = "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        s = "bbbbb";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 1;

//        示例 3:
//        输入: s = "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        s = "pwwkew";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 3;


        // 补丁
        s = "au";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 2;

        // 补丁
        s = "auv";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 3;

        // 补丁
        s = "abcdafghemnca";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 10;

        // 补丁
        s = "tmmzuxt";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 5;

        // 临时
        s = "aabcddc";
        c = solution.lengthOfLongestSubstring(s);
        System.out.println(c);
        assert c == 4;
    }

    /**
     * 自己写的解法1， 暴力解法
     */
    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            if (null == s) {
                return 0;
            }

            int max = s.length();
            if (max == 0) {
                return 0;
            }

            int len = 1;
            // 遍历整个字符串
            for (int i = 0; i < max; i++) {
                int startIdx = i;
                System.out.println("len=" + len + " ,startIdx: " + startIdx);
                // 从2个字符长度开始分割，遇到满足的，则增加一个长度重新开始分割
                for (int j = len + 1; j <= max - startIdx; j++) {
                    String subStr = s.substring(startIdx, startIdx + j);
                    System.out.println("subStr: " + subStr + " ,j=" + j);
                    if (checkNoRepeatChar(subStr)) {
                        len = subStr.length();
                    } else {
                        // 已经重复，则退出本次遍历
                        break;
                    }
                }
            }


            return len;
        }

        /**
         * 判断字符串是否有重复
         *
         * @param s
         * @return
         */
        public boolean checkNoRepeatChar(String s) {
            byte[] bytes = s.getBytes();
            Set<Byte> set = new HashSet<>();
            for (byte aByte : bytes) {
                set.add(aByte);
            }

            return set.size() == s.length();
        }
    }

    /**
     * 滑动窗口解法
     * 两个指针移动
     */
    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if (len <= 1) {
                return len;
            }
            int max = 0;
            int start = 0, idx = 0;
            Map<Character, Integer> map = new HashMap<>();

            for (; idx < len; idx++) {
                Character ch = s.charAt(idx);
                if (map.containsKey(ch)) {
                    // 存在重复的数字，重置起始位置
                    start = Math.max(map.get(ch) + 1, start);
                }

                max = Math.max(max, idx - start + 1);
                System.out.println("start: " + start + " ,idx: " + idx + " ,max: " + max);
                // 保存idx，或者更新idx
                map.put(ch, idx);
            }
            return max;
        }
    }
}
