package com.feyfree.leetcode.p92;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 反转链表2
 *
 * @author leilei
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int start = 0;
        ListNode cur = head;
        while (start < left) {
            cur = cur.next;
            start++;
        }
        ListNode stop = cur;
        ListNode pre = null;
        while (start < right) {
            // 表示当前节点
            ListNode temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
            start++;
        }
        stop.next = pre;
        return head;
    }
}
