package com.feyfree.leetcode.p0115;

import java.util.Arrays;

/**
 * 115. 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 *
 * @author leilei
 */
class Solution {
    /**
     * @param s 字符串
     * @param t 目标字符串
     * @return 存在的数量
     */
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        int[][] dp = new int[lt + 1][ls + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= lt; i++) {
            for (int j = 1; j <= ls; ++j) {
                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[lt][ls];
    }
}
