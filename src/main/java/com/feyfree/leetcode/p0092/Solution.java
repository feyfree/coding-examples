package com.feyfree.leetcode.p0092;

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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution solution = new Solution();
        solution.reverseBetween(a, 2, 3);
        solution.printNodes(a);
    }

    private void printNodes(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
