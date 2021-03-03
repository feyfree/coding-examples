package com.feyfree.leetcode.p0063;

/**
 * leetcode 63 solution
 *
 * @author leilei
 */
public class Solution {
    private int m;
    private int n;
    private int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = m > 0 ? obstacleGrid[0].length : 0;
        this.dp = new int[m][n];
        return dfs(0, 0, obstacleGrid);
    }

    private int dfs(int x, int y, int[][] obstacleGrid) {
        if (x > m - 1 || y > n - 1) {
            return 0;
        }
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] == 0) {
            dp[x][y] = dfs(x + 1, y, obstacleGrid) + dfs(x, y + 1, obstacleGrid);
        }
        return dp[x][y];
    }
}
