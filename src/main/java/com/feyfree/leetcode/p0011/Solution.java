package com.feyfree.leetcode.p0011;

/**
 * 盛水最多的容器
 * <p>
 * container-with-most-water
 * <p>
 * 区间容量取决于开始和结束的 短板 * 间隔
 *
 * @author leilei
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        // 区间起点
        int start = 0;
        // 区间结束
        int end = height.length - 1;
        // 最终容量
        int tempCapacity = 0;
        while (start <= end) {
            // 如果末尾的高度高于开始的高度  则开始的高度  ++1
            if (height[end] > height[start]) {
                int cal = (end - start) * height[start];
                tempCapacity = Math.max(cal, tempCapacity);
                start++;
            } else {
                tempCapacity = Math.max(tempCapacity, (end - start) * height[end]);
                end--;
            }
        }
        return tempCapacity;
    }
}