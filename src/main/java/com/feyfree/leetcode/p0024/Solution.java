package com.feyfree.leetcode.p0024;

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
        ListNode cur = dummy;
        while (true) {
            ListNode b = cur.next;
            if (b == null) {
                break;
            }
            ListNode c = b.next;
            if (c == null) {
                break;
            }
            cur.next = c;
            ListNode d = c.next;
            c.next = b;
            b.next = d;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}