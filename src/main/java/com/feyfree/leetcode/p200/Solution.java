package com.feyfree.leetcode.p200;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    private int[] dx = {-1, 1, 0, 0};

    private int[] dy = {0, 0, -1, 1};

    /**
     * parent[i] = parent of i
     */
    private int[] parent;

    /**
     * 这道题解法实际上不需要这个rank 数组, 照着alg4 UF 解法来的
     */
    private int[] rank;

    /**
     * 总数
     */
    private int count;

    /**
     * 使用并查集的结构
     *
     * @param grid 输入
     * @return 返回岛屿数目
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        // 初始化数组
        init(grid);
        // 进行并查集合的合并
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                for (int k = 0; k < dx.length; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                        union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 初始化并查询集合
     *
     * @param grid 输入
     */
    private void init(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int index = i * grid[0].length + j;
                if (grid[i][j] == '1') {
                    parent[index] = index;
                    count += 1;
                }
            }
        }
    }


    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }

        // make root of smaller rank point to root of larger rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;
    }
}
