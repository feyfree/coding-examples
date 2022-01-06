package com.feyfree.leetcode.p0335;

/**
 * https://leetcode-cn.com/problems/self-crossing/
 * <p>
 * 335. 路径交叉
 * 画图法
 *
 * @author leilei
 */
class Solution {
    public boolean isSelfCrossing(int[] d) {
        int n = d.length;
        if (n < 4) {
            return false;
        }
        for (int i = 3; i < n; i++) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
                return true;
            }
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) {
                return true;
            }
            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i] + d[i - 4] >= d[i - 2] && d[i - 1] + d[i - 5] >= d[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
