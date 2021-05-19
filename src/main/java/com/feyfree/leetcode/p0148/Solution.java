package com.feyfree.leetcode.p0148;




/**
 * 148. 排序链表
 * Top-Down
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author leilei
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
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
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return dummy.next;
    }
}
