package com.feyfree.leetcode.p0113;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        hasPathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void hasPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> current) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(current));
                result.get(result.size() - 1).add(root.val);
            }
            return;
        }
        current.add(root.val);
        int newSum = targetSum - root.val;
        hasPathSum(root.left, newSum, result, current);
        hasPathSum(root.right, newSum, result, current);
        current.remove(current.size() - 1);
    }
}
