package com.feyfree.leetcode.p0001;

import java.util.Arrays;

/**
 * ch-01 add-two-sum
 *
 *
 * @author leilei
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int otherValue = target - nums[i];
            int minOtherIndex = -1;
            for (int j = nums.length - 1; j > i; j--) {
                if (otherValue == nums[j]) {
                    minOtherIndex = j;
                }
            }
            if (minOtherIndex > 0) {
                return new int[]{i, minOtherIndex};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] testNums = {1, 2, 3, 4, 4};
        int target = 6;
        int[] sum = twoSum(testNums, target);
        System.out.println(Arrays.toString(sum));
    }
}
