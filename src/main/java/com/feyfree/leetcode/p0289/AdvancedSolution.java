package com.feyfree.leetcode.p0289;

/**
 * 原地更新
 *
 * @author leilei
 */
public class AdvancedSolution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                for (int y = Math.max(0, i - 1); y < Math.min(m, i + 2); y++) {
                    for (int x = Math.max(0, j - 1); x < Math.min(n, j + 2); x++) {
                        lives += board[y][x] & 1;
                    }
                }
                if (lives == 3 || lives - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
