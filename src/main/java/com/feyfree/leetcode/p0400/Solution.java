package com.feyfree.leetcode.p0400;

/**
 * https://leetcode-cn.com/problems/nth-digit/
 * 400. 第 N 位数字
 *
 * @author leilei
 */
class Solution {
    public int findNthDigit(int n) {
        int pre = 0;
        int current = 0;
        int i = 1;
        if (n <= 9) {
            return n;
        }
        while (current < n) {
            pre = current;
            current += 9 * Math.pow(10, i - 1) * i;
            i++;
        }
        if (current > n || current == Integer.MAX_VALUE) {
            int diff = n - pre;
            int step = i - 1;
            int distance = diff / step;
            int mod = diff % step;
            if (mod == 0) {
                //
                return (distance - 1) % 10;
            } else {
                int val = (int) Math.pow(10, i - 2) + distance;
                return Integer.parseInt(String.valueOf(val).substring(mod - 1, mod));
            }
        } else {
            return 9;
        }
    }
}