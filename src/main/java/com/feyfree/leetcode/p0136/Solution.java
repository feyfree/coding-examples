package com.feyfree.leetcode.p0136;


/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author leilei
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
