package com.feyfree.leetcode.p0053;


/**
 * 分治算法
 *
 * @author leilei
 */
public class DivideSolution {
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
        return maxSum3(0, nums.length - 1, nums);

    }

    private int maxSum3(int l, int u, int[] nums) {
        int sum = 0, lmax = 0;
        if (l > u) {
            return 0;
        }
        if (l == u) {
            return Math.max(0, nums[l]);
        }
        int m = (l + u) / 2;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            lmax = Math.max(lmax, sum);
        }
        int rmax = 0;
        sum = 0;
        for (int i = m + 1; i <= u; i++) {
            sum += nums[i];
            rmax = Math.max(rmax, sum);
        }
        return Math.max(Math.max(lmax + rmax, maxSum3(0, m, nums)), maxSum3(m + 1, u, nums));
    }


    public static void main(String[] args) {
        DivideSolution solution = new DivideSolution();
        int[] nums = {1, -1, -2};
        System.out.println(solution.maxSubArray(nums));
    }
}
