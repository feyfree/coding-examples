package com.feyfree.leetcode.p0114;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 将二叉树转化为链表
 * 链表顺序即为 二叉树的先序遍历
 * <p>
 * 递归写法 recursion
 *
 * @author leilei
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }
}