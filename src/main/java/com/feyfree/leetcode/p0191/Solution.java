package com.feyfree.leetcode.p0191;

/**
 * leetcode 191
 * <p>
 * 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * you need to treat n as an unsigned value
 *
 * @author leilei
 */
class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        // while 写法
        while (n != 0) {
            count++;
            // 实际上是移除了最后一个为 1 的位
            n = n & (n - 1);
        }
        return count;
    }
}