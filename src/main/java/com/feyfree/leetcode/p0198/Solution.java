package com.feyfree.leetcode.p0198;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * 滚动数组
 *
 * @author leilei
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            int a = nums[0];
            int b = nums[1];
            b = Math.max(a, b);
            for (int i = 2; i < nums.length; i++) {
                int temp = a;
                a = b;
                b = Math.max(b, temp + nums[i]);
            }
            return b;
        }
    }
}
