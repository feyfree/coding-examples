package com.feyfree.leetcode.p0494;

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int negative = diff / 2;
        int[] dp = new int[negative + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = negative; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[negative];
    }
}