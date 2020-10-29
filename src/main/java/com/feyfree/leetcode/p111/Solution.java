package com.feyfree.leetcode.p111;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * leetcode 111
 *
 * @author leilei
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)
                ? left + right + 1 : Math.min(left, right) + 1;
    }
}
