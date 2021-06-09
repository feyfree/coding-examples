package com.feyfree.leetcode.p0160;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 相交链表
 * <p>
 * 暴力解法
 *
 * @author leilei
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        while (dummyA != null) {
            ListNode dummyB = headB;
            while (dummyB != null) {
                if (dummyA.equals(dummyB)) {
                    return dummyA;
                }
                dummyB = dummyB.next;
            }
            dummyA = dummyA.next;
        }
        return null;
    }
}