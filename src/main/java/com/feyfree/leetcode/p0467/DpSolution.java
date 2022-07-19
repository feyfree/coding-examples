package com.feyfree.leetcode.p0467;

import java.util.Arrays;

/**
 * 动态规划解法
 * 不会存在遗漏的问题
 * 比如 abc
 * a b c
 * 1 2 3
 * 这个是对应dp中的值, 因为是连续的话, k 是不会中断的
 * 所以累计求和相当于是拿到了所有的组合数
 *
 * @author leilei
 */
class DpSolution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            // 字符之差为 1 或 -25
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            int index = p.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], k);
        }
        return Arrays.stream(dp).sum();
    }
}

