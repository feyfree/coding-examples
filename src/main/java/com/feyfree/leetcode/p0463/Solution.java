package com.feyfree.leetcode.p0463;

/**
 * https://leetcode.cn/problems/island-perimeter/
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * <p>
 * 思路： 分析每个点的四周， 如果有相邻的， 把相邻的边去掉
 *
 * @author leilei
 */
public class Solution {

    /**
     * 用来for循环上下左右点的
     */
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    int c = 0;
                    for (int d = 0; d < dx.length; d++) {
                        // 相邻点
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        // 越界
                        boolean outOfBound = (nx >= grid.length || nx < 0) || (ny >= grid[i].length || ny < 0);
                        if (outOfBound) {
                            c++;
                        } else if (grid[nx][ny] == 0) {
                            c++;
                        }
                    }
                    total += c;
                }
            }
        }
        return total;
    }
}