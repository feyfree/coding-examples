package com.feyfree.leetcode.p0326;

/**
 * @author leilei
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 2) {
            return false;
        }
        return isPowerOfThree(n % 3);
    }
}
