package com.feyfree.leetcode.p104;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * leetcode 104
 * <p>
 * 分治的思想
 *
 * @author leilei
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}