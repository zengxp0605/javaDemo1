package com.stan.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 2. 两数相加，两个 非空 的链表
 */
public class T0002_linklist_add_two_numbers {

    public static void main(String[] args) {
//        Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        ListNode l1, l2, res;

        l1 = ListNode.make(new int[]{2, 4, 3});
        l2 = ListNode.make(new int[]{5, 6, 4});
        res = solution.addTwoNumbers(l1, l2);
        System.out.println("l1: " + l1 + ",l2: " + l2 + " ,res: " + res);
        assert res.equals(ListNode.make(new int[]{7, 0, 8}));


        l1 = ListNode.make(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = ListNode.make(new int[]{9, 9, 9, 9});
        res = solution.addTwoNumbers(l1, l2);
        System.out.println("l1: " + l1 + ",l2: " + l2 + " ,res: " + res);
        assert res.equals(ListNode.make(new int[]{8, 9, 9, 9, 0, 0, 0, 1}));

    }

    /**
     * 同时遍历两个链表，常规
     */
    static class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode tmpNode = res, l1Node = l1, l2Node = l2;

            int carry = 0; // 暂存进位的数据
            while (l1Node != null || l2Node != null) {
                int curSum;
                if (l1Node == null) {
                    curSum = l2Node.val;
                    l2Node = l2Node.next;
                } else if (l2Node == null) {
                    curSum = l1Node.val;
                    l1Node = l1Node.next;
                } else {
                    curSum = l1Node.val + l2Node.val;
                    l1Node = l1Node.next;
                    l2Node = l2Node.next;
                }

                curSum += carry;
                carry = curSum / 10;
                tmpNode.next = new ListNode(curSum % 10);
                tmpNode = tmpNode.next;
            }

            if (carry > 0) {
                // 最前面需要进一位
                tmpNode.next = new ListNode(carry);
            }

            // 移除头节点
            res = res.next;
            return res;
        }
    }

    /**
     * 递归解法，写法更优雅
     */
    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2, 0);
        }

        private ListNode add(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null && carry == 0) {
                return null; // 链表结尾
            }

            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode res = new ListNode(sum % 10);
            res.next = add(l1, l2, sum / 10); // 传入进位数
            return res;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val; // 头节点也存数据
        ListNode next;

        ListNode() {
        }

        static ListNode make(int[] array) {
            ListNode listNode = new ListNode(array[0]);
            ListNode tmpNode = listNode;
            for (int i = 1; i < array.length; i++) {
                int val = array[i];
                tmpNode.next = new ListNode(val);
                tmpNode = tmpNode.next;
            }
            return listNode;
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public boolean equals(ListNode listNode) {
            return this.toString().equals(listNode.toString());
        }

        @Override
        public String toString() {
            List<Integer> list = new ArrayList<>();
            ListNode tmpNode = this;
            while (tmpNode != null) {
                list.add(tmpNode.val);
                tmpNode = tmpNode.next;
            }
            return list.toString();
        }
    }
}
