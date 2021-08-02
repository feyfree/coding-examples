package com.feyfree.leetcode.p0201;

/**
 * 最右边的位清除
 * number & (number -1)
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            // 抹去最右边的 1
            right = right & (right - 1);
        }
        return right;
    }
}
