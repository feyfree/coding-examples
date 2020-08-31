package com.feyfree.leetcode.p37;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    /**
     * rows[i][j] 表示 第 i 行 数字 j 的使用情况, true 表示已经使用  false 表示未使用
     */
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // 对已经填充的位置进行 标记
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    int n = cur - '1';
                    int bx = j / 3;
                    int by = i / 3;
                    rows[i][n] = true;
                    cols[j][n] = true;
                    boxes[by * 3 + bx][n] = true;
                }
            }
        }
        fill(board, 0, 0);
    }

    /**
     * 搜索填充
     *
     * @param board 给定数组
     * @param x     搜索起点 x
     * @param y     搜索起点 y
     * @return 是否结束
     */
    private boolean fill(char[][] board, int x, int y) {
        // 终止条件 到了第十行
        if (y == 9) {
            return true;
        }
        // 下一个点的列号
        int nextX = (x + 1) % 9;
        // 下一个点的行号
        int nextY = (nextX == 0) ? y + 1 : y;
        if (board[y][x] != '.') {
            return fill(board, nextX, nextY);
        }
        for (int i = 0; i < 9; i++) {
            int bx = x / 3;
            int by = y / 3;
            // 计算所在的九宫格序列号
            int boxNo = by * 3 + bx;
            if (!rows[y][i] && !cols[x][i] && !boxes[boxNo][i]) {
                rows[y][i] = true;
                cols[x][i] = true;
                boxes[boxNo][i] = true;
                board[y][x] = (char) (i + '1');
                if (fill(board, nextX, nextY)) {
                    return true;
                }
                board[y][x] = '.';
                boxes[boxNo][i] = false;
                cols[x][i] = false;
                rows[y][i] = false;
            }
        }
        return false;
    }
}
