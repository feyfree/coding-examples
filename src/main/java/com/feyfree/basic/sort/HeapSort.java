package com.feyfree.basic.sort;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * 堆排序使用的索引 默认从1 开始， 但是对于实际数组的操作需要 用 索引 - 1 去更新
 * <p>
 * 外部Index  ->  内部index  (Index = index + 1)
 * <p>
 * 1. 构建堆  (前 n / 2 进行下沉操作)
 * 2. 进行下沉操作(首尾变化， 然后对前面的数组进行循环下沉)
 *
 * @author leilei
 */
public class HeapSort {
    public void sort(int[] data) {
        System.out.println(Arrays.toString(data));
        int n = data.length;
        // 构建有序的堆
        for (int k = n / 2; k >= 1; k--) {
            // 注意这里的 索引函数 k = index + 1
            // 下沉操作, 保证 data.k >= data.2k且 data.k >= data.(2k + 1)
            sink(data, k, n);
        }
        System.out.println("---after-sink-phase---");
        System.out.println(Arrays.toString(data));
        int scope = n;
        while (scope > 1) {
            // 第一位永远是 sink 范围内 (scope)的最大的数
            // 替换到后面
            swap(data, 1, scope--);
            // 继续维护有序堆
            sink(data, 1, scope);
        }
        System.out.println("---final-data---");
        System.out.println(Arrays.toString(data));
    }

    private void sink(int[] data, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(data, j, j + 1)) {
                j++;
            }
            if (!less(data, k, j)) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    public void swap(int[] nums, int m, int n) {
        int swap = nums[m - 1];
        nums[m - 1] = nums[n - 1];
        nums[n - 1] = swap;
    }

    private boolean less(int[] nums, int i, int j) {
        return nums[i - 1] < nums[j - 1];
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {3, 1, 2, 5, 9, 4};
        heapSort.sort(nums);
    }



}
