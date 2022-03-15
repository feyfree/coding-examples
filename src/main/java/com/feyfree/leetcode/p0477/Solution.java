package com.feyfree.leetcode.p0477;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/total-hamming-distance/
 *
 * @author leilei
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    result += countBit(nums[i] ^ nums[j]);
//                    result += Integer.bitCount(nums[i] ^ nums[j]);
                }
            }
        }
        return result;
    }

    /**
     * 计算 num 的 1 的位数
     * 可以使用Integer.bitCount()
     *
     * @param num 输入
     * @return 1 的位数
     */
    private int countBit(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
