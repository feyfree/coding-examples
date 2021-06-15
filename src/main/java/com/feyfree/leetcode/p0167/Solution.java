package com.feyfree.leetcode.p0167;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author leilei
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int a = numbers[start];
            int b = numbers[end];
            if (b < target - a) {
                start++;
            } else if (b > target - a) {
                end--;
            } else {
                break;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}
