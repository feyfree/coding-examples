package com.feyfree.leetcode.p0378;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 为什么left 最后一定会出现在matrix中
 * 1. 首先 left <= mid <= right
 * 2. 如果total < k, 则left = mid + 1 重新执行check函数 ...
 * 如果left >= right 循环终止
 * left <= 第K小的数 <= right。
 * 假设有一次 check(mid) 正好K个, 但是 mid 不一定是在数组中
 * left [target] mid right
 * left = mid + 1 实际上是不停的去逼近 target
 *
 * @author leilei
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        // row
        int i = n - 1;
        // col
        int j = 0;

        // 统计不大于 mid 的数量
        int total = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                total += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return total >= k;
    }
}
