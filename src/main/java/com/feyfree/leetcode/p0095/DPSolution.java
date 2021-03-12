package com.feyfree.leetcode.p0095;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划解法
 *
 * @author leilei
 */
public class DPSolution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for (int i = 1; i <= n; ++i) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode root, int delta) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val + delta);
        node.left = clone(root.left, delta);
        node.right = clone(root.right, delta);
        return node;
    }
}