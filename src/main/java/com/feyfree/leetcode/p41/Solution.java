package com.feyfree.leetcode.p41;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * <p>
 * 思路: 时间复杂度是O(n) 考虑线性扫描算法
 *
 * @author leilei
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int minValue = 0;
        int target = 1;
        int maxValue = 0;
        for (int item : nums) {
            if (item > 0) {
                if (item == target) {
                    if (minValue == target) {
                        target = minValue + 1;
                    } else {

                    }
                }
            }
        }
        return target == maxValue ? target + 1 : target;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.firstMissingPositive(new int[]{4, 2, 1});
        System.out.println(i);
    }

}