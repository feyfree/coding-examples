package com.feyfree.leetcode.p98;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 保留一个递归的前继 节点
     */
    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inOrder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        // 前继 节点设置为 当前节点 继续递归
        prev = root;
        return inOrder(root.right);
    }
}
