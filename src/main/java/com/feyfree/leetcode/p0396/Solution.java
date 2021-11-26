package com.feyfree.leetcode.p0396;

/**
 * https://leetcode-cn.com/problems/rotate-function/
 * 396. 旋转函数
 *
 * @author leilei
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int result = f;
        for (int i = 0; i < n - 1; i++) {
            f = f + sum - n * nums[n - i - 1];
            result = Math.max(result, f);
        }
        return result;
    }
}
