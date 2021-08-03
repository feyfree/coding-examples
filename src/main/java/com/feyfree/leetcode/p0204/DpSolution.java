package com.feyfree.leetcode.p0204;

import java.util.Arrays;

/**
 * 动态规划解法
 *
 * @author leilei
 */
public class DpSolution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        dp[1] = 0;
        helper(n, dp);
        return Arrays.stream(dp).sum();
    }


    private void helper(int n, int[] dp) {
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (dp[i] == 1) {
                int k = i * i;
                if (k >= n) {
                    return;
                }
                while (k < n) {
                    dp[k] = 0;
                    k += i;
                }
            }
        }
    }
}
