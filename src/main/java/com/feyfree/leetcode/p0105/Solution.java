package com.feyfree.leetcode.p0105;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105 前序 中序 生成树
 *
 * @author leilei
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> pos = new HashMap<>(preorder.length);
        for (int i = 0; i < inorder.length; i++) {
            pos.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, preorder.length - 1, pos);
    }


    /**
     * 生成树
     * <p>
     * 由于先序的顺序的第一个肯定是根，所以原二叉树的根节点可以知道，
     * 题目中给了一个很关键的条件就是树中没有相同元素，有了这个条件就可以在中序遍历中也定位出根节点的位置，
     * 并以根节点的位置将中序遍历拆分为左右两个部分，分别对其递归调用原函数
     *
     * @param preorder 先序遍历
     * @param iStart   中序索引
     * @param pStart   先序遍历的起点
     * @param pEnd     先序遍历的终点
     * @param pos      中序位置map
     * @return 构造节点
     */
    private TreeNode buildTree(int[] preorder, int iStart, int pStart, int pEnd, Map<Integer, Integer> pos) {
        if (pStart > pEnd) {
            return null;
        }
        // 找到在inorder 中序遍历 里面的顺序, 因为inorder 左右可以一分为二
        Integer iMid = pos.get(preorder[pStart]);
        // 计算在
        int pMid = pStart + iMid - iStart;
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = buildTree(preorder, iStart, pStart + 1, pMid, pos);
        root.right = buildTree(preorder, iMid + 1, pMid + 1, pEnd, pos);
        return root;
    }
}