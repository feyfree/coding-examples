package com.feyfree.leetcode.p0203;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author leilei
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // pre节点  用于操作链表的断链和拼接
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
