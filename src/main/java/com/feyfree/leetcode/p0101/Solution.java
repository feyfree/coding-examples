package com.feyfree.leetcode.p0101;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 对称二叉树
 *
 * @author leilei
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSameVal(root.left, root.right);
    }

    private boolean isSameVal(TreeNode p, TreeNode q) {
        return (p == null && q == null) || (p != null && q != null && q.val == p.val && isSameVal(p.left, q.right) && isSameVal(p.right, q.left));
    }
}
