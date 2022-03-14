package com.feyfree.leetcode.p0492;

/**
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 *
 * @author leilei
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area) {
            return new int[]{sqrt, sqrt};
        } else {
            while (sqrt >= 1) {
                int mod = area % sqrt;
                if (mod != 0) {
                    sqrt--;
                } else {
                    int other = area / sqrt;
                    return new int[]{other, sqrt};
                }
            }
        }
        return new int[]{area, 1};
    }
}
