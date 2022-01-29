package com.feyfree.leetcode.p0430;

import java.util.HashSet;
import java.util.Set;

/**
 * 430. 扁平化多级双向链表
 *
 * @author leilei
 */
class Solution {
    public Node flatten(Node head) {
        Set<Node> marked = new HashSet<>();
        Node dummy = new Node();
        Node prev = dummy;
        flatten0(head, marked, prev);
        return dummy.next;
    }

    private void flatten0(Node head, Set<Node> marked, Node prev) {
        if (head == null) {
            return;
        }
        // 先向下遍历
        if (!marked.contains(head)) {
            prev.next = head;
            flatten0(head.child, marked, head);
            flatten0(head.next, marked, head);
            head.prev = prev;
            marked.add(head);
            head.child = null;
        }
    }
}