package com.feyfree.leetcode.p0096;

/**
 * 二叉搜索树总数
 *
 * @author leilei
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int out = solution.numTrees(3);
        System.out.println(out);
    }
}
