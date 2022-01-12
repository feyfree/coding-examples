package com.feyfree.leetcode.p0413;

/**
 * https://leetcode-cn.com/problems/arithmetic-slices/
 *
 * @author leilei
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0;
        int current = 0;
        // current 实际上是以 i 结尾的等差数列数量  (题目要求连续)
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                current++;
                sum += current;
            } else {
                current = 0;
            }
        }
        return sum;
    }
}
