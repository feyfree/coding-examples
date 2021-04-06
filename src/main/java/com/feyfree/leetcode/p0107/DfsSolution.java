package com.feyfree.leetcode.p0107;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs 搜索
 *
 * @author leilei
 */
public class DfsSolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        Collections.reverse(result);
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
