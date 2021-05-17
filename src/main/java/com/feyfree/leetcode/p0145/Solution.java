package com.feyfree.leetcode.p0145;

import java.util.ArrayList;
import java.util.List;

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
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author leilei
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }


    /**
     * 搜索
     *
     * @param root   节点
     * @param result 结果
     */
    private void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            traverse(root.left, result);
            traverse(root.right, result);
            result.add(root.val);
        }
    }
}