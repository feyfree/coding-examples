package com.feyfree.leetcode.p0052;

/**
 * 52. N 皇后 ii
 *
 * @author leilei
 */
public class Solution {

    /**
     * 每一行
     */
    private boolean[] cols;
    /**
     * 对角线 1
     */
    private boolean[] diag1;
    /**
     * 对角线 2
     */
    private boolean[] diag2;
    private int result = 0;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        nQueens(n, 0);
        return result;
    }


    private boolean available(int x, int y, int n) {
        return !cols[x] && !diag1[x + y] && !diag2[x - y + n - 1];
    }

    private void updateBoard(int x, int y, int n, boolean isPut) {
        cols[x] = isPut;
        diag1[x + y] = isPut;
        diag2[x - y + n - 1] = isPut;
    }

    private void nQueens(int n, int y) {
        if (y == n) {
            result++;
            return;
        }
        for (int x = 0; x < n; x++) {
            if (!available(x, y, n)) {
                continue;
            }
            updateBoard(x, y, n, true);
            nQueens(n, y + 1);
            updateBoard(x, y, n, false);
        }
    }
}
