package com.feyfree.leetcode.p10;

/**
 * 动态规划解法
 * <p>
 * 参考
 * https://qoogle.top/xiaoxu-explaination-leetcode-10-regular-expression-matching/
 *
 * @author leilei
 */
public class DPSolution {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = (firstMatch && (dp[i + 1][j] || dp[i][j + 2])) || (!firstMatch && (dp[i][j + 2]));
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
