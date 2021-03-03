package com.feyfree.leetcode.p0088;

/**
 * p88 - 合并两个有序数组
 *
 * @author leilei
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        m -= 1;
        n -= 1;
        while (end >= 0 && m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[end] = nums1[m];
                m -= 1;
            } else {
                nums1[end] = nums2[n];
                n -= 1;
            }
            end -= 1;
        }
        while (n >= 0) {
            nums1[end] = nums2[n];
            end -= 1;
            n -= 1;
        }
    }
}