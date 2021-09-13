package com.feyfree.leetcode.p0230;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author leilei
 */
public class Solution {

    private int count = 0;

    private int val = -1;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return val;
    }

    private void traverse(TreeNode root, int k) {
        if (root != null) {
            traverse(root.left, k);
            count++;
            if (count == k) {
                val = root.val;
                return;
            }
            traverse(root.right, k);
        }
    }
}
