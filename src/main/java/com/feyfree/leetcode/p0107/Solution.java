package com.feyfree.leetcode.p0107;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 102 题 最后添加reverse即可
 *
 * @author leilei
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 当前需要访问的node 列表
        List<TreeNode> curr = new ArrayList<>();
        // 下一次需要访问的 node 列表
        List<TreeNode> next = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            result.add(new ArrayList<>());
            for (TreeNode node : curr) {
                result.get(result.size() - 1).add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            curr = new ArrayList<>(next);
            next.clear();
        }
        Collections.reverse(result);
        return result;
    }
}