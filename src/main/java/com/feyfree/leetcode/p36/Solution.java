package com.feyfree.leetcode.p36;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    private static final int LENGTH = 9;

    public boolean isValidSudoku(char[][] board) {
        // marked 数组  index 从 0 - 8 true or false 表示 是否被占用(位图思想)
        boolean[][] rows = new boolean[LENGTH][LENGTH];
        boolean[][] cols = new boolean[LENGTH][LENGTH];
        boolean[][] boxes = new boolean[LENGTH][LENGTH];

        for (int r = 0; r < LENGTH; ++r) {
            for (int c = 0; c < LENGTH; ++c) {
                if (board[r][c] != '.') {
                    // 与'1' 相减计算 index
                    int value = board[r][c] - '1';
                    // 计算是第几个九宫格
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
                        return false;
                    }
                    rows[r][value] = true;
                    cols[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
