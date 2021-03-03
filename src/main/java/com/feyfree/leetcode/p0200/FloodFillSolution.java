package com.feyfree.leetcode.p0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 染色问题解决
 *
 * @author leilei
 */
public class FloodFillSolution {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    /**
     * 使用染色问题解决
     *
     * @param grid 输入
     * @return 返回岛屿数目
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        // 申请一个mark标二维数组
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result += floodFillDfs(i, j, visited, grid);
            }
        }
        return result;
    }

    private int floodFillDfs(int x, int y, boolean[][] visited, char[][] grid) {
        if (!isValid(x, y, visited, grid)) {
            return 0;
        }
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            // 同理 如果使用BFS 的话 使用注释中的代码
            floodFillDfs(x + dx[i], y + dy[i], visited, grid);
        }
        return 1;
    }

    // 使用bfs 解法
//    static class Coordination {
//        int x;
//        int y;
//
//        public int getX() {
//            return x;
//        }
//
//        public void setX(int x) {
//            this.x = x;
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public void setY(int y) {
//            this.y = y;
//        }
//
//        public Coordination(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    private int floodFillBfs(int x, int y, boolean[][] visited, char[][] grid) {
//        if (!isValid(x, y, visited, grid)) {
//            return 0;
//        }
//        visited[x][y] = true;
//        Queue<Coordination> queue = new LinkedList<>();
//        queue.add(new Coordination(x, y));
//        while (!queue.isEmpty()) {
//            Coordination poll = queue.poll();
//            for (int i = 0; i < dx.length; i++) {
//                int x2 = poll.getX() + dx[i];
//                int y2 = poll.getY() + dy[i];
//                if (isValid(x, y, visited, grid)) {
//                    visited[x][y] = true;
//                    queue.add(new Coordination(x2, y2));
//                }
//            }
//        }
//        return 1;
//    }

    private boolean isValid(int x, int y, boolean[][] visited, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return grid[x][y] != '0' && !visited[x][y];
    }
}
