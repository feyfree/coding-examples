package com.feyfree.leetcode.p0547;

/**
 * 547
 *
 * @author leilei
 */
public class Solution {

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    /**
     * dfs 搜索路径需要调整
     * 因为是对角线问题 需要一个跳跃 M[i][j] == 1 的话， 需要跳到 j 行进行搜索
     * 比如用户 A B C D
     * M[A][B] == 1 则需要到B 的 acquaintance 里面进行搜索
     *
     * @param M       输入
     * @param visited 访问标记
     * @param i       需要访问的用户
     */
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
