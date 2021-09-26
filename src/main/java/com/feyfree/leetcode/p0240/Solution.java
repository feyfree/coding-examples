package com.feyfree.leetcode.p0240;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 240. 搜索二维矩阵 II
 *
 * @author leilei
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                --c;
            } else {
                ++r;
            }
        }
        return false;
    }
}
