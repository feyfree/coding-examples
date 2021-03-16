package com.feyfree.leetcode.p0450;

import com.feyfree.leetcode.commons.TreeNode;

/**
 * delete-node-in-a-bst
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int cmp = Integer.compare(key, root.val);
        // 如果key小于root.val 说明 key 在root.left 里面
        if (cmp < 0) {
            root.left = deleteNode(root.left, key);
        }
        // 如果key 大于root.val 说明key 在 root.right 里面
        else if (cmp > 0) {
            root.right = deleteNode(root.right, key);
        }
        // 如果key == root.val
        else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 如果两边left 和 right 都有的话
            // 1. 保存t 作为 root 的一个引用
            TreeNode t = root;
            // 2. root 设置为 右边的最小值
            root = min(t.right);
            // 3.删除最小值返回的节点作为root的右节点
            root.right = deleteMin(t.right);
            // 4. root 的左节点为一开始的左节点
            root.left = t.left;
        }
        return root;
    }

    private TreeNode min(TreeNode x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    private TreeNode deleteMin(TreeNode x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

}
