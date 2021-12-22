package com.feyfree.leetcode.p0376;

/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * @author leilei
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 考虑 [0, 0] 的情况
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(solution.wiggleMaxLength(data));
    }
}
