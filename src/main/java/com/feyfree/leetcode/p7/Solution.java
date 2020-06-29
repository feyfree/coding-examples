package com.feyfree.leetcode.p7;

/**
 * reverse-integer
 * 整数反转
 * <p>
 * java 类
 * Integer.MAX_VALUE
 * Integer.MIN_VALUE
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 * <p>
 * Java中整除符号"/"返回的是“商”，Python中整除符号"/"返回的是不大于真实结果的最大整数
 *
 * @author Leilei
 */

public class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 相当于知道 max-value 的 十进制的 2147483647  最低位为 7
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // 相当于知道 min-value 的十进制的 2147483648 最低位为 8
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}