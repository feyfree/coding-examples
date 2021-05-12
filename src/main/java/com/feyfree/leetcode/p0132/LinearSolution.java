package com.feyfree.leetcode.p0132;

import java.util.Arrays;

/**
 * 线性解法
 *
 * @author leilei
 */
public class LinearSolution {
    public int minCut(String s) {
        int n = s.length();
        // dp[i] = min cuts of s[0~i]
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        for (int m = 0; m < n; ++m) {
            for (int d = 0; d <= 1; ++d) {
                for (int i = m, j = m + d; i >= 0 && j < n && s.charAt(i) == s.charAt(j); --i, ++j) {
                    dp[j] = Math.min(dp[j], (i > 0 ? (dp[i - 1] + 1) : 0));
                }
            }
        }
        return dp[n - 1];
    }
}
