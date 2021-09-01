package com.feyfree.leetcode.p0217;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 217. 存在重复元素
 *
 * @author leilei
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int a;
        int b = nums[1];
        for (int item : nums) {
            a = item;
            if (a == b) {
                return true;
            } else {
                b = item;
            }
        }
        return false;
    }
}
