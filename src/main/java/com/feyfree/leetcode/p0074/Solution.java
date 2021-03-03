package com.feyfree.leetcode.p0074;

/**
 * 74 题
 * 二维数组 做 一维数组进行二分
 *
 * @author leilei
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = getValue(n, mid, matrix);
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private int getValue(int n, int index, int[][] matrix) {
        int row = index / n;
        int col = index % n;
        return matrix[row][col];
    }

    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7};
        int[] b = {10, 11, 16, 20};
        int[] c = {23, 30, 34, 60};

        int[][] matrix = new int[3][4];
        matrix[0] = a;
        matrix[1] = b;
        matrix[2] = c;
        Solution solution = new Solution();
        boolean b1 = solution.searchMatrix(matrix, 13);
        System.out.println(b1);
    }
}
