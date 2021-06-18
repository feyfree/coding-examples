package com.feyfree.leetcode.p0169;

/**
 * boyer-moore voting solution
 *
 * @author leilei
 */
public class BoyerMooreVoteSolution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int num : nums) {
            if (num == majority) {
                ++count;
            } else if (--count == 0) {
                count = 1;
                majority = num;
            }
        }
        return majority;
    }
}
