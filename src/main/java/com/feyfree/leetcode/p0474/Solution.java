package com.feyfree.leetcode.p0474;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * @author leilei
 */
public class Solution {


    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // 三维dp
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = calculateString(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }



    private int[] calculateString(String s) {
        int[] result = new int[2];
        for (char i : s.toCharArray()) {
            result[i - '0']++;
        }
        return result;
    }
}
