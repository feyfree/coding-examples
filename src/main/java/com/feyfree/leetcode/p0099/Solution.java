package com.feyfree.leetcode.p0099;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 恢复搜索二叉树
 *
 * @author leilei
 */
public class Solution {

    /**
     * 保留一个递归的前继 节点
     */
    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null && root.val <= prev.val) {
            if (first != null) {
                first = prev;
            } else {
                second = root;
            }
        }
        // 前继 节点设置为 当前节点 继续递归
        prev = root;
        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }
}
