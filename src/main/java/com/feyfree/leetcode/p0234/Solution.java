package com.feyfree.leetcode.p0234;

import com.feyfree.leetcode.commons.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 是否是回文链表
 *
 * @author leilei
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Deque<ListNode> deque = new LinkedList<>();
        while (temp != null) {
            deque.add(temp);
            temp = temp.next;
        }
        while (deque.size() > 1) {
            ListNode last = deque.removeLast();
            ListNode first = deque.removeFirst();
            if (last.val != first.val) {
                return false;
            }
        }
        return true;
    }
}
