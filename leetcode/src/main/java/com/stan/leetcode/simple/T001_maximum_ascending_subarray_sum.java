package com.stan.leetcode.simple;

/**
 * 1800. 最大升序子数组和
 * <https://leetcode.cn/problems/maximum-ascending-subarray-sum/>
 */
public class T001_maximum_ascending_subarray_sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * 示例1：
         * 输入：nums = [10,20,30,5,10,50]
         * 输出：65
         * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
         */
        int sum;
        int[] nums1 = new int[]{10, 20, 30, 5, 10, 50};
        sum = solution.maxAscendingSum(nums1);
        System.out.println("sum=" + sum);
        assert sum == 65;

        /**
         * 示例 2：
         *
         * 输入：nums = [10,20,30,40,50]
         * 输出：150
         * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
         */
        int[] nums2 = new int[]{10, 20, 30, 40, 50};
        sum = solution.maxAscendingSum(nums2);
        System.out.println("sum=" + sum);
        assert sum == 150;
        /**
         * 示例 3：
         *
         * 输入：nums = [12,17,15,13,10,11,12]
         * 输出：33
         * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
         */
        int[] nums3 = new int[]{12, 17, 15, 13, 10, 11, 12};
        sum = solution.maxAscendingSum(nums3);
        System.out.println("sum=" + sum);
        assert sum == 33;
        /**
         * 示例 4：
         *
         * 输入：nums = [100,10,1]
         * 输出：100
         */
        int[] nums4 = new int[]{100, 10, 1};
        sum = solution.maxAscendingSum(nums4);
        System.out.println("sum=" + sum);
        assert sum == 100;

        int[] nums5 = new int[]{6};
        sum = solution.maxAscendingSum(nums5);
        System.out.println("sum=" + sum);
        assert sum == 6;
    }

    static class Solution {
        public int maxAscendingSum(int[] nums) {
            int prevItem = nums[0];
            int sum = prevItem;
            int maxSum = prevItem;

            for (int i = 1; i < nums.length; i++) {
                int curItem = nums[i];
                if (curItem > prevItem) {
                    sum += curItem;
                } else {
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                    sum = curItem;
                }

                prevItem = curItem;
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
            return maxSum;
        }
    }
}
