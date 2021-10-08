package com.feyfree.leetcode.p0260;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 260. 只出现一次的数字 III
 *
 * @author leilei
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int ret = 0;
        // 全部异或
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        // 找到不为 0 的一位 进行分组
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
