package com.feyfree.leetcode.p0495;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int start = 0;
        while (start < timeSeries.length) {
            int attack = timeSeries[start];
            if (start + 1 >= timeSeries.length) {
                result += duration;
            } else {
                result += Math.min(duration, timeSeries[start + 1] - attack);
            }
            start++;
        }
        return result;
    }
}
