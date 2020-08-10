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
        return null;
    }

    public int[] findValue(int[] nums, int low, int high, int target) {
        int[] result = {-1, -1};
        while (high >= low) {
            int mid = (high - low) / 2 + low;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target == nums[mid]) {
                if (mid + 1 <= high && nums[mid+1] == target) {
                    result[1] = mid + 1;
                    mid = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
