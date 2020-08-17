package com.feyfree.leetcode.p34;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author leilei
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }
        return new int[]{firstPosition(nums, target), lastPosition(nums, target)};
    }

    public int firstPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        // 二分搜索
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 如果 中间位置的 大于 target
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // 如果搜索结束 并且 high 没变化 或者 是high 不等于target
        if (high == nums.length || nums[high] != target) {
            return -1;
        }
        return high;
    }

    public int lastPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        // low 表示第一个大于 target 的元素
        --low;
        if (low < 0 || nums[low] != target) {
            return -1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        solution.searchRange(nums, 8);
    }
}