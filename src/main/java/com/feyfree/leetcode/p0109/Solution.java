package com.feyfree.leetcode.p0109;

import com.feyfree.leetcode.commons.ListNode;
import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (null != node) {
            list.add(node.val);
            node = node.next;
        }
        return buildBST(list, 0, list.size() - 1);
    }

    /**
     * 构建平衡二叉搜索树
     *
     * @param nums 有序数组
     * @param l    左边界
     * @param r    右边界
     * @return 节点
     */
    private TreeNode buildBST(List<Integer> nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums.get(m));
        root.left = buildBST(nums, l, m - 1);
        root.right = buildBST(nums, m + 1, r);
        return root;
    }
}
