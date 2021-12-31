package com.feyfree.leetcode.p0334;

/**
 * 优化解法  数组压缩
 *
 * @author leilei
 */
public class SimpleSolution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] high = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            high[i] = i == n - 1 ? nums[i] : Math.max(high[i + 1], nums[i]);
        }
        int low = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > low && nums[i] < high[i]) {
                return true;
            }
            low = Math.min(low, nums[i]);
        }
        return false;
    }
}
