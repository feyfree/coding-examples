package com.feyfree.leetcode.p0062;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    private int total;

    public int uniquePaths(int m, int n) {
        // 起点默认为0, 0, 使用dfs 搜索 x = m, y = n 停止
        m--;
        n--;
        dfs(m, n, 0, 0);
        return total;
    }

    /**
     * 这种dfs 会超时, 更好的解答 看 ModifiedSolution
     *
     * @param m
     * @param n
     * @param x
     * @param y
     */
    private void dfs(int m, int n, int x, int y) {
        if (x == m && y == n) {
            total += 1;
            return;
        }
        if (x < m && y < n) {
            dfs(m, n, x + 1, y);
            dfs(m, n, x, y + 1);
        }
        if (x == m && y < n) {
            dfs(m, n, m, y + 1);
        }
        if (y == n && x < m) {
            dfs(m, n, x + 1, n);
        }
    }
}
