package com.feyfree.leetcode.p0329;

import java.util.Arrays;

/**
 * 329. 矩阵中的最长递增路径
 *
 * @author leilei
 */
public class Solution {

    private int m;

    private int n;

    private int[][] dp;

    private final int[] dirs = new int[]{0, -1, 0, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return 0;
        }
        n = matrix[0].length;
        dp = new int[m][n];
        for (int[] item : dp) {
            Arrays.fill(item, -1);
        }
        int ans = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                ans = Math.max(ans, dfs(matrix, x, y));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        // 开始处理
        dp[y][x] = 1;
        // 邻居
        for (int i = 0; i < 4; i++) {
            int tx = x + dirs[i];
            int ty = y + dirs[i + 1];
            if (ty < 0 || tx < 0 || tx >= n || ty >= m || matrix[ty][tx] <= matrix[y][x]) {
                continue;
            }
            dp[y][x] = Math.max(dp[y][x], 1 + dfs(matrix, tx, ty));
        }
        return dp[y][x];
    }
}
