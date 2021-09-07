package com.feyfree.leetcode.p0223;

/**
 * https://leetcode-cn.com/problems/rectangle-area/
 * 223. 矩形面积
 *
 * @author leilei
 */
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = Math.abs((ax1 - ax2) * (ay1 - ay2)) + Math.abs((by1 - by2) * (bx1 - bx2));
        if (ax2 <= bx1 || by2 <= ay1 || ay2 <= by1 || bx2 <= ax1) {
            return total;
        }
        return total - Math.abs((Math.min(ax2, bx2) - Math.max(bx1, ax1)) * (Math.min(ay2, by2) - Math.max(ay1, by1)));
    }
}