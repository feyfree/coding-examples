package com.feyfree.leetcode.p57;

import java.util.LinkedList;
import java.util.List;

/**
 * 57
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 用java 处理多维数组太麻烦  这个利用 56 题的结论操作
 *
 * @author leilei
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> data = new LinkedList<>();
        List<int[]> result = new LinkedList<>();
        // 将 数组转化成 列表 进行复制
        for (int[] interval : intervals) {
            // 判断什么时候插入new interval
            if (interval[0] >= newInterval[0]) {
                // 先插入 newInterval
                data.add(newInterval);
            }
            data.add(interval);
        }
        if (data.size() == intervals.length) {
            data.add(newInterval);
        }
        for (int[] interval : data) {
            if (result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] =  Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        // list to array
        int[][] output = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}
