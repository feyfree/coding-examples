package com.feyfree.basic.sort;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author leilei
 */
public class SelectionSort {
    public void sort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int m, int n) {
        int swap = nums[m];
        nums[m] = nums[n];
        nums[n] = swap;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] nums = {3, 1, 2, 5, 9, 4};
        sort.sort(nums);
    }
}
