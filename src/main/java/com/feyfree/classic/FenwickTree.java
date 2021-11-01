package com.feyfree.classic;

import java.util.Arrays;

/**
 * @author leilei
 */
public class FenwickTree {

    private final int[] nums;

    private final int[] dp;

    public FenwickTree(int[] nums) {
        this.nums = nums;
        this.dp = new int[4 * nums.length];
    }

    public void build(int s, int t, int p) {
        if (s == t) {
            dp[p] = nums[s];
            return;
        }
        int m = s + ((t - s) >> 1);
        build(s, m, p * 2);
        build(m + 1, t, p * 2 + 1);
        dp[p] = dp[p * 2] + dp[2 * p + 1];
    }

    public static void main(String[] args) {
        int[] data = new int[]{10, 11, 12, 13, 14};
        FenwickTree tree = new FenwickTree(data);
        // 有一种类似堆的性质， 但是堆一般是从 下标为1 开始的
        tree.build(0, data.length - 1, 1);
        System.out.println(Arrays.toString(tree.dp));
    }
}
