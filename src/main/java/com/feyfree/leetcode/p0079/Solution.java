package com.feyfree.leetcode.p0079;

/**
 * 单词搜索
 *
 * @author leilei
 */
class Solution {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private int rows = 0;
    private int cols = 0;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int d, int x, int y) {
        if (x < 0 || x == cols || y < 0 || y == rows || word.charAt(d) != board[y][x]) {
            return false;
        }
        if (d == word.length() - 1) {
            return true;
        }
        char cur = board[y][x];
        board[y][x] = '0';
        boolean found = false;
        for (int i = 0; i < dx.length; i++) {
            found = found || dfs(board, word, d + 1, x + dx[i], y + dy[i]);
        }
        board[y][x] = cur;
        return found;
    }


}