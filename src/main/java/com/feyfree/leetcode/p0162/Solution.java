package com.feyfree.leetcode.p0162;

/**
 * 162. 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 * 题目有个条件 相邻元素不相等
 *
 * @author leilei
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            // Find the first m s.t. num[m] > num[m + 1]
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

