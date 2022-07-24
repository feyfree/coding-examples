package com.feyfree.leetcode.p0473;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 * dfs 解法
 *
 * @author leilei
 */
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverseArray(matchsticks);
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }


    private void reverseArray(int[] data) {
        for (int i = 0, j = data.length - 1; i < j; i++, j--) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
