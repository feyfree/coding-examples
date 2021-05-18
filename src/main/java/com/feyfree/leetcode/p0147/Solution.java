package com.feyfree.leetcode.p0147;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @author leilei
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = head, curr = head.next;
        while (curr != null) {
            if (last.val <= curr.val) {
                last = last.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                last.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = last.next;
        }
        return dummy.next;
    }
}



