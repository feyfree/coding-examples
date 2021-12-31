package com.feyfree.leetcode.p0334;

/**
 * 最精简的代码
 *
 * @author leilei
 */
public class TidySolution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > b) {
                return true;
            }
            if (num < a) {
                a = num;
            }
            if (num > a) {
                b = num;
            }
        }
        return false;
    }
}
