package com.feyfree.leetcode.p0019;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 删除链表的倒数第N个节点
 * remove-nth-node-from-end-of-list
 *
 * @author leilei
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;
        while (n > 0) {
            head = head.next;
            n--;
        }
        ListNode endNode = dummy;
        while (head.next != null) {
            head = head.next;
            endNode = endNode.next;
        }
        endNode.next = endNode.next.next;
        return dummy.next;
    }

//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        Solution solution = new Solution();
//        solution.removeNthFromEnd(head, 2);
//
//    }
}
