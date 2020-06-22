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
        if (m == 0) {
            // find nums2
            if (n != 0) {
                return (double) (nums2[n / 2] + nums2[(n - 1) / 2]) / 2;
            }
            return 0;
        }
        if (n == 0) {
            return (double) (nums1[m / 2] + nums1[(m - 1) / 2]) / 2;
        }
        // 记录的步长
        int step = 0;
        //  目标步长
        int targetStep = (m + n) / 2;
        // 奇偶标志 true 表示为奇数  false 表示偶数  奇数需要再访问一步
        boolean oddFlag = (m + n) % 2 == 1;
        int visitedPlaceA = -1;
        int visitedPlaceB = -1;
        for (int i = 0; i < nums1.length; i++) {
            int scanValue = nums1[i];
            boolean visited = false;
            if (visitedPlaceB + 1 < n && scanValue <= nums2[visitedPlaceB + 1]) {
                visitedPlaceA = i;
                visited = true;
                step += 1;
                if (step == targetStep) {
                    return getMedianTargetOrNextValue(nums2, nums1, oddFlag, visitedPlaceB, visitedPlaceA);
                }
            }
            for (int j = visitedPlaceB + 1; j < n; j++) {
                boolean needVisit = nums2[j] <= scanValue || (i + 1) == m;
                if (needVisit) {
                    if (nums2[j] >= scanValue) {
                        visited = true;
                        step += 1;
                        visitedPlaceA = i;
                        if (step == targetStep) {
                            return getMedianTargetOrNextValue(nums2, nums1, oddFlag, visitedPlaceB, visitedPlaceA);
                        }
                    }
                    step += 1;
                    visitedPlaceB = j;
                    if (step == targetStep) {
                        return getMedianTargetOrNextValue(nums1, nums2, oddFlag, visitedPlaceA, visitedPlaceB);
                    }
                }
            }
            if (!visited) {
                step += 1;
                visitedPlaceA = i;
                if (step == targetStep) {
                    return getMedianTargetOrNextValue(nums2, nums1, oddFlag, visitedPlaceB, visitedPlaceA);
                }
            }
        }
        return 0;
    }

    /**
     * 构建中间值
     * <p>
     * 默认last step 在 otherNums 数组
     * <p>
     * 也就是otherIndex 是 target step 的位置
     * <p>
     * 如果达到步长
     * odd:   target.next.value
     * even:  target.next.value  + target.value
     *
     * @param preNums      前一个数组
     * @param otherNums    后一个数组
     * @param oddFlag      奇偶标志
     * @param preVisited   上一个visited 的 index
     * @param otherVisited 下一个visited 的 index
     * @return 中位数
     */
    private static double getMedianTargetOrNextValue(int[] preNums,
                                                     int[] otherNums,
                                                     boolean oddFlag,
                                                     int preVisited,
                                                     int otherVisited) {
        if (oddFlag) {
            if (preVisited + 1 == preNums.length) {
                return otherNums[otherVisited + 1];
            }
            if (otherVisited + 1 == otherNums.length) {
                return preNums[preVisited + 1];
            }
            return Math.min(preNums[preVisited + 1], otherNums[otherVisited + 1]);
        } else {
            if (preVisited + 1 == preNums.length) {
                return (double) (otherNums[otherVisited + 1] + otherNums[otherVisited]) / 2;
            }
            if (otherVisited + 1 == otherNums.length) {
                return (double) (otherNums[otherVisited] + preNums[preVisited + 1]) / 2;
            }
            return (double) (Math.min(otherNums[otherVisited + 1], preNums[preVisited + 1]) + otherNums[otherVisited]) / 2;
        }
    }


    public static void main(String[] args) {
//
        int[] a = {3, 4, 5, 6};
        int[] b = {1, 2, 4, 9};
        System.out.println(findMedianSortedArrays(a, b));

        int[] c = {1, 2};
        int[] d = {3, 4};
        System.out.println(findMedianSortedArrays(c, d));

        int[] e = {1, 2};
        int[] f = {1};
        System.out.println(findMedianSortedArrays(e, f));

        int[] g = {1};
        int[] h = {2, 3, 4};
        System.out.println(findMedianSortedArrays(g, h));
//

        int[] caseB = {0, 0};
        int[] caseA = {0, 0};
        System.out.println(findMedianSortedArrays(caseA, caseB));
    }
}
