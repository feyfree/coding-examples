package com.feyfree.leetcode.p0213;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author leilei
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(range(nums, 0, nums.length - 2), range(nums, 1, nums.length - 1));
    }


    private int range(int[] nums, int start, int end) {
        int a = nums[start];
        int b = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = b;
            b = Math.max(temp, a + nums[i]);
            a = temp;
        }
        return b;
    }
}
