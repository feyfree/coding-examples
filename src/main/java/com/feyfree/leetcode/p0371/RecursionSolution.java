package com.feyfree.leetcode.p0371;

/**
 * 递归解法
 *
 * @author leilei
 */
public class RecursionSolution {

    public int getSum(int a, int b) {
        // 实际上我们是知道 f(a, b) = a + b; 这个函数
        // 所以需要找到 f(c, d) = c + d, 然后如果d 收敛于 0 的时候, 实际上返回c就行
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(1 << 1);
    }
}
