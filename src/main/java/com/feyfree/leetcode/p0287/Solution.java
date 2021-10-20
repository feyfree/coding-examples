package com.feyfree.leetcode.p0287;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 287. 寻找重复数
 * bit operation
 *
 * @author leilei
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] <<= 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] >> 1;
            if ((nums[index] & 1) == 1) {
                // 重复的数字
                result = index;
            } else {
                nums[index] |= 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] >>= 1;
        }
        return result;
    }
}
