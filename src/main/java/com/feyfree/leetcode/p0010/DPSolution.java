package com.feyfree.leetcode.p0010;

/**
 * 动态规划解法
 * <p>
 * 参考
 * https://qoogle.top/xiaoxu-explaination-leetcode-10-regular-expression-matching/
 *
 * @author leilei
 */
public class DPSolution {

    public boolean isMatch(String s, String p) {
        // 构建线性动态规划二维数组
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始状态实际上是end of string, 思路从后往前推
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                // i, j 的 字面匹配结果
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                // 更新dp[i][j] 状态
                // 如果 j + 1的位置出现 '*' 则dp[i][j] 的判断需要考虑 *代表 0 个还是n个
                // 如果是代表 >=1 个 则 dp[i][j] 需要考虑的一个上状态是dp[i+1][j] 或者是dp[i][j+2] (不是j + 1因为 * 占一个位置)
                // 如果是代表 0 个， 则firstMatch 无用, 且需要考虑的上一个状态是dp[i][j+2] 位置
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = (firstMatch && (dp[i + 1][j] || dp[i][j + 2])) || (!firstMatch && (dp[i][j + 2]));
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
