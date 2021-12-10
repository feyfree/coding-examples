package com.feyfree.leetcode.p0375;

import java.util.Arrays;

/**
 * huahua 解法
 *
 * @author leilei
 */
public class SimpleSolution {
    public int getMoneyAmount(int n) {
        int[][] cache = new int[n + 2][n + 2];
        for (int[] item : cache) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        return dp(1, n, cache);
    }


    private int dp(int l, int r, int[][] cache) {
        if (l >= r) {
            return 0;
        }
        if (cache[l][r] != Integer.MAX_VALUE) {
            return cache[l][r];
        }
        for (int i = l; i <= r; i++) {
            cache[l][r] = Math.min(cache[l][r], i + Math.max(dp(l, i - 1, cache), dp(i + 1, r, cache)));
        }
        return cache[l][r];
    }
}