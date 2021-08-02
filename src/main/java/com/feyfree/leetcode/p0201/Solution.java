package com.feyfree.leetcode.p0201;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 201. 数字范围按位与
 * TIPS: 公共前缀
 *
 * @author leilei
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
