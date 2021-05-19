package com.feyfree.leetcode.p0148;

/**
 * 自底向上
 *
 * @author leilei
 */
public class BottomUpSolution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        int len = 1;
        while (true) {
            current = current.next;
            if (current == null) {
                break;
            }
            len++;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l, r, tail;
        for (int n = 1; n < len; n <<= 1) {
            current = dummy.next;
            tail = dummy;
            while (current != null) {
                l = current;
                r = split(l, n);
                current = split(r, n);
                ListNode[] merged = merge(l, r);
                tail.next = merged[0];
                tail = merged[1];
            }
        }
        return dummy.next;
    }


    private ListNode split(ListNode head, int n) {
        while (--n > 0 && head != null) {
            head = head.next;
        }
        ListNode result = head != null ? head.next : null;
        if (head != null) {
            head.next = null;
        }
        return result;
    }


    /**
     * 合并两个链表
     * <p>
     * merge 可以递归写 可以减少新建节点， 但是会增加栈得深度
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 生成得节点
     * @see com.feyfree.leetcode.p0021.Solution
     */
    private ListNode[] merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        while (tail.next != null) {
            tail = tail.next;
        }
        return new ListNode[]{dummy, tail};
    }
}
