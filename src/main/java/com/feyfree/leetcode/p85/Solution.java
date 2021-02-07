package com.feyfree.leetcode.p85;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * @author leilei
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // DP
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        // dp[i][j] 存储的是
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = (matrix[i][j] == '1') ? (j == 0 ? 1 : dp[i][j - 1] + 1) : 0;
            }
        }
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int len = Integer.MAX_VALUE;
                for (int k = i; k < rows; k++) {
                    len = Math.min(len, dp[k][j]);
                    if (len == 0) {
                        break;
                    }
                    result = Math.max(len * (k - i + 1), result);
                }
            }
        }
        return result;
    }
}
