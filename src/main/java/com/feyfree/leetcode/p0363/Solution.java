package com.feyfree.leetcode.p0363;

import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * 363. 矩形区域不超过 K 的最大数值和
 * <p>
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * @author leilei
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int rows = matrix.length, cols = matrix[0].length;
        // 枚举上边界
        for (int i = 0; i < rows; ++i) {
            int[] sum = new int[cols];
            // 枚举下边界
            for (int j = i; j < rows; ++j) {
                for (int c = 0; c < cols; ++c) {
                    // 更新每列的元素和
                    sum[c] += matrix[j][c];
                }
                // 这地方优化点 -> 实际上只找到不超过k的最大连续子序列和
                // 实际上可以转化为一道dp题目
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    // 这地方为什么是 ceiling(s - k)
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
}


