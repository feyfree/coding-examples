package com.feyfree.basic.sort;

import java.util.List;

/**
 * 自下而上归并排序
 *
 * @author leilei
 */
public class MergeSortBU {
    public void sort(int[] data) {

    }

    public void merge(int[] data, int[] aux, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0) {
            System.arraycopy(data, lo, aux, lo, hi + 1 - lo);
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                data[k] = aux[j++];
            }
        }
    }
}
