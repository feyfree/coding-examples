package com.feyfree.leetcode.p0326;

/**
 * @author leilei
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        }
        return false;
    }
}
