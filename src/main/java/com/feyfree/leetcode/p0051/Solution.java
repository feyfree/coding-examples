package com.feyfree.leetcode.p0051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51: N 皇后问题
 *
 * @author leilei
 */
public class Solution {

    private char[][] board;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        result.clear();
        cols = new boolean[n];
        board = new char[n][n];
        for (char[] data : board) {
            Arrays.fill(data, '.');
        }
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
        board[y][x] = isPut ? 'Q' : '.';
    }

    private void nQueens(int n, int y) {
        if (y == n) {
            result.add(getBoardData());
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

    private List<String> getBoardData() {
        List<String> data = new ArrayList<>();
        for (char[] chars : board) {
            data.add(String.valueOf(chars));
        }
        return data;
    }
}
