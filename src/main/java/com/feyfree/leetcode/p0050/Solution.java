package com.feyfree.leetcode.p0050;


/**
 * https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 *
 * @author leilei
 */
public class Solution {

    public double myPow(double x, int n) {
        return n >= 0 ? myPowImpl(x, n) : 1.0 / myPowImpl(x, n);
    }

    /**
     * 递归的思想  分治的思想
     *
     * @param x 输入
     * @param n 幂
     * @return 输出
     */
    private double myPowImpl(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return myPowImpl(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, 10));
    }


}
