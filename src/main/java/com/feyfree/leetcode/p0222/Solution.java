package com.feyfree.leetcode.p0222;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 222. 完全二叉树的节点个数
 *
 * @author leilei
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
