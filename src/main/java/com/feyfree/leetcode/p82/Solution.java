package com.feyfree.leetcode.p82;

import com.feyfree.leetcode.commons.ListNode;


/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 *
 * @author leilei
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        while (head != null) {
            int num = 0;
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
                num++;
            }
            if (num == 0) {
                p.next = head;
                p = p.next;
            } else {
                p.next = null;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
