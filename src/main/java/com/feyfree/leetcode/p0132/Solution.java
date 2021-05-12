package com.feyfree.leetcode.p0132;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 132. 分割回文串 II
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 思路: 动态规划 + 动态规划
 *
 * @author leilei
 */
public class Solution {
    public int minCut(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2, n);
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                dp2[i] = 0;
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (dp[j + 1][i]) {
                    dp2[i] = Math.min(dp2[i], dp2[j] + 1);
                }
            }
        }
        return dp2[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("aaa"));
    }
}
