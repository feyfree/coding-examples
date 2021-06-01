package com.feyfree.leetcode.p0153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author leilei
 */
public class Solution {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return Math.min(nums[0], nums[i]);
            }
        }
        return nums[0];
    }
}
