package com.feyfree.leetcode.p0110;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 简单做法
 *
 * @author leilei
 */
public class SimpleSolution {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return balanced;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
