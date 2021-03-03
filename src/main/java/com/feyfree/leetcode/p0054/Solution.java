package com.feyfree.leetcode.p0054;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode  54:螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        if (n == 0) {
            return new ArrayList<>();
        }
        // 总数 注意r实际上是n - 1 , b 实际上是m - 1
        int total = (m--) * (n--);
        // left , top
        int l = 0;
        int t = 0;
        int r = n;
        int b = m;
        List<Integer> result = new ArrayList<>(m * n);
        int x = 0, y = 0;
        int d = 0;
        // 遍历循环
        while (result.size() < total - 1) {
            if (d == 0) {
                while (x < r) {
                    result.add(matrix[y][x++]);
                }
                ++t;
            } else if (d == 1) {
                while (y < b) {
                    result.add(matrix[y++][x]);
                }
                --r;
            } else if (d == 2) {
                while (x > l) {
                    result.add(matrix[y][x--]);
                }
                --b;
            } else if (d == 3) {
                while (y > t) {
                    result.add(matrix[y--][x]);
                }
                ++l;
            }
            d = (d + 1) % 4;
        }
        if (result.size() != total) {
            result.add(matrix[y][x]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
