package com.feyfree.leetcode.p0138;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author leilei
 */
public class Solution {
    public Node copyRandomList(Node head) {
        return new Node(0);
    }
}
