package com.feyfree.leetcode.p0498;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * @author leilei
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];

        int row = 0;
        int col = 0;
        int minRow = 0;
        int minCol = 0;
        // 初始是 up
        int dir = 1;
        int count = 0;
        while (count < rows * cols) {
            result[count] = mat[row][col];
            count++;
            if (dir == 1) {
                if (row == minRow) {
                    if (col + 1 < cols) {
                        col = col + 1;
                    } else {
                        row = minRow + 1;
                        col = cols - 1;
                        dir = 0;
                        minRow = minRow + 1;
                    }
                } else {
                    row--;
                    col++;
                }
            } else {
                if (col == minCol) {
                    if (row + 1 < rows) {
                        row = row + 1;
                    } else {
                        col = minCol + 1;
                        row = rows - 1;
                        minCol = minCol + 1;
                        dir = 1;
                    }
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}