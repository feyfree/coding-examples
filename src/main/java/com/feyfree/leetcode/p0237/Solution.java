package com.feyfree.leetcode.p0237;

import com.feyfree.leetcode.commons.ListNode;

/**
 * 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author leilei
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}