package com.feyfree.leetcode.p69;

/**
 * 牛顿迭代法
 *
 * @author leilei
 */
public class NewtonSolution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long r = x;
        while (r > x / r) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
