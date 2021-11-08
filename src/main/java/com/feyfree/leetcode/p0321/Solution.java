package com.feyfree.leetcode.p0321;

/**
 * https://leetcode-cn.com/problems/create-maximum-number/
 * 321. 拼接最大数
 *
 * @author leilei
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // 第一个数绝对要最大, 并且能取到第一个数后， 后续也要能满足要求(递归的问题)
        int[] result = new int[k];
        // 相当于是DP数组, 计算i之前最大的数字所在的索引, 如果数字相同记录最新的索引
        int[] max1 = new int[nums1.length];
        int[] max2 = new int[nums2.length];
        fillMax(nums1, max1);
        fillMax(nums2, max2);
        while (k > 0) {
            // 表示上一次取得值
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                // calculate remaining

            }
        }
        return null;


    }

    private void fillMax(int[] nums2, int[] max2) {
        for (int i = 1; i < nums2.length; i++) {
            int current = nums2[i];
            if (current >= max2[i - 1]) {
                max2[i] = i;
            } else {
                max2[i] = max2[i - 1];
            }
        }
    }
}
