package com.feyfree.leetcode.p120;

import java.util.ArrayList;
import java.util.List;

/**
 * 120
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 *
 * @author leilei
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 计算三角形的行数
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // dp[i][j] = min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j]
        // 初始化
        if (n == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(3);
        data.add(first);
        data.add(second);
        List<Integer> third = new ArrayList<>();
        third.add(4);
        third.add(5);
        third.add(6);
        data.add(third);

        Solution solution = new Solution();
        int result = solution.minimumTotal(data);
        System.out.println(result);
    }
}
