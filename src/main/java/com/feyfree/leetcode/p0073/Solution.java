package com.feyfree.leetcode.p0073;

/**
 * 73 solution
 * 思路: 利用第一行 和 第一列作为 参照
 * 第一次循环 确定第一行 第一列 最后是否需要全部清零
 * 第二次循环 m x n 更新第一行第一列的 零值
 * 第三次循环 m x n 通过上一次循环的 第一行和第一列的零值 修改对应的 matrix[i][j] 是否需要清零
 * 第四次循环 根据第一次循环 的标志位 判断是否需要修改第一行和第一列的全部清零
 *
 * @author leilei
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = false;
        boolean row = false;
        for (int i = 0; i < m; i++) {
            col |= matrix[i][0] == 0;
        }
        for (int j = 0; j < n; j++) {
            row |= matrix[0][j] == 0;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
