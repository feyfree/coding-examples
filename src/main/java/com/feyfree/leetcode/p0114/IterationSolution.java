package com.feyfree.leetcode.p0114;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 迭代解法
 *
 * @author leilei
 */
public class IterationSolution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
