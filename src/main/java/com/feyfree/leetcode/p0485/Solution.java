package com.feyfree.leetcode.p0485;

/**
 * 485. 最大连续 1 的个数
 *
 * @author leilei
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int accumulator = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                accumulator++;
                max = Math.max(max, accumulator);
            } else {
                accumulator = 0;
            }
        }
        return max;
    }
}
