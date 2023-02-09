package com.feyfree.basic.sort;

/**
 * 自下而上归并排序
 *
 * @author leilei
 */
public class MergeSortBU {
    public void sort(int[] data) {
        int n = data.length;
        int[] aux = new int[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += 2 * len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + 2 * len - 1, n - 1);
                merge(data, aux, lo, mid, hi);
            }
        }
    }

    /**
     * @param data 原先的数据
     * @param aux  辅助数组
     * @param lo
     * @param mid
     * @param hi
     */
    public void merge(int[] data, int[] aux, int lo, int mid, int hi) {
        // 闭区间长度 所以需要 +1
        if (hi + 1 - lo >= 0) {
            // 拷贝到 aux 数组(辅助数组)
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
