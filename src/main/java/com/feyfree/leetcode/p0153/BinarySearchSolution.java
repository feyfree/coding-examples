package com.feyfree.leetcode.p0153;

/**
 * 二分查找思路
 *
 * @author leilei
 */
public class BinarySearchSolution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
