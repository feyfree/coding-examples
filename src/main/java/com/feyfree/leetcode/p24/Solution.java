package com.feyfree.leetcode.p24;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 两两交换链表中的节点
 * swap-nodes-in-pairs
 *
 * @author leilei
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while (true) {
            ListNode b = temp.next;
            if (b == null) {
                break;
            }
            ListNode c = b.next;
            if (c == null) {
                break;
            }
            temp.next = c;
            ListNode d = c.next;
            c.next = b;
            b.next = d;
            temp = temp.next.next;
        }
        return dummy.next;
    }
}