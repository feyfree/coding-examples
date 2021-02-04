package com.feyfree.leetcode.p84;

/**
 * p84 柱状图最大的矩形
 * 和接雨水不同
 *
 * @author leilei
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // dp[start][end]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = heights[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], heights[j]);
            }
        }
        int result = dp[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result = Math.max(result, dp[i][j] * (j - i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {0, 9};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }
}