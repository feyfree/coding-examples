package com.feyfree.leetcode.p0164;

import java.util.Arrays;

/**
 * 164. 最大间距
 * https://leetcode-cn.com/problems/maximum-gap/
 * <p>
 * 暴力解法
 *
 * @author leilei
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int gap = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(Math.abs(nums[i] - nums[i - 1]), gap);
        }
        return gap;
    }
}
