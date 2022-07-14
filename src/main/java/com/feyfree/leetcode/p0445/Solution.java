package com.feyfree.leetcode.p0445;

import com.feyfree.leetcode.commons.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> a = new ArrayDeque<>();
        Deque<Integer> b = new ArrayDeque<>();
        while (l1 != null && l2 != null) {
            a.add(l1.val);
            b.add(l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            a.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            b.add(l2.val);
            l2 = l2.next;
        }
        if (a.size() > b.size()) {
            return addTwoDeque(b, a);
        }
        return addTwoDeque(a, b);
    }

    private ListNode addTwoDeque(Deque<Integer> a, Deque<Integer> b) {
        int flag = 0;
        ListNode head = null;
        while (a.size() > 0 && b.size() > 0) {
            Integer at = a.pollLast();
            Integer bt = b.pollLast();
            int sum = at + bt + flag;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode current = new ListNode(sum % 10);
            current.next = head;
            head = current;
        }
        while (b.size() > 0) {
            Integer bt = b.pollLast();
            int sum = flag + bt;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode current = new ListNode(sum % 10);
            current.next = head;
            head = current;
        }
        if (flag > 0) {
            ListNode current = new ListNode(1);
            current.next = head;
            head = current;
        }
        return head;
    }
}
