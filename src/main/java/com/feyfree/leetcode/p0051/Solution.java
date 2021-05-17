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

    /**
     * 棋盘
     */
    private char[][] board;

    /**
     * column 列
     */
    private boolean[] cols;

    /**
     * 对角线
     */
    private boolean[] diag1;

    /**
     * 对角线
     */
    private boolean[] diag2;

    /**
     * 返回结果
     */
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        result.clear();
        cols = new boolean[n];
        board = new char[n][n];
        // 初始化棋盘
        for (char[] data : board) {
            Arrays.fill(data, '.');
        }

        // 初始化对角线数组  true 表示对角线已经被占用 false 表示为被使用
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        nQueens(n, 0);
        return result;
    }

    /**
     * 在 (x, y) 点是否能放置一个皇后
     *
     * @param x column 列
     * @param y row 行
     * @param n 皇后数量
     * @return true 能放置 false 不能放置
     */
    private boolean available(int x, int y, int n) {
        return !cols[x] && !diag1[x + y] && !diag2[x - y + n - 1];
    }

    /**
     * 更新棋盘
     *
     * @param x     column 列
     * @param y     row 行
     * @param n     皇后数量
     * @param isPut true 放 false 不放
     */
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
        // 搜索实际上只需要从 上往下
        for (int x = 0; x < n; x++) {
            if (!available(x, y, n)) {
                continue;
            }
            updateBoard(x, y, n, true);
            nQueens(n, y + 1);
            updateBoard(x, y, n, false);
        }
    }

    /**
     * 构造结果响应
     *
     * @return 响应
     */
    private List<String> getBoardData() {
        List<String> data = new ArrayList<>();
        for (char[] chars : board) {
            data.add(String.valueOf(chars));
        }
        return data;
    }
}
