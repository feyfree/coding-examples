package com.feyfree.basic.sort;

import java.util.Arrays;

/**
 * 快排实现2
 *
 * @author leilei
 */
public class QuickSort2 {

    private final int[] nums;


    public QuickSort2(int[] nums) {
        this.nums = nums;
    }

    public void sort(int l, int u) {
        if (l >= u) {
            return;
        }
        int m = l;
        for (int i = l + 1; i <= u; i++) {
            if (nums[i] < nums[l]) {
                m++;
                swap(m, i);
            }
        }
        swap(l, m);
        sort(l, m - 1);
        sort(m + 1, u);
    }

    private void swap(int m, int n) {
        int swap = nums[m];
        nums[m] = nums[n];
        nums[n] = swap;
    }

    public static void main(String[] args) {
        int[] data = {1, 9, 4, 7, 12, 0, 8, 2, 3};
        QuickSort2 sort2
                = new QuickSort2(data);
        sort2.sort(0, data.length - 1);
        System.out.println(Arrays.toString(sort2.nums));
    }
}
