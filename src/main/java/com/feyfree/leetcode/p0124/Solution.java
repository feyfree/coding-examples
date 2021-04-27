package com.feyfree.leetcode.p0124;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 124. 二叉树最长路径
 *
 * @author leilei
 */
class Solution {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMaxPathSum(root);
        return result;
    }

    /**
     * 实际上是统计以root 为根节点的 路径最大值
     * 递归的同时 更新保存的最大值
     *
     * @param root 根节点
     * @return 以root 为节点的最大值
     */
    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int l = Math.max(0, findMaxPathSum(root.left));
        int r = Math.max(0, findMaxPathSum(root.right));
        int sum = l + r + root.val;
        //
        result = Math.max(result, sum);
        return root.val + Math.max(l, r);
    }
}
