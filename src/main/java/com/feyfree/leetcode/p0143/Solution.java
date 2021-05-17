package com.feyfree.leetcode.p0143;

/**
 * Definition for singly-linked list.
 */
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
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * @author leilei
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        //1. find the middle of list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2nd half start from next node of the middle one
        ListNode tmp = slow.next;
        slow.next = null;

        //2. reverse last half of list
        ListNode newHead = reverseList(tmp);

        //3. connect 1st half to 2nd half
        ListNode cur = head;
        while (cur != null && newHead != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = newHead.next;
            cur.next = newHead;
            newHead.next = tmp1;
            cur = tmp1;
            newHead = tmp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        // 表示前驱节点
        ListNode pre = null;
        while (head != null) {
            // 表示当前节点
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
