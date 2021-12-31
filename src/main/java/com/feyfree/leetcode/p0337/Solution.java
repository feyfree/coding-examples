package com.feyfree.leetcode.p0337;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 337. 打家劫舍 III
 *
 * @author leilei
 */
public class Solution {

    public int rob(TreeNode root) {
        int[] children = {0, 0};
        return rob0(root, children);
    }

    private int rob0(TreeNode root, int[] children) {
        if (root == null) {
            return 0;
        }
        int[] left = {0, 0};
        int[] right = {0, 0};
        children[0] = rob0(root.left, left);
        children[1] = rob0(root.right, right);
        return Math.max(root.val + left[0] + left[1] + right[0] + right[1], children[0] + children[1]);
    }
}
