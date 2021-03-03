package com.feyfree.leetcode.p0029;

/**
 * 29.两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        // 商的符号标志 如果是true 表示 商为负数
        boolean flag = dividend < 0 ^ divisor < 0;
        // 转化为long 防止运算溢出
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        long res = 0;
        // 当被除数 大于等于除数的时候
        while (lDividend >= lDivisor) {
            for (int i = 0; (lDivisor << i) <= lDividend; ++i) {
                lDividend -= (lDivisor << i);
                res += (1 << i);
            }
        }
        if (flag) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        a.divide(7, -3);
    }
}
