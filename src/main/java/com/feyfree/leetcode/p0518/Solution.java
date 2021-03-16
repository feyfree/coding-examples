package com.feyfree.leetcode.p0518;

/**
 * 零钱对换 II
 *
 * @author leilei
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount - coin; ++i) {
                dp[i + coin] += dp[i];
            }
        }
        return dp[amount];
    }
}

