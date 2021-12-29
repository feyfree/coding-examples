package com.feyfree.leetcode.p0330;

/**
 * https://leetcode-cn.com/problems/patching-array/
 * 330. 按要求补齐数组
 *
 * @author leilei
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        // 最大能拼接出来的范围
        long range = 0;
        int length = nums.length;
        // 需要增加的数量
        int result = 0;
        // 下一个数字
        long i = 1;
        // 数组中的索引
        int pos = 0;
        while (i <= n) {
            if (pos >= length || i < nums[pos]) {
                result++;
                range += i;
            } else {
                range += nums[pos];
                pos++;
            }
            i = range + 1;
        }
        return result;
    }
}
