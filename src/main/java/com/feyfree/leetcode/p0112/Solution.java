package com.feyfree.leetcode.p0112;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 是否存在根节点  到叶子节点路径上所有的和值为targetSum
 *
 * @author leilei
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
