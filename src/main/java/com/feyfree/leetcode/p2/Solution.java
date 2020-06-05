package com.feyfree.leetcode.p2;

/**
 * add - two num
 *
 * @author leilei
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        assert l1 != null;
        assert l2 != null;
        ListNode resultHead = new ListNode();
        ListNode tempHead = resultHead;
        int tempFlag = 0;
        while (l1 != null && l2 != null) {
            int tempSum = l1.val + l2.val + tempFlag;
            int tempResult = tempSum % 10;
            tempFlag = tempSum / 10;
            ListNode data = new ListNode();
            data.val = tempResult;
            tempHead.next = data;
            l1 = l1.next;
            l2 = l2.next;
            tempHead = tempHead.next;
        }
        while (l1 != null) {
            int tempSum = l1.val + tempFlag;
            int tempResult = tempSum % 10;
            tempFlag = tempSum / 10;
            ListNode data = new ListNode();
            data.val = (tempResult);
            tempHead.next = (data);
            l1 = l1.next;
            tempHead = tempHead.next;
        }
        while (l2 != null) {
            int tempSum = l2.val + tempFlag;
            int tempResult = tempSum % 10;
            tempFlag = tempSum / 10;
            ListNode data = new ListNode();
            data.val = (tempResult);
            tempHead.next = data;
            l2 = l2.next;
            tempHead = tempHead.next;
        }
        if (tempFlag == 1) {
            ListNode tail = new ListNode();
            tail.val = 1;
            tempHead.next = (tail);
        }
        return resultHead.next;
    }
}