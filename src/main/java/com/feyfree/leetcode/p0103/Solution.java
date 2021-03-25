package com.feyfree.leetcode.p0103;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        for (int i = 0; i < result.size(); i += 2) {
            Collections.reverse(result.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, int d, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        while (result.size() <= d) {
            result.add(new ArrayList<>());
        }
        result.get(d).add(root.val);
        dfs(root.right, d + 1, result);
        dfs(root.left, d + 1, result);
    }
}
