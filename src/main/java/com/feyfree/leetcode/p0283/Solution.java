package com.feyfree.leetcode.p0283;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 283. 移动零
 *
 * @author leilei
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, a = 0, b = 0;
        while (b < n) {
            if (nums[b] != 0) {
                swap(nums, a, b);
                a++;
            }
            b++;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
