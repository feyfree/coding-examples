package com.feyfree.leetcode.p206;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 翻转链表
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 表示前驱节点
        ListNode pre = null;
        while (head != null) {
            // 表示当前节点
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
