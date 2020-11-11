package com.feyfree.leetcode.p152;

/**
 * 递归解法
 *
 * @author leilei
 */
public class RecursionSolution {
    public int maxProduct(int[] nums) {
        return maxResult(nums[0], nums[0], nums, 1, nums[0]);
    }

    private int maxResult(int minResult, int maxResult, int[] nums, int i, int temp) {
        if (i > nums.length - 1) {
            return temp;
        }
        int maxTemp = maxResult;
        maxResult = Math.max(Math.max(maxTemp * nums[i], minResult * nums[i]), nums[i]);
        minResult = Math.min(Math.min(maxTemp * nums[i], minResult * nums[i]), nums[i]);
        temp = Math.max(maxResult, temp);
        return maxResult(minResult, maxResult, nums, ++i, temp);
    }

    public static void main(String[] args) {
        int[] data = {-4, -3, -2};
        RecursionSolution solution = new RecursionSolution();
        System.out.println(solution.maxProduct(data));
    }
}
