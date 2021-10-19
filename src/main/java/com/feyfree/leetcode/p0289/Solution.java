package com.feyfree.leetcode.p0289;

import java.util.ArrayList;
import java.util.List;

/**
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 * <p>
 * 非原地更新
 *
 * @author leilei
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] updated = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int alive = board[i][j];
                int surround = 0;
                List<int[]> surroundings = surroundings(i, j, m, n);
                for (int[] place : surroundings) {
                    surround += board[place[0]][place[1]];
                }
                if (alive > 0) {
                    if (surround < 2 || surround > 3) {
                        alive = 0;
                    }
                } else {
                    if (surround == 3) {
                        alive = 1;
                    }
                }
                updated[i][j] = alive;
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(updated[i], 0, board[i], 0, n);
        }
    }

    private List<int[]> surroundings(int a, int b, int m, int n) {
        int up = a - 1;
        int down = a + 1;
        int left = b - 1;
        int right = b + 1;
        List<int[]> data = new ArrayList<>(8);
        if (up >= 0) {
            if (b - 1 >= 0) {
                data.add(new int[]{up, b - 1});
            }
            data.add(new int[]{up, b});
            if (b + 1 < n) {
                data.add(new int[]{up, b + 1});
            }
        }
        if (down < m) {
            if (b - 1 >= 0) {
                data.add(new int[]{down, b - 1});
            }
            data.add(new int[]{down, b});
            if (b + 1 < n) {
                data.add(new int[]{down, b + 1});
            }
        }
        if (left >= 0) {
            data.add(new int[]{a, left});
        }
        if (right < n) {
            data.add(new int[]{a, right});
        }
        return data;
    }
}
