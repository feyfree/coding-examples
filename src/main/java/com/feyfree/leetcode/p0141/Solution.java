package com.feyfree.leetcode.p0141;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 给定一个链表， 判断链表是否有环
 * <p>
 * 龟兔赛跑
 *
 * @author leilei
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}