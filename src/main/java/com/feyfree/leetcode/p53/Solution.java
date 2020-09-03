package com.feyfree.leetcode.p53;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 思路: 线性扫描算法
 *
 * @author leilei
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        boolean belowZero = true;
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0) {
                belowZero = false;
                break;
            }
            m = Math.max(m, num);
        }
        if (belowZero) {
            return m;
        }
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int num : nums) {
            maxEndingHere = Math.max(maxEndingHere + num, 0);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1};
        System.out.println(solution.maxSubArray(nums));
    }

}
