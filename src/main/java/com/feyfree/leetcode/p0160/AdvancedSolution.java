package com.feyfree.leetcode.p0160;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 双指针解法
 * 交点只有一个next 所以之后肯定是在一起的
 *
 * @author leilei
 */
public class AdvancedSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
