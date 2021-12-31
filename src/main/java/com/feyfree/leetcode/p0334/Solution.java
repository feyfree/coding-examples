package com.feyfree.leetcode.p0334;

/**
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * 334. 递增的三元子序列
 * 思路和接雨水相似 42题目
 * 这道题目可以压缩
 *
 * @author leilei
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 动态规划
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        // 0 - i
        int[] low = new int[n];
        // i to n - 1
        int[] high = new int[n];
        for (int i = 0; i < n; i++) {
            low[i] = i == 0 ? nums[i] : Math.min(low[i - 1], nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            high[i] = i == n - 1 ? nums[i] : Math.max(high[i + 1], nums[i]);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > low[i] && nums[i] < high[i]) {
                return true;
            }
        }
        return false;
    }
}
