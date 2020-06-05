package com.feyfree.leetcode.p2;

import lombok.Data;

/**
 * Definition for singly-linked list.
 *
 * @author leilei
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}