package com.feyfree.leetcode.p91;

/**
 * p91 solution
 * <p>
 * 本质上是单词树
 *
 * @author leilei
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        dfs(s.length(), -1, s, result, 1);
        dfs(s.length(), -1, s, result, 2);
        return result;
    }

    private void dfs(int n, int k, String s, int result, int step) {
        if (k > n) {
            result += 1;
            return;
        }
        if (step == 1 || (k + 2 > n - 1)) {
            if (s.charAt(k) == '0' || s.charAt(k) - '2' > 0) {
                return;
            }
            dfs(n, k + 1, s, result, 1);
            dfs(n, k + 2, s, result, 2);
        } else {
            if (s.charAt(k) == '0' || s.charAt(k) - '2' > 0) {
                return;
            }
            String current = s.substring(k, k + 2);
            if (Integer.parseInt(current) - 26 > 0) {
                return;
            }
            dfs(n, k + 1, s, result, 1);
            dfs(n, k + 2, s, result, 2);
        }

    }
}
