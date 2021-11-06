package com.feyfree.leetcode.p0264;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // 标识 3个candidate
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[a] * 2, num3 = dp[b] * 3, num5 = dp[c] * 5;
            // 最小的数出现
            dp[i] = Math.min(Math.min(num2, num3), num5);
            // 如果出现在元素a上面, ++ 表明这个地方的数已经被处理过了
            // 核心在于每一个地方的数在滚动中， 都会经历过 *2, *3, *5 这样的操作
            // 比如(3, 2, 1) dp[3] * 2, dp[2] * 3, dp[1] * 5
            // 不会出现 dp[3] * 5 去推演下一个丑数的
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

