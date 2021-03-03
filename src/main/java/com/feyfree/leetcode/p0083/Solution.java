package com.feyfree.leetcode.p0083;

import com.feyfree.leetcode.commons.ListNode;

/**
 * p83
 *
 * @author leilei
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy.next;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
