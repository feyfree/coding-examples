package com.feyfree.leetcode.p0473;


import java.util.Arrays;

/**
 * DP 解法
 *
 * @author leilei
 */
class AdvancedSolution {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        // s 是一个位向量，
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                // 说明在s场景下，第k个没被用到
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                // 当前场景是 s, 找到 s场景下， 对应的 k, 通过位运算找到移除 第 k 位， 之前的场景， 比如 s1, s2,
                // 分别在这些场景下计算 加上了这个 k 位对应的值， 如果是小于 len的话， 则为 0， 否则就是取 len (这就是这地方 mod len的意义)
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public static void main(String[] args) {
        System.out.println(2 & 1);
    }
}
