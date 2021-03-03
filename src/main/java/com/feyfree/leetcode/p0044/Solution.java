package com.feyfree.leetcode.p0044;

/**
 * p44 通配符匹配
 * <p>
 * 通配符表示任意搭配
 * 区别与正则匹配
 * <p>
 * 参考
 * http://wulc.me/2016/10/23/LeetCode%E8%A7%A3%E9%A2%98%E6%8A%A5%E5%91%8A(10,%2044)--%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F%E7%9A%84%E5%8C%B9%E9%85%8D%E4%B8%8E%E9%80%9A%E9%85%8D%E7%AC%A6%E7%9A%84%E5%8C%B9%E9%85%8D/
 *
 * @author leilei
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length() + 1, n = s.length() + 1;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = j == 0;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (p.charAt(i - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = (s.charAt(j - 1) == p.charAt(i - 1)) && dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
