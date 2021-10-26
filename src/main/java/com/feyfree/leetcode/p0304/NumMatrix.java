package com.feyfree.leetcode.p0304;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * @author leilei
 */
public class NumMatrix {

    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        this.sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j > 0) {
                    sums[i][j] = sums[i][j - 1] + matrix[i][j];
                } else {
                    sums[i][j] = matrix[i][j];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ax = Math.min(row1, row2);
        int ay = Math.min(col1, col2);

        int bx = ax;
        int by = Math.max(col1, col2);

        int cx = Math.max(row1, row2);
        int cy = Math.min(col1, col2);

        int dx = cx;
        int dy = Math.max(col1, col2);

        return sums[dx][dy] + sums[ax][ay] - sums[bx][by] - sums[cx][cy];
    }
}
