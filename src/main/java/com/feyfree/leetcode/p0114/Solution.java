package com.feyfree.leetcode.p0114;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 将二叉树转化为链表
 * 链表顺序即为 二叉树的先序遍历
 *
 * @author leilei
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        preOrder(root, dummy);
    }

    public void preOrder(TreeNode root, TreeNode pre) {
        if (root != null) {
            pre.right = root;
            preOrder(root.left, root);
            preOrder(root.right, root);
            root.left = null;
        }
    }
}