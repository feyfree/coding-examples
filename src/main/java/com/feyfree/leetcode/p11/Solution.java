package com.feyfree.leetcode.p11;

/**
 * 盛水最多的容器
 * <p>
 * container-with-most-water
 *
 * @author leilei
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int tempCapacity = 0;
        while (start <= end) {
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