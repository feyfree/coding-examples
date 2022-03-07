package com.feyfree.leetcode.p0498;

import java.util.Arrays;

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
                if (row == minRow || col == cols - 1) {
                    if (col + 1 < cols) {
                        col = col + 1;
                    } else {
                        row = row + 1;
                        minRow = minRow + 1;
                    }
                    dir = 0;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (col == minCol || row == rows - 1) {
                    if (row + 1 < rows) {
                        row = row + 1;
                    } else {
                        col = col + 1;
                        minCol = minCol + 1;
                    }
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        Solution s = new Solution();
        int[] result = s.findDiagonalOrder(data);
        System.out.println(Arrays.toString(result));
    }
}