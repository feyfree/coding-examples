package com.feyfree.leetcode.p0221;

/**
 * 解法参照huahua
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-221-maximal-square/
 * 代码进行优化
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int ans = 0;
        int[][] sizes = new int[m + 1][n + 1];
        // 以 sizes[i][j] 作为小正方形的右下角
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sizes[i][j] = matrix[i][j] - '0';
                if (sizes[i][j] == 0) {
                    continue;
                }
                if (i > 0 && j > 0) {
                    sizes[i][j] = Math.min(Math.min(sizes[i - 1][j - 1],
                            sizes[i - 1][j]),
                            sizes[i][j - 1]) + 1;
                }
                ans = Math.max(ans, sizes[i][j] * sizes[i][j]);
            }
        }
        return ans;
    }
}
