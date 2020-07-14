package com.feyfree.leetcode.p23;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 合并K个排序链表
 * <p>
 * merge-k-sorted-lists
 *
 * @author leilei
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        if (n == 1) {
            return lists[0];
        } else if (n == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        } else {
            int mid = n / 2;
            ListNode[] pre = subArray(lists, mid, true);
            ListNode preList = mergeKLists(pre);
            ListNode[] after = subArray(lists, mid, false);
            ListNode afterList = mergeKLists(after);
            return mergeKLists(new ListNode[]{preList, afterList});
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    private ListNode[] subArray(ListNode[] target, int mid, boolean previous) {
        ListNode[] listNodes;
        if (previous) {
            listNodes = new ListNode[mid];
            if (mid >= 0) {
                System.arraycopy(target, 0, listNodes, 0, mid);
            }
        } else {
            listNodes = new ListNode[target.length - mid];
            if (mid >= 0) {
                System.arraycopy(target, mid, listNodes, 0, target.length - mid);
            }
        }
        return listNodes;
    }
}
