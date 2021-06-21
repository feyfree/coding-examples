package com.feyfree.leetcode.p0173;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 * @author leilei
 */
class BSTIterator {
    private int index;
    private final List<Integer> container;

    public BSTIterator(TreeNode root) {
        this.index = 0;
        this.container = new ArrayList<>();
        inorderTraversal(root, container);
    }

    public int next() {
        return container.get(index++);
    }

    public boolean hasNext() {
        return index < container.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}

