package com.feyfree.leetcode.p0002;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definition for singly-linked list.
 *
 * @author leilei
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}