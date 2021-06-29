package com.feyfree.leetcode.p0179;


import java.util.Arrays;

/**
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author leilei
 */
public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsString = new String[n];
        for (int i = 0; i < n; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, (a, b) -> (b + a).compareTo(a + b));
        //如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if ("0".equals(numsString[0])) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numsString[i]);
        }
        return sb.toString();
    }
}