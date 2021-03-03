package com.feyfree.leetcode.p0104;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BFS 解法
 *
 * @author leilei
 */
public class BfsSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        List<TreeNode> next = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            depth += 1;
            for (TreeNode node : curr) {
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
        return depth;
    }
}
