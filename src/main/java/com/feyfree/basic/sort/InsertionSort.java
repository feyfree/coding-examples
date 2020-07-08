package com.feyfree.basic.sort;


import java.util.Arrays;

/**
 * 插入排序
 *
 * @author leilei
 */
public class InsertionSort {
    public void sort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int m, int n) {
        int swap = nums[m];
        nums[m] = nums[n];
        nums[n] = swap;
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] nums = {3, 1, 2, 5, 9, 4};
        sort.sort(nums);
    }

}
