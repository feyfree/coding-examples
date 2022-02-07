package com.feyfree.leetcode.p0437;

import com.feyfree.leetcode.commons.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int result = pathSum0(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);
        return result;
    }

    public int pathSum0(TreeNode root, int targetSum) {
        int result = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;

        if (val == targetSum) {
            result++;
        }

        result += pathSum0(root.left, targetSum - val);
        result += pathSum0(root.right, targetSum - val);
        return result;
    }
}

