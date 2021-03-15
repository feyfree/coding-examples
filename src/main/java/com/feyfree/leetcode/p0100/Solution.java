package com.feyfree.leetcode.p0100;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * 是否是相同的树
 *
 * @author leilei
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean sameVal = (p == null && q == null) || (p != null && q != null && p.val == q.val);
        if (sameVal && p != null) {
            sameVal = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return sameVal;
    }
}