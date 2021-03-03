package com.feyfree.leetcode.p0102;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （
 * 即逐层地，从左到右访问所有节点）
 * <p>
 * https://zxi.mytechroad.com/blog/leetcode/leetcode-102-binary-tree-level-order-traversal/
 * <p>
 * BFS solution
 *
 * @author leilei
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }
}
