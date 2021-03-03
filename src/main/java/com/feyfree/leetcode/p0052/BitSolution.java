package com.feyfree.leetcode.p0052;

/**
 * 位运算解法
 *
 * @author leilei
 */
public class BitSolution {

    private int count;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    /**
     * dfs
     *
     * @param n    行数
     * @param row  层数  递归深度
     * @param cols 所在的列情况
     * @param pie  所在的左斜边 情况
     * @param na   所在的右斜边 情况
     */
    public void dfs(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            count += 1;
            return;
        }
        // 得到空位
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            // 得到一个空位
            int p = bits & -bits;
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1);
        }
    }
}
