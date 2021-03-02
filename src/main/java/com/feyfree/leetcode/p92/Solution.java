package com.feyfree.leetcode.p92;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 反转链表2
 *
 * @author leilei
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode pre = p;
        ListNode cur = p.next;
        ListNode tail = cur;
        for (int i = left; i <= right; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p.next = pre;
        tail.next = cur;
        return dummy.next;
    }
}
