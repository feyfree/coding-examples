package com.feyfree.leetcode.p0169;

import java.util.Arrays;

/**
 * 位思想
 *
 * @author leilei
 */
public class BitSolution {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        int majority = 0;
        for (int i = 0; i < 32; ++i) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    ++count;
                }
            }
            if (count > size / 2) {
                majority |= mask;
            }
        }
        return majority;
    }
}
