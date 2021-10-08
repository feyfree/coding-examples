package com.feyfree.leetcode.p0264;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[a] * 2, num3 = dp[b] * 3, num5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                a++;
            }
            if (dp[i] == num3) {
                b++;
            }
            if (dp[i] == num5) {
                c++;
            }
        }
        return dp[n];
    }
}

