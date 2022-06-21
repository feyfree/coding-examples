package com.feyfree.leetcode.p0416;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 *
 * @author leilei
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }


    private void printClassName() {
        System.out.println(this.getClass().getSimpleName());
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 5};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(ints));
        solution.printClassName();
    }

}
