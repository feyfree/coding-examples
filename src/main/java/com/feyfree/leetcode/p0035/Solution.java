package com.feyfree.leetcode.p0035;

/**
 * search-insert-position
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @author leilei
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return floor(nums, target);
    }

    private int floor(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
                if (low < nums.length && nums[low] > target) {
                    return low;
                }
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(solution.searchInsert(nums, target));
    }
}
