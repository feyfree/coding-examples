package com.feyfree.leetcode.p0080;

/**
 * p80 删除数组中的重复项II
 * 是 p26 的变种
 *
 * @author feyfree
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else {
            int i = 0;
            int repeat = 2;
            int currentRepeat = 1;
            for (int j = 1; j < length; j++) {
                if (nums[j] == nums[i] && currentRepeat < repeat) {
                    nums[++i] = nums[j];
                    currentRepeat += 1;
                } else if (nums[j] != nums[i]) {
                    if (currentRepeat >= repeat) {
                        currentRepeat = 1;
                    }
                    nums[++i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
