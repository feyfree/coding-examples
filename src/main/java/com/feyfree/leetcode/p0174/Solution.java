package com.feyfree.leetcode.p0174;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * @author leilei
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] item : dp) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int y = m - 1; y >= 0; --y) {
            for (int x = n - 1; x >= 0; --x) {
                dp[y][x] = Math.max(1, Math.min(dp[y + 1][x], dp[y][x + 1]) - dungeon[y][x]);
            }
        }
        return dp[0][0];
    }
}
