package com.feyfree.leetcode.p0429;

import com.feyfree.leetcode.commons.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 *
 * @author leilei
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(root.val);
        levelOrder0(root, result, 0);
        return result;
    }

    private void levelOrder0(Node root, List<List<Integer>> result, int d) {
        if (root == null) {
            return;
        }
        if (root.children != null && !root.children.isEmpty()) {
            d = d + 1;
            for (Node child : root.children) {
                if (d >= result.size() || result.get(d) == null) {
                    result.add(new ArrayList<>());
                }
                result.get(d).add(child.val);
                levelOrder0(child, result, d);
            }
        }
    }
}
