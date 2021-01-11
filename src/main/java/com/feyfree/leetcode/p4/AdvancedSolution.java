package com.feyfree.leetcode.p4;

import java.util.Arrays;

/**
 * 寻找中位数 优化算法
 * <p>
 * Hint By huahua
 *
 * @author leilei
 */
public class AdvancedSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            // 保证nums1 的数组长度 小于 nums2 的数组长度
            return findMedianSortedArrays(nums2, nums1);
        }
        // 中位数的index 用来拆解子数组的index
        int k = (n1 + n2 + 1) / 2;
        // 计算nums1 的 m1 位置
        int l = 0;
        // nums1[] 的长度
        int r = n1;


        while (l < r) {
            // 二分法定位 m1 的 位置
            int m1 = l + (r - l) / 2;
            // m2 的位置
            int m2 = k - m1;
            // 如果 V1(m1 - 1 + 1) 大于 V2(m2 -1) 说明第一个数组取少了
            if (nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            }
            // 否则是第一个数组取多了 适当减少
            else {
                r = m1;
            }
        }

        int m1 = l;
        int m2 = k - l;

        System.out.print("nums1:");
        System.out.println(Arrays.toString(nums1));
        System.out.print("nums2:");
        System.out.println(Arrays.toString(nums2));
        System.out.println("两个数组的k值: " + k);
        System.out.println("数组1的中间m1值: " + m1);
        System.out.println("数组2的中间m2值: " + m2);



        // c1 相当于 V1(m1 -1) 和 V2(m2 - 1) 的最大值， 作为终点
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        // 如果是奇数 直接返回 c1
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }

        // 如果是偶数 则返回 最小值 表示为 k 的终点
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }

    public static void main(String[] args) {
        AdvancedSolution solution = new AdvancedSolution();
        int[] nums1 = {1, 4};
        int[] nums2 = {2, 3};
        solution.findMedianSortedArrays(nums1, nums2);
    }
}
