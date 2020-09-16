package com.feyfree.leetcode.p62;

/**
 * 典型的动态规划
 *
 * @author leilei
 */
class ModifiedSolution {

    private int[][] dp;
    private int m;
    private int n;

    public int uniquePaths(int m, int n) {
        this.dp = new int[m][n];
        this.m = m;
        this.n = n;
        return dfs(0, 0);
    }

    private int dfs(int x, int y) {
        if (x > m - 1 || y > n - 1) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] == 0) {
            dp[x][y] = dfs(x + 1, y) + dfs(x, y + 1);
        }
        return dp[x][y];
    }
}
