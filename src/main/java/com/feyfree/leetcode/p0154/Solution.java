package com.feyfree.leetcode.p0154;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author leilei
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] == nums[high]) {
                boolean increase = increaseSequence(nums, mid, high);
                if (increase) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    /**
     * 是否是递增序列
     *
     * @param nums  数组
     * @param start 起点
     * @param end   终点
     * @return true 递增 false 不是递增
     */
    private boolean increaseSequence(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
