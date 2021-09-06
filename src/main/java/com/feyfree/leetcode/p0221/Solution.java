package com.feyfree.leetcode.p0221;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 221. 最大正方形
 *
 * @author leilei
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = matrix[i - 1][j - 1] - '0'
                        + sums[i - 1][j]
                        + sums[i][j - 1]
                        - sums[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = Math.min(m - i + 1, n - j + 1); k > 0; --k) {
                    int sum = sums[i + k - 1][j + k - 1]
                            - sums[i + k - 1][j - 1]
                            - sums[i - 1][j + k - 1]
                            + sums[i - 1][j - 1];
                    // full of 1
                    if (sum == k * k) {
                        ans = Math.max(ans, sum);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}