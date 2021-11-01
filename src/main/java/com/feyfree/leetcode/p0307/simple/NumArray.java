package com.feyfree.leetcode.p0307.simple;

/**
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * 307. 区域和检索 - 数组可修改
 *
 * @author leilei
 */
public class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }


    public void update(int index, int val) {
        int before = sums[index + 1] - sums[index];
        for (int i = index + 1; i < sums.length; i++) {
            sums[i] = sums[i] - before + val;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
