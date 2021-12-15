package com.feyfree.leetcode.p0391;

/**
 * 391. 完美矩形
 * https://leetcode-cn.com/problems/perfect-rectangle/
 * <p>
 * 暴力法 会超时
 * 1. 循环
 *
 * @author leilei
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int total = 0;
        int left = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (!separated(rectangles[i], rectangles[j])) {
                    return false;
                }
            }
            total += computeArea(rectangles[i]);
            left = Math.min(left, rectangles[i][0]);
            down = Math.min(down, rectangles[i][1]);
            right = Math.max(right, rectangles[i][2]);
            up = Math.max(up, rectangles[i][3]);
        }
        return total == computeArea(new int[]{left, down, right, up});
    }


    private boolean separated(int[] a, int[] b) {
        return b[0] >= a[2] || b[1] >= a[3] || b[3] <= a[1] || b[2] <= a[0];
    }

    private int computeArea(int[] a) {
        return Math.abs((a[2] - a[0]) * (a[3] - a[1]));

    }
}
