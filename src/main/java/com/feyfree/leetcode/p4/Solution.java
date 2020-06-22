package com.feyfree.leetcode.p4;

/**
 * median-of-two-sorted-arrays
 * 两个正序数组的中位数
 * <p>
 * 要求时间复杂 在 log(m + n) 中间
 * <p>
 * 思路: 线性扫描算法， 因为已经是有序数组了
 *
 * @author leilei
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        assert m > 0;
        assert n > 0;
        // b 数组循环 下标开始
        int scanStart = 0;
        // 记录的步长
        int step = 0;
        //  目标步长
        int targetStep = (m + n) / 2;
        // 奇偶标志 true 表示为奇数  false 表示偶数  奇数需要再访问一步
        boolean oddFlag = (m + n) % 2 == 1;
        for (int i = 0; i < nums1.length; i++) {
            if (step == targetStep) {
                return getMedianTargetOrNextValue(nums1, nums2, oddFlag, i, scanStart);
            }
            // 线性扫描   扫描出 需要定位的value
            int scanValue = nums1[i];
            // 如果达到步长
            // odd:   target.next.value
            // even:  target.next.value  + target.value
            if (scanValue <= nums2[scanStart]) {
                step += 1;
            }
            for (int j = scanStart; j < n; j++) {
                step += 1;
                if (step == targetStep) {
                    return getMedianTargetOrNextValue(nums2, nums1, oddFlag, j, i);
                }
                if (nums2[j] >= scanValue) {
                    scanStart = j;
                    break;
                }
            }
        }
        return 0;
    }

    private static double getMedianTargetOrNextValue(int[] preNums, int[] otherNums, boolean oddFlag, int preIndex, int otherIndex) {
        if (oddFlag) {
            if (preIndex + 1 == preNums.length) {
                return otherNums[otherIndex + 1];
            }
            if (otherIndex + 1 == otherNums.length) {
                return preNums[preIndex + 1];
            }
            return Math.min(preNums[preIndex + 1], otherNums[otherIndex + 1]);
        } else {
            if (preIndex + 1 == preNums.length) {
                return (double) (preNums[preIndex] + otherNums[otherIndex]) / 2;
            }
            if (otherIndex + 1 == otherNums.length) {
                return (double) (preNums[preIndex] + preNums[preIndex + 1]) / 2;
            }
            return (double) (preNums[preIndex] + preNums[preIndex + 1]) / 2;
        }
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6};
        int[] b = {1, 2, 4, 9};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
