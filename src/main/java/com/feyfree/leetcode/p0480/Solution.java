package com.feyfree.leetcode.p0480;

import java.util.PriorityQueue;

/**
 * 480. 滑动窗口中位数
 *
 * @author leilei
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int windowNumber = length - k + 1;
        double[] result = new double[windowNumber];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < windowNumber; i++) {
            // pop and add
            if (i != 0) {
                queue.remove(nums[i - 1]);
                queue.add(i + k - 1);
            }
            result[i] = getMedian(queue);
        }
        return result;
    }


    private double getMedian(PriorityQueue<Integer> queue) {
        Object[] array = queue.toArray();
        int i = 0;
        int j = queue.size();
        while (i < j) {
            i++;
            j--;
            if (i == j) {
                return Integer.parseInt(array[i].toString());
            }
            if (i > j) {
                return (Integer.parseInt(array[i].toString()) + Integer.parseInt(array[j].toString())) / 2.0;
            }
        }
        return Integer.parseInt(array[i].toString());
    }


    /**
     * 获取中位数
     *
     * @param nums  访问数组
     * @param start 开始 闭区间
     * @param end   结束 闭区间
     * @return
     */
    private double getMedian(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            i++;
            j--;
            if (i == j) {
                return nums[i];
            }
            if (i > j) {
                return (nums[i] + nums[j]) / 2.0;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int[] data = new int[2];
        System.out.println(data[0]);
    }
}
