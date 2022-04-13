package com.feyfree.leetcode.p0474;

/**
 * 进阶解法，滚动数组, 可以减少一个纬度
 *
 * @author leilei
 */
public class SimplifiedSolution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] zerosOnes = calculateString(str);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            // 内层循环需采用倒序遍历的方式，这种方式保证转移来的是 dp[i−1][][] 中的元素值
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }


    private int[] calculateString(String s) {
        int[] result = new int[2];
        for (char i : s.toCharArray()) {
            result[i - '0']++;
        }
        return result;
    }
}
