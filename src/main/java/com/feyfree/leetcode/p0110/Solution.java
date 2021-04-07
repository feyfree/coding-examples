package com.feyfree.leetcode.p0110;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 检查是否是平衡二叉树
 * 尝试递归方法
 *
 * @author leilei
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}