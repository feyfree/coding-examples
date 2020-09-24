package com.feyfree.leetcode.p44;

import java.util.Arrays;

/**
 * p44 通配符匹配
 * <p>
 * 通配符表示任意搭配
 * 区别与正则匹配
 *
 * @author leilei
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = firstMatch;
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        Solution solution = new Solution();
        System.out.println(solution.isMatch(s, p));
    }
}
