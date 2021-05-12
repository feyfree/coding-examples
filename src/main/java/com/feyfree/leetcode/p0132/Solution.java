package com.feyfree.leetcode.p0132;

import java.util.ArrayList;
import java.util.List;

/**
 * 132. 分割回文串 II
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 思路: 动态规划 + 贪心算法
 *
 * @author leilei
 */
public class Solution {
    public int minCut(String s) {
        if (s.isEmpty()) {
            return 0;
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
        List<Integer> jumps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int step = 0;
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j]) {
                    step = j - i;
                }
            }
            jumps.add(step);
        }
        System.out.println(jumps);
        // 需要跳跃的次数
        int steps = 0;
        // near 上一个点能达到的最远的距离
        int near = 0;
        // far 表示在 点i 通过一个step 能到达的最远距离
        int far = 0;
        for (int i = 0; i < jumps.size(); i++) {
            if (i > near) {
                // 之前能达到的最远距离
                near = far;
                if (near >= jumps.size() - 1) {
                    return steps;
                }
                ++steps;
            }
            // 在该点 next step 最远的距离
            far = Math.max(far, i + jumps.get(i));
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("abac"));
    }
}
