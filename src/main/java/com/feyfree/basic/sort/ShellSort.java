package com.feyfree.basic.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author leilei
 */
public class ShellSort {
    public void sort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int h = 1;
        int n = nums.length;
        // 构建h
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        // h - sort
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j > 0 && nums[j] < nums[j - h]; j = j - h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int m, int n) {
        int swap = nums[m];
        nums[m] = nums[n];
        nums[n] = swap;
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] nums = {3, 1, 2, 5, 9, 4};
        sort.sort(nums);
    }
}
