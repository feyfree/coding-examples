package com.feyfree.leetcode.p152;


/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author leilei
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 长度实际上只需要2  保存一个当前状态和上一个状态的
        int[][] dp = new int[2][2];
        if (n == 1) {
            return nums[0];
        }
        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        int result = nums[0];
        // 存一个 +max 和 -max
        for (int i = 1; i < n; i++) {
            int x = i % 2;
            int y = (i - 1) % 2;
            dp[x][0] = threeMax(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            dp[x][1] = threeMin(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            result = Math.max(result, dp[x][0]);
        }
        return result;

    }

    private int threeMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int threeMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}