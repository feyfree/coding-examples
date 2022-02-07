package com.feyfree.leetcode.p0435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * @author leilei
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        // 按照区间起点 排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 记录非交叉区间的个数
        int count = 1;
        // 记录区间分割点
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
}
