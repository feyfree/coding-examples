package com.feyfree.leetcode.p0025;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 另外一种解法
 * <p>
 * 第一种解法需要遍历一遍
 * <p>
 * 如果等待变化的是连续的流的话, 则需要等待流结束
 *
 * @author leilei
 */
public class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        int temp = 0;
        while (true) {
            ListNode loop = pre;
            while (loop != null) {
                loop = loop.next;
                temp += 1;
            }
            if (temp <= k) {
                break;
            }
            ListNode cur = pre.next;
            ListNode nxt = cur.next;
            for (int j = 1; j < k && nxt != null; j++) {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
            temp = 0;
        }
        return dummy.next;
    }
}
