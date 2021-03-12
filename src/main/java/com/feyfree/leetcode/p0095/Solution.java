package com.feyfree.leetcode.p0095;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的性质
 * 根节点的值大于左子树所有节点的值，小于右子树所有节点的值
 * Hint https://zxi.mytechroad.com/blog/uncategorized/leetcode-95-unique-binary-search-trees-ii/
 *
 * @author leilei
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            ans.add(null);
            return ans;
        }
        for (int i = l; i <= r; ++i) {
            for (TreeNode left : generateTrees(l, i - 1)) {
                for (TreeNode right : generateTrees(i + 1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
