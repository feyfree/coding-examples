package com.feyfree.basic.sort;

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
        if (hi + 1 - lo >= 0) {
            System.arraycopy(data, lo, aux, lo, hi + 1 - lo);
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                data[k] = aux[j++];
            } else if (j > hi) {
                data[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                // j++ 没有return 值 所以 data[k] = aux[j++] -> data[k] = aux[j] , j +=1
                data[k] = aux[j++];
            } else {
                data[k] = aux[i++];
            }
        }
    }
}
