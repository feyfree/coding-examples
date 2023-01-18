package com.feyfree.leetcode.p0419;

/**
 * https://leetcode.cn/problems/battleships-in-a-board/
 * 只统计左上角战舰
 *
 * @author leilei
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean flag = board[row][col] == 'X' && (row == 0 || board[row - 1][col] == '.') && (col == 0 || board[row][col - 1] == '.');
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }
}
