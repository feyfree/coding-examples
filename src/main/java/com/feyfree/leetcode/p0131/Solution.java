package com.feyfree.leetcode.p0131;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 思路是: 动态规划 + DFS 搜索
 *
 * @author leilei
 * @see com.feyfree.leetcode.p0005.Solution
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()) {
            return new ArrayList<>();
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
        dfs(0, n, dp, s, result, new ArrayList<>());
        return result;
    }


    private void dfs(int x, int n, boolean[][] dp, String s, List<List<String>> result, List<String> current) {
        if (x == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = x; i < n; i++) {
            if (dp[x][i]) {
                current.add(s.substring(x, i + 1));
                dfs(i + 1, n, dp, s, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}