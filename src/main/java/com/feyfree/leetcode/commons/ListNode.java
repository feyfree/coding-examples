package com.feyfree.leetcode.commons;

import lombok.Data;

/**
 * 链表节点
 *
 * @author leilei
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {}
}
