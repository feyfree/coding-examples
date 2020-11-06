package com.feyfree.leetcode.p231;

/**
 * 是否是2 的整数 次幂
 *
 * @author leilei
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            return (n & n - 1) == 0;
        }
        return false;
    }
}
