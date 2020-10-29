package com.feyfree.leetcode.p102;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS 解法
 *
 * @author leilei
 */
public class DepthFirstSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        while (result.size() <= depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }
}
