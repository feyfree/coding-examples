package com.feyfree.leetcode.p0238;

import java.util.Arrays;

/**
 * 常数空间解法
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = 1;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i = 0; i < n; i++) {
            result[i] *= l;
            result[n - i - 1] *= r;
            l *= nums[i];
            r *= nums[n - i - 1];
        }
        return result;
    }
}
