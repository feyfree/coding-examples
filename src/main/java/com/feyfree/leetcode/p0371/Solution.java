package com.feyfree.leetcode.p0371;

/**
 * 计算两数之和
 *
 * @author leilei
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位结果
            int carry = (a & b) << 1;
            // 无进位加法结果
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
