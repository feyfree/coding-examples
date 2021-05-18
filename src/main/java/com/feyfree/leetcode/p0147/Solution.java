package com.feyfree.leetcode.p0147;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @author leilei
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode current = head.next;
        ListNode preAdded = head;
        while (current != null) {
            insertionNode(head, current, preAdded);
            preAdded = current;
            current = current.next;
        }
        return head;
    }


    private void insertionNode(ListNode head, ListNode added, ListNode preAdded) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode current = head;
        while (current != null) {
            if (current.equals(added)) {
                break;
            }
            // front
            if (current.val >= added.val) {
                // 进行断链
                ListNode preNext = pre.next;
                current.next = added.next;
                added.next = preNext;
                pre.next = added;
            }
            // next
            else {
                // 指针前进找到索引 前进步数不能大于 index
                pre = current;
                current = current.next;
            }
        }
    }
}
