package com.feyfree.leetcode.p57;

import java.util.*;

/**
 * p57 插入区间 解法跟合并区间类似
 *
 * @author leilei
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 首先是排序 按照 start 升序排列
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // 构建一个链表
        List<List<Integer>> result = new LinkedList<>();
        for (int[] interval : intervals) {
            List<Integer> data = new ArrayList<>(2);
            data.add(interval[0]);
            data.add(interval[1]);
            result.add(data);
        }
        return null;


    }
}
