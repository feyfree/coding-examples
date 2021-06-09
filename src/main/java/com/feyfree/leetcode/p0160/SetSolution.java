package com.feyfree.leetcode.p0160;

import com.feyfree.leetcode.commons.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合解法
 *
 * @author leilei
 */
public class SetSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while (dummyA != null || dummyB != null) {
            if (dummyA != null) {
                if (set.contains(dummyA)) {
                    return dummyA;
                } else {
                    set.add(dummyA);
                }
                dummyA = dummyA.next;
            }
            if (dummyB != null) {
                if (set.contains(dummyB)) {
                    return dummyB;
                } else {
                    set.add(dummyB);
                }
                dummyB = dummyB.next;
            }
        }
        return null;
    }
}
