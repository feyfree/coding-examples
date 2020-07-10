package com.feyfree.basic.sort;

import com.feyfree.algs4.StdRandom;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author leilei
 */
public class QuickSort {

    public void sort(int[] nums) {
//        StdRandom.shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int partition = partition(nums, lo, hi);
        sort(nums, lo, partition - 1);
        sort(nums, partition + 1, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = data[lo];
        while (true) {
            while (data[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < data[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);
        }
        swap(data, lo, j);
        return j;
    }

    private void swap(int[] nums, int m, int n) {
        int swap = nums[m];
        nums[m] = nums[n];
        nums[n] = swap;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] data = {1, 9, 4, 7, 12, 0, 8, 2, 3};
        System.out.println(Arrays.toString(data));
        quickSort.sort(data);
        System.out.println(Arrays.toString(data));


    }

}
