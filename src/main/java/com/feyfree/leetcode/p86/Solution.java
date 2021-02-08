package com.feyfree.leetcode.p86;

import com.feyfree.leetcode.commons.ListNode;

/**
 * p86 solution
 * <p>
 * 分隔链表
 * 思路上面:
 * 这个跟快排的最底层的思想
 *
 * @author leilei
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        return null;
    }

    private void swapNode(ListNode pre, ListNode a, ListNode b) {
        if (a != null && b != null) {
            ListNode temp = a.next;
            a.next = b.next;
            b.next = temp;
            pre.next = b;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        Solution solution = new Solution();
        solution.swapNode(head, a, d);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
