package com.feyfree.leetcode.p0303;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 303. 区域和检索 - 数组不可变
 * sum range -> 前缀和相减
 *
 * @author leilei
 */
class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
