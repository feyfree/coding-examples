package com.feyfree.leetcode.p0480;

import java.util.Arrays;

/**
 * 480. 滑动窗口中位数
 * 插入排序 - 当 k 量级比较小时， 时间差异不大
 * 可以通过
 * https://zxi.mytechroad.com/blog/algorithms/array/leetcode-480-sliding-window-median/
 *
 * @author leilei
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new double[0];
        }
        double[] ans = new double[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; ++i) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        for (int i = k; i <= nums.length; ++i) {
            // 这地方可能存在
            ans[i - k] = ((double) window[k / 2] + window[(k - 1) / 2]) / 2;
            if (i == nums.length) {
                break;
            }
            remove(window, nums[i - k]);
            insert(window, nums[i]);
        }
        return ans;
    }


    /**
     * 插入数据
     *
     * @param window 窗口
     * @param val    需要插入的数据
     */
    private void insert(int[] window, int val) {
        int i = 0;
        while (i < window.length - 1 && val > window[i]) {
            ++i;
        }
        int j = window.length - 1;
        // 相当于后移
        while (j > i) {
            window[j] = window[--j];
        }
        window[j] = val;
    }

    /**
     * 移除数据
     *
     * @param window 窗口
     * @param val    需要移除的值
     */
    private void remove(int[] window, int val) {
        int i = 0;
        while (i < window.length && val != window[i]) {
            ++i;
        }
        while (i < window.length - 1) {
            window[i] = window[++i];
        }
    }
}
