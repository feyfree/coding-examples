package com.feyfree.leetcode.p0234;

import com.feyfree.leetcode.commons.ListNode;

/**
 * @author leilei
 */
public class SlowFastPointerSolution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if fast != nullptr, list has odd numbers
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
