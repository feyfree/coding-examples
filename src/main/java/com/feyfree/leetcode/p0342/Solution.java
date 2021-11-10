package com.feyfree.leetcode.p0342;

/**
 * @author leilei
 */

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n > 0) {
            return (n & n - 1) == 0 && (n % 3) == 1;
        }
        return false;
    }
}
