package com.feyfree.leetcode.p235;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 使用while
 *
 * @author feyfree
 */
public class LoopSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && root.val > q.val) {
                root = root.left;
            } else if (p.val > root.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
