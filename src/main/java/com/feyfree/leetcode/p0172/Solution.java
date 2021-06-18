package com.feyfree.leetcode.p0172;

/**
 * 172. 阶乘后的零
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 *
 * @author leilei
 */
public class Solution {

    public int trailingZeroes(int n) {
        return n < 5 ? 0 : (n / 5 + trailingZeroes(n / 5));
    }
}
