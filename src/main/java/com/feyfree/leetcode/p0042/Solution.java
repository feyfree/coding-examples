package com.feyfree.leetcode.p0042;


/**
 * leetcode 42
 * 接雨水
 *
 * @author leilei
 */
class Solution {
    public int trap(int[] height) {
        // 动态规划
        int n = height.length;
        // 0 - i
        int[] pre = new int[n];
        // i to n - 1
        int[] after = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = i == 0 ? height[i] : Math.max(pre[i - 1], height[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            after[i] = i == n - 1 ? height[i] : Math.max(after[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += (Math.min(pre[i], after[i]) - height[i]);
        }
        return ans;
    }
}