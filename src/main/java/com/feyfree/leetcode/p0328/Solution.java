package com.feyfree.leetcode.p0328;

import com.feyfree.leetcode.commons.ListNode;

/**
 * @author leilei
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode[] heads = new ListNode[]{new ListNode(0), new ListNode(0)};
        ListNode[] prev = new ListNode[]{heads[0], heads[1]};
        int index = 0;
        // 一次循环  所以head 需要每次断链， 断链前保存next的值
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            prev[index].next = head;
            prev[index] = prev[index].next;
            head = next;
            index ^= 1;
        }
        prev[0].next = heads[1].next;
        return heads[0].next;
    }
}

