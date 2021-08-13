package com.feyfree.leetcode.p0209;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author leilei
 */
public class Solution {

    private int length;

    public int minSubArrayLen(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) {
            return 0;
        }
        if (sum == target) {
            return nums.length;
        }
        length = nums.length;
        dfs(sum, target, nums, 0, nums.length - 1);
        return length;
    }

    private void dfs(int current, int target, int[] nums, int left, int right) {
        if (left > right || right < 0 || left >= nums.length || current < target) {
            return;
        }
        length = Math.min(right - left + 1, length);
        if (left + 1 < nums.length) {
            dfs(current - nums[left], target, nums, left + 1, right);
        }
        if (right - 1 > 0) {
            dfs(current - nums[right], target, nums, left, right - 1);
        }
    }
}