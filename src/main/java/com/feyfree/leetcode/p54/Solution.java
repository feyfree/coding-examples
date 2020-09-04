package com.feyfree.leetcode.p54;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode  54:螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        if (n == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(m * n);
        // 遍历循环
        for (int x = 0; x <= m / 2; x++) {
            for (int i = x; i <= n - 1 - x; i++) {
                if (i < n - 1 - x || (x == n - 1 - x)) {
                    result.add(matrix[x][i]);
                }
            }
            for (int j = x; j < m - 1 - x; j++) {
                result.add(matrix[j][n - 1 - x]);
            }
            for (int i = n - 1 - x; i > x; i--) {
                result.add(matrix[m - 1 - x][i]);
            }
            for (int j = m - 1 - x; j > x; j--) {
                result.add(matrix[j][x]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
