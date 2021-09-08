package com.feyfree.leetcode.p0226;

import com.feyfree.leetcode.commons.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode node) {
        reverseNode(node);
        return node;
    }

    private void reverseNode(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = invertTree(node.left);
        node.left = invertTree(node.right);
        node.right = left;
    }
}