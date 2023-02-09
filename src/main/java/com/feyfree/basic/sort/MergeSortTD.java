package com.feyfree.basic.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 自顶向下排序
 *
 * @author leilei
 */
public class MergeSortTD {
    public void sort(int[] data, int[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(data, aux, lo, mid);
        sort(data, aux, mid + 1, hi);
        merge(data, aux, lo, mid, hi);
    }

    public void sort(int[] data) {
        int[] aux = new int[data.length];
        sort(data, aux, 0, data.length - 1);
    }

    public void merge(int[] data, int[] aux, int lo, int mid, int hi) {
        if (hi - lo + 1 >= 0) {
            System.arraycopy(data, lo, aux, lo, hi + 1 - lo);
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // i, j 的越界问题
            if (i <= mid && j <= hi) {
                if (aux[i] > aux[j]) {
                    data[k] = aux[j];
                    j++;
                } else {
                    data[k] = aux[i];
                    i++;
                }
            } else if (i > mid) {
                data[k] = aux[j];
                j++;
            } else {
                data[k] = aux[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortTD td = new MergeSortTD();
        int[] data = new int[]{1, 3, 9, 6, 5, 7, 0};
        td.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
