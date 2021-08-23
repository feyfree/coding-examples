package com.feyfree.leetcode.p0215;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 215. 数组中的第K个最大元素
 *
 * @author leilei
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(data, 2));
    }
}
