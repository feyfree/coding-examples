package com.feyfree.leetcode.p0377;

import java.util.Arrays;

/**
 * @author leilei
 */
class Solution {

    private int[] summary;

    public int combinationSum4(int[] nums, int target) {
        summary = new int[target + 1];
        Arrays.fill(summary, -1);
        summary[0] = 1;
        return dp(nums, target);
    }


    private int dp(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (summary[target] != -1) {
            return summary[target];
        }
        int result = 0;
        for (int num : nums) {
            result += dp(nums, target - num);
        }
        summary[target] = result;
        return result;
    }
}
