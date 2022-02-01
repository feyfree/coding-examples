package com.feyfree.leetcode.p0430;

/**
 * 430. 扁平化多级双向链表
 *
 * @author leilei
 */
class Solution {
    public Node flatten(Node head) {
        flatten0(head);
        return head;
    }

    public Node flatten0(Node node) {
        Node current = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (current != null) {
            Node next = current.next;
            //  如果有子节点，那么首先处理子节点
            if (current.child != null) {
                Node lastChild = flatten0(current.child);

                next = current.next;
                //  将 node 与 child 相连
                current.next = current.child;
                current.child.prev = current;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    lastChild.next = next;
                    next.prev = lastChild;
                }

                // 将 child 置为空
                current.child = null;
                last = lastChild;
            } else {
                last = current;
            }
            current = next;
        }
        return last;
    }
}

