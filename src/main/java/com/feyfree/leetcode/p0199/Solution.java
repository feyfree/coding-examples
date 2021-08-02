package com.feyfree.leetcode.p0199;


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
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author leilei
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (root == null) {
            return;
        }
        while (result.size() <= depth) {
            result.add(null);
        }
        result.set(depth, root.val);
        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }
}
