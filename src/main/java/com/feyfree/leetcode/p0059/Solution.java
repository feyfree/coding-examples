package com.feyfree.leetcode.p0059;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author leilei
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int total = n * n;
        // 当前赋值
        int current = 1;
        // 操作次数
        int times = 0;
        --n;
        // 标明是哪个维度的
        int d = 0;
        // 起点 x
        int x = 0;
        // 起点 y
        int y = 0;

        // left
        int l = 0;
        // top
        int t = 0;
        // right
        int r = n;
        // bottom
        int b = n;

        while (times < total) {
            times += 1;
            // 将current 放进指定 的 x, y 中
            // 计算x, y
            if (d == 0) {
                while (x < r) {
                    result[y][x++] = current;
                    current += 1;
                }
                ++t;
            } else if (d == 1) {
                while (y < b) {
                    result[y++][x] = current;
                    current += 1;
                }
                --r;
            } else if (d == 2) {
                while (x > l) {
                    result[y][x--] = current;
                    current += 1;
                }
                --b;
            } else {
                while (y > t) {
                    result[y--][x] = current;
                    current += 1;
                }
                ++l;
            }
            d = (d + 1) % 4;
        }
        result[y][x] = total;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(3);
        System.out.println(Arrays.deepToString(result));
    }
}
